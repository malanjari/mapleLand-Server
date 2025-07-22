package org.mapleland.maplelanbackserver.filter;

import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mapleland.maplelanbackserver.repository.UserRepository;
import org.mapleland.maplelanbackserver.service.UserInformationService;
import org.mapleland.maplelanbackserver.table.User;
import org.mapleland.maplelanbackserver.jwtUtil.JwtUtil;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
@Slf4j
public class JwtTokenFilter extends OncePerRequestFilter {

    private final UserRepository userRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain)
            throws ServletException, IOException {

        // ✅ OPTIONS 요청은 JWT 검사 생략하고 바로 통과시킴
        if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
            log.debug("[JwtTokenFilter] Preflight OPTIONS request bypassed.");
            chain.doFilter(request, response); // ✅ 이걸 반드시 호출해야 함!
            return;
        }

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

                User user = userRepository.findByDiscordId(discordId)
                        .orElseThrow();

                UserInformationService userDetails = new UserInformationService(user);

                // 🔐 계정 잠금 여부 검사
                if (!userDetails.isAccountNonLocked()) {
                    log.warn("[JwtTokenFilter] User account is locked: {}", user.getDiscordId());
                    response.setStatus(HttpServletResponse.SC_FORBIDDEN);
                    response.setContentType("application/json;charset=UTF-8");
                    response.getWriter().write("계정이 정지된 상태입니다.");
                    return;
                }

                var auth = new UsernamePasswordAuthenticationToken(
                        userDetails,
                        null,
                        userDetails.getAuthorities()
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
