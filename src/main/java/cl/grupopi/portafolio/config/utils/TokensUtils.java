package cl.grupopi.portafolio.config.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import java.security.Key;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TokensUtils {

   /* private final static String ACCESS_TOKEN_SECRET = "HOLAMUNDOXD";*/
    public static final Key SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS512);
    private final static Long ACCESS_TOKEN_VALIDITY_SECONDS = 2_592_000L;

    public static String createToken(String username, String password){
        long expirationTime = ACCESS_TOKEN_VALIDITY_SECONDS * 1_000;
        Date expirationDate = new Date(System.currentTimeMillis() + expirationTime);

        Map<String, Object> extra = new HashMap<>();
        extra.put("username",username);


        return Jwts.builder().setSubject(password).setExpiration(expirationDate).addClaims(extra).signWith(SECRET_KEY)
                .compact();
    }

    public static UsernamePasswordAuthenticationToken getAuthentication(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(SECRET_KEY)
                .build().parseClaimsJws(token)
                .getBody();
        String password = claims.getSubject();

        return new UsernamePasswordAuthenticationToken(password,null, Collections.emptyList());
    }

}


