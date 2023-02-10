package cl.grupopi.portafolio.config.auth.filter;

import cl.grupopi.portafolio.config.auth.filter.service.IJwtService;
import cl.grupopi.portafolio.models.entity.UserAuth;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private AuthenticationManager authenticationManager;
    private IJwtService jwtService;

    public JWTAuthenticationFilter(AuthenticationManager authenticationManager, IJwtService jwtService) {
        this.authenticationManager = authenticationManager;
        setRequiresAuthenticationRequestMatcher(new AntPathRequestMatcher("/api/v1/login","POST"));

        this.jwtService = jwtService;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {

        UserAuth usuario;
        try {
            usuario = new ObjectMapper().readValue(request.getInputStream(), UserAuth.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(usuario.getUsername(), usuario.getPassword());

        System.out.println("user:" + usuario.getUsername() + " " + usuario.getPassword());

        return authenticationManager.authenticate(authenticationToken);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException {

        System.out.println("ok");
        String token = jwtService.create(authResult);
        response.addHeader("Authorization","Bearer" + token);

        Map<String, Object> body = new HashMap<String, Object>();
        body.put("token",token);
        body.put("user",authResult.getPrincipal());
        body.put("messages","User authenticated");

        response.getWriter().write(new ObjectMapper().writeValueAsString(body));
        response.setStatus(200);
        response.setContentType("application/json");
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException {
        Map<String, Object> body = new HashMap<String, Object>();
        body.put("status","error");
        body.put("code","401");
        body.put("messages","User or password incorrect");

        response.getWriter().write(new ObjectMapper().writeValueAsString(body));
        response.setStatus(401);
        response.setContentType("application/json");
    }


}
