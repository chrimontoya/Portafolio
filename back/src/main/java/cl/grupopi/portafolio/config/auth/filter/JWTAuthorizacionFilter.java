package cl.grupopi.portafolio.config.auth.filter;

import cl.grupopi.portafolio.config.auth.filter.service.IJwtService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JWTAuthorizacionFilter extends BasicAuthenticationFilter {
    private IJwtService jwtService;
    public JWTAuthorizacionFilter(AuthenticationManager authenticationManager, IJwtService jwtService) {
        super(authenticationManager);
        this.jwtService = jwtService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {

        String header = request.getHeader("Authorization");

        if(!requiresAuthentication(header)){
            chain.doFilter(request, response);
            return;
        }

        UsernamePasswordAuthenticationToken authenticationToken = null;

        if (jwtService.validate(header)){
            authenticationToken = new UsernamePasswordAuthenticationToken(jwtService.getUsername(header), jwtService.getClaims(header), jwtService.getRoles(header));
            System.out.println(authenticationToken.getPrincipal() + "" + authenticationToken.getCredentials());
            System.out.println(authenticationToken.isAuthenticated());
            response.setStatus(200);
        }

        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        chain.doFilter(request, response);
    }
    protected boolean requiresAuthentication(String header) {
        if (header == null || !header.startsWith("Bearer ")) {
            return false;
        }
        return true;
    }




}
