package org.mapleLand.maplelanbackserver.filter;

import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mapleLand.maplelanbackserver.repository.MapleJariUserRepository;
import org.mapleLand.maplelanbackserver.table.MapleJariUserEntity;
import org.mapleLand.maplelanbackserver.jwtUtil.JwtUtil;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;
@Component
@RequiredArgsConstructor
@Slf4j
public class JwtTokenFilter extends OncePerRequestFilter {

    private final MapleJariUserRepository mapleJariUserRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain)
            throws ServletException, IOException {

        String authHeader = request.getHeader("Authorization");
        String token = null;

        // 1) 헤더에서 Bearer 토큰 추출
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            token = authHeader.substring(7);
            log.debug("[JwtTokenFilter] Extracted token from header");
        }

        // 2) 토큰 유효성 검사 & 인증 컨텍스트 설정
        if (token != null) {
            try {
                Claims claims = JwtUtil.getClaims(token);
                String discordId = claims.get("id", String.class);

                MapleJariUserEntity user = mapleJariUserRepository.findByDiscordId(discordId)
                        .orElseThrow();


                String role = user.getRole();

                // 이미 ROLE_이 붙어있지 않으면 붙여줌
                if (!role.startsWith("ROLE_")) {
                    role = "ROLE_" + role;
                }

                var auth = new UsernamePasswordAuthenticationToken(
                        user,
                        null,
                        List.of(new SimpleGrantedAuthority(role))
                );
                SecurityContextHolder.getContext().setAuthentication(auth);

            } catch (Exception e) {
                log.warn("[JwtTokenFilter] JWT validation failed: {}", e.getMessage());
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                return;
            }
        }
        log.info("Request URI: {}", request.getRequestURI());

        // 토큰 설정 후
        log.info("[JwtTokenFilter] Request URI: {}", request.getRequestURI());
        var currentAuth = SecurityContextHolder.getContext().getAuthentication();
        if (currentAuth != null) {
            log.info("  - Principal: {}", currentAuth.getPrincipal());
            log.info("  - Authorities: {}", currentAuth.getAuthorities());
            log.info("  - Is Authenticated: {}", currentAuth.isAuthenticated());
        } else {
            log.info("  - No authentication in context");
        }

        chain.doFilter(request, response);
    }
}
