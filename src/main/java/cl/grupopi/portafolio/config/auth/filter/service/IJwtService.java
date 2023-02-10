package cl.grupopi.portafolio.config.auth.filter.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.jsonwebtoken.Claims;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.io.IOException;
import java.util.Collection;

public interface IJwtService {
    String create(Authentication authentication) throws IOException;
    Boolean validate(String token);
    Claims getClaims(String token);
    String getUsername(String token);
    Collection<? extends GrantedAuthority> getRoles(String token) throws IOException;
    String resolve(String token);
}
