package org.mapleLand.maplelanbackserver.jwtUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.Getter;

import javax.crypto.SecretKey;
import java.util.Date;

@Getter
public class JwtUtil {

    @Getter
    private static final SecretKey secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    public static String createToken(String discordId,String username,String
            avatar,String globalName,String role,int userId) {
        Claims claims = Jwts.claims();
        claims.put("id", discordId);
        claims.put("avatar", avatar);
        claims.put("username", username);
        claims.put("globalName", globalName);
        claims.put("role", role);
        claims.put("userId", userId);

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
    // 새로 추가하는 리프레시 토큰 생성 메서드
    public static String createRefreshToken(String discordId) {
        Claims claims = Jwts.claims();
        claims.put("id", discordId);  // 꼭 필요한 식별자만

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000L * 60 * 60 * 24 * 7)) // 7일
                .signWith(secretKey)
                .compact();
    }
}
