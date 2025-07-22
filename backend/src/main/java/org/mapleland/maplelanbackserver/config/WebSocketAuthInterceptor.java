package org.mapleland.maplelanbackserver.config;

import lombok.extern.slf4j.Slf4j;
import org.mapleland.maplelanbackserver.jwtUtil.JwtUtil;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.ChannelInterceptor;
import org.springframework.messaging.support.MessageHeaderAccessor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class WebSocketAuthInterceptor implements ChannelInterceptor {



    @Override
    public Message<?> preSend(Message<?> message, MessageChannel channel) {

        log.info("✅ preSend 실행됨");
        StompHeaderAccessor accessor =
                MessageHeaderAccessor.getAccessor(message, StompHeaderAccessor.class);

        if (StompCommand.CONNECT.equals(accessor.getCommand())) {
            log.info("🔐 CONNECT 요청 감지");
            String authHeader = accessor.getFirstNativeHeader("Authorization");
            log.info("🧾 Authorization 헤더: {}", authHeader);
            if (authHeader != null && authHeader.startsWith("Bearer ")) {
                String token = authHeader.substring(7);
                try {
                    var authentication = JwtUtil.getAuthenticationFromToken(token);
                    accessor.setUser(authentication);
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                    log.info("✅ 인증 성공: {}", authentication.getPrincipal());
                } catch (Exception e) {
                    System.out.println("❌ WebSocket 토큰 인증 실패: " + e.getMessage());
                }
            }
        }

        return message;
    }
}

