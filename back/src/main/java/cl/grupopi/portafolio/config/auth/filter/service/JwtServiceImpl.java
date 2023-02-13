package cl.grupopi.portafolio.config.auth.filter.service;

import cl.grupopi.portafolio.config.auth.filter.SimpleGrantedAuthorityMixin;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

@Service
public class JwtServiceImpl implements IJwtService {
    public static final SecretKey SECRET_KEY = new SecretKeySpec("algunaLlaveSecretsfasfasfasfagabafaf".getBytes(), SignatureAlgorithm.HS512.getJcaName());

    @Override
    public String create(Authentication authentication) throws IOException {
        User usuario = (User) authentication.getPrincipal();

        Collection<? extends GrantedAuthority> roles = authentication.getAuthorities();

        Claims claims = Jwts.claims();
        claims.put("authorities", new ObjectMapper().writeValueAsString(roles));

        String token = Jwts.builder()
                .setClaims(claims)
                .setSubject(usuario.getUsername())
                .signWith(SECRET_KEY)
                .compact();
        return token;
    }

    @Override
    public Boolean validate(String token) {
        try {
          getClaims(token);
          return true;
        } catch (JwtException | IllegalArgumentException e){
            return false;
        }
    }

    @Override
    public Claims getClaims(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(SECRET_KEY).build()
                .parseClaimsJws(resolve(token))
                .getBody();
        return claims;
    }

    @Override
    public String getUsername(String token) {
        return getClaims(token).getSubject();
    }

    @Override
    public Collection<? extends GrantedAuthority> getRoles(String token) throws IOException {
        Object roles = getClaims(token).get("authorities");

        Collection<? extends GrantedAuthority> authorities = Arrays.asList(new ObjectMapper()
                .addMixIn(SimpleGrantedAuthority.class, SimpleGrantedAuthorityMixin.class)
                .readValue(roles.toString().getBytes(), SimpleGrantedAuthority[].class));

        return authorities;
    }

    @Override
    public String resolve(String token) {
        if(token != null && token.startsWith("Bearer")){
            return token.replace("Bearer ","");
        }
        return null;
    }
}
