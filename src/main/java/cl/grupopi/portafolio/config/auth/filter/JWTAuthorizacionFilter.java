package cl.grupopi.portafolio.config.auth.filter;

import org.springframework.context.annotation.Configuration;

@Configuration
public class JWTAuthorizacionFilter {
/*    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String bearerToken = request.getHeader("Authorization");

        if(bearerToken != null && bearerToken.startsWith("Bearer ")){
            String token = bearerToken.replace("Bearer","");
            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = TokensUtils.getAuthentication(token);
            SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
        }
        filterChain.doFilter(request, response);
    }*/
}
