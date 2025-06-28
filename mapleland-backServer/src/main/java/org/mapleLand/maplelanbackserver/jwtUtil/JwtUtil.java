package org.mapleLand.maplelanbackserver.jwtUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.util.Date;


public class JwtUtil {

    private static final SecretKey secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    public static String createToken(String discordId,String username,String avatar,String globalName,String role) {
        Claims claims = Jwts.claims();
        claims.put("discordId", discordId);
        claims.put("avatar", avatar);
        claims.put("username", username);
        claims.put("globalName", globalName);
        claims.put("role", role);

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24)) // 1일
                .signWith(secretKey)
                .compact();
    }

    public static Claims getClaims(String token) {

        return Jwts.parserBuilder()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
