package cl.grupopi.portafolio.config.auth.filter;

import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static cl.grupopi.portafolio.config.SpringSecurityConfig.passwordEncoder;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private AuthenticationManager authenticationManager;

    public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.setAuthenticationManager(authenticationManager);
    }

/*    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {

        String username = obtainUsername(request);
        String password = obtainPassword(request);

        if(username == null){
            username = "";
        }

        if(password == null){
            password = "";
        }

        if(username != null && password != null){
            logger.info("Username and password: " + username + " " + password);
        }

        username = username.trim();

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username,password);

        return authenticationManager.authenticate(authenticationToken);
    }*/

    @Bean
    public UserDetailsService userDetailsService(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String username = obtainUsername(request);
        String password = obtainPassword(request);

        if(username == null){
            username = "";
        }

        if(password == null){
            password = "";
        }

        if(username != null && password != null){
            logger.info("Username and password: " + username + " " + password);
        }

        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername(username).password(password).roles("USER").build());

        return manager;
    }
}
