package org.mapleLand.maplelanbackserver.handler;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.mapleLand.maplelanbackserver.jwtUtil.JwtUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
@Component
@Slf4j
public class Oauth2LoginSuccessHandler implements AuthenticationSuccessHandler {

    @Value("${frontend.redirect-url}")
    private String redirectUrl;
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {

        OAuth2User oAuth2User = (OAuth2User) authentication.getPrincipal();
        String discordId = oAuth2User.getAttribute("id");
        String avatar =  (String) oAuth2User.getAttributes().get("avatar");
        String username =   (String) oAuth2User.getAttributes().get("username");
        String globalName  = (String) oAuth2User.getAttributes().get("global_name");

        String role = "ROLE_USER";
        String token = JwtUtil.createToken(discordId,username,avatar,globalName,role);

        log.info("JWT 발급 완료: {}", token); // 로그 찍힘


        response.sendRedirect(redirectUrl +"/oauth2/success?token="+ token);
    }
}
