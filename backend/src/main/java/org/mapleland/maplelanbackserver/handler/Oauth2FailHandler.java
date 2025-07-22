package org.mapleland.maplelanbackserver.handler;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mapleland.maplelanbackserver.repository.UserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Slf4j
@Component
@RequiredArgsConstructor
public class Oauth2FailHandler implements AuthenticationFailureHandler {

    @Value("${frontend.redirect-url}")
    private String redirectUrl;
    private final UserRepository userRepository;

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {

        if (exception instanceof OAuth2AuthenticationException oauth2Exception) {
            log.info("값 들어오나용? = {}", oauth2Exception.getMessage());
            String errorCode = oauth2Exception.getError().getErrorCode();
            String message = oauth2Exception.getError().getDescription();

            if ("account_banned".equals(errorCode)) {
                response.sendRedirect(
                        redirectUrl + "/oauth/banned?reason=banned&message=" +
                                URLEncoder.encode(message, StandardCharsets.UTF_8)
                );
                return;
            }
        }

        log.error("🔥 OAuth2 인증 실패! 메시지: {}", exception.getMessage());
        exception.printStackTrace(); // 스택 출력


        response.sendRedirect("/login?error=" + exception.getMessage());
    }
}

