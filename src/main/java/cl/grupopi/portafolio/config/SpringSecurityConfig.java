package cl.grupopi.portafolio.config;

import cl.grupopi.portafolio.config.auth.filter.JWTAuthenticationFilter;
import cl.grupopi.portafolio.services.jpaServices.JpaUserDetailsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfig {

    @Autowired
    private JpaUserDetailsServices userDetailsService;
    @Autowired
    private AuthenticationConfiguration authenticationConfiguration;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        System.out.println(new BCryptPasswordEncoder().encode("1234"));
        System.out.println(new BCryptPasswordEncoder().encode("4321"));
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize -> authorize
                        .antMatchers("/h2-console/**", "/login/**").permitAll()
                        .anyRequest().authenticated()
                )
                .addFilter(new JWTAuthenticationFilter(authenticationConfiguration.getAuthenticationManager()))
                .csrf().disable()
                .headers().frameOptions().disable().and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        return http.build();
    }

    public void configurerGlobal(AuthenticationManagerBuilder build) throws Exception {
        build.userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }
}
