package org.mapleLand.maplelanbackserver.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mapleLand.maplelanbackserver.jwtUtil.JwtUtil;
import org.mapleLand.maplelanbackserver.repository.MapleJariUserRepository;
import org.mapleLand.maplelanbackserver.table.MapleJariUserEntity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseCookie;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.Map;
import java.util.Optional;

@Component
@Slf4j
@RequiredArgsConstructor
public class Oauth2LoginSuccessHandler implements AuthenticationSuccessHandler {

    @Value("${frontend.redirect-url}")
    private String frontEndRedirectUrl;
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final MapleJariUserRepository mapleJariUserRepository;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication) throws IOException {
        OAuth2User oAuth2User = (OAuth2User) authentication.getPrincipal();
        String discordId  = oAuth2User.getAttribute("id");
        String avatar     = oAuth2User.getAttribute("avatar");
        String username   = oAuth2User.getAttribute("username");
        String globalName = oAuth2User.getAttribute("global_name");
        String role       = "ROLE_USER";


        Optional<MapleJariUserEntity> userEntity = mapleJariUserRepository.findByDiscordId(discordId);

// 값이 없을 때만 예외 던지기
        if (userEntity.isEmpty()) {
            throw new UserPrincipalNotFoundException("사용자를 찾을 수 없습니다.");
        }

// 이 지점에서는 항상 값이 있으므로 get() 해도 안전
        int userId = userEntity.get().getUserId();

        String accessToken  = JwtUtil.createToken(discordId, username, avatar, globalName, role,userId);
        String refreshToken = JwtUtil.createRefreshToken(discordId);





        log.info("JWT 발급 완료: {}", accessToken);

        // 1) JSON 형태로 토큰 내려주기
        Map<String,String> tokens = Map.of(
                "accessToken", accessToken,
                "refreshToken", refreshToken
        );

        response.setStatus(HttpServletResponse.SC_OK);

        // 2) Access 토큰은 Authorization 헤더로

        // 1) 더 이상 헤더에 담지 않고,
        // 2) 쿼리 스트링으로 붙여서 리다이렉트
        String redirectUrl = frontEndRedirectUrl
                + "/oauth2/success"
                + "?accessToken="  + accessToken
                + "&refreshToken=" + refreshToken;

        response.sendRedirect(redirectUrl + "/oauth2/success");

    }
}
