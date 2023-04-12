package cl.grupopi.portafolio.config;

import cl.grupopi.portafolio.config.auth.filter.JWTAuthenticationFilter;
import cl.grupopi.portafolio.config.auth.filter.JWTAuthorizacionFilter;
import cl.grupopi.portafolio.config.auth.filter.service.IJwtService;
import cl.grupopi.portafolio.services.jpaServices.JpaUserDetailsServices;
import org.apache.catalina.filters.CorsFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;
import java.util.List;

@Configuration
public class SpringSecurityConfig implements WebMvcConfigurer {

    @Autowired
    private JpaUserDetailsServices userDetailsService;
    @Autowired
    private AuthenticationConfiguration authenticationConfiguration;

    @Autowired
    private IJwtService jwtService;

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
                        .antMatchers("/h2-console/**", "/api/v1/login").permitAll()
                        .antMatchers("/api/v1/contacts/**").authenticated()
                        .antMatchers("/api/v1/projects/**").authenticated()
                )
                .cors().and()
                .addFilter(new JWTAuthenticationFilter(authenticationConfiguration.getAuthenticationManager(),jwtService))
                .addFilter(new JWTAuthorizacionFilter(authenticationConfiguration.getAuthenticationManager(), jwtService))
                .csrf().disable()
                .headers().frameOptions().disable().and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        return http.build();
    }

    public void configurerGlobal(AuthenticationManagerBuilder build) throws Exception {
        build.userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowedHeaders("*")
                .maxAge(3600);
        System.out.println(registry);
    }
}
