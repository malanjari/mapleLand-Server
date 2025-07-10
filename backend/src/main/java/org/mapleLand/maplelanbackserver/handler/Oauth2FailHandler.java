package org.mapleLand.maplelanbackserver.handler;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
@Slf4j
@Component
public class Oauth2FailHandler implements AuthenticationFailureHandler {

    @Value("${frontend.redirect-url}")
    private String redirectUrl;

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        log.error("🔥 OAuth2 인증 실패! 메시지: {}", exception.getMessage());
        exception.printStackTrace(); // 스택 출력

        // 디버깅용으로 query string에 에러 메시지 넘길 수도 있음
        response.sendRedirect("/login?error=" + exception.getMessage());
    }
}

