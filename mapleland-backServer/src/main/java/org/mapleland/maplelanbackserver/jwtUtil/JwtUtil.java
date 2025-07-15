package org.mapleland.maplelanbackserver.jwtUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.crypto.SecretKey;
import java.util.Date;

@Getter
@RequiredArgsConstructor
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

    public static int getUserId(String token) {
        if (token == null || !token.startsWith("Bearer ")) {
            throw new IllegalArgumentException("❌ 유효하지 않은 Authorization 헤더 형식입니다.");
        }

        try {
            String jwtToken = token.substring(7).trim(); // "Bearer " 제거

            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(secretKey)
                    .build()
                    .parseClaimsJws(jwtToken)
                    .getBody();

            Object idObj = claims.get("userId");
            if (!(idObj instanceof Number number)) {
                throw new IllegalStateException("❌ userId 클레임이 숫자 타입이 아닙니다: " + idObj);
            }

            return number.intValue();

        } catch (JwtException e) {
            throw new IllegalArgumentException("❌ JWT 토큰 디코딩 실패: " + e.getMessage(), e);
        }
    }


}
