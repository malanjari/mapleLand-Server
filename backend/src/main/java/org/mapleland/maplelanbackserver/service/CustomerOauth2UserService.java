package org.mapleland.maplelanbackserver.service;

import lombok.RequiredArgsConstructor;
import org.mapleland.maplelanbackserver.filter.AdminCheckFilter;
import org.mapleland.maplelanbackserver.repository.UserRepository;
import org.mapleland.maplelanbackserver.table.User;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.OAuth2Error;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerOauth2UserService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {

    private final UserRepository userRepository;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {

        OAuth2UserService<OAuth2UserRequest,OAuth2User> delegate = new DefaultOAuth2UserService();
        OAuth2User oAuth2User = delegate.loadUser(userRequest);

        Map<String, Object> attribute = oAuth2User.getAttributes();
        String discordId =  (String) attribute.get("id");
        String email  = (String) attribute.get("email");
        String username  = (String) attribute.get("username");
        String globalName  = (String) attribute.get("global_name");
        String avatar =  (String)attribute.get("avatar");

        String role = AdminCheckFilter.adminCheckFilter(discordId);

        /**
         * 함수형 인터페이스
         * {}는 여러 줄 실행 또는 return을 명시해야 할 때 사용.
         */

        userRepository.findByDiscordId(discordId).
                orElseGet(() -> {
                    User user = User.builder()
                            .discordId(discordId)
                            .email(email)
                            .userName(username)
                            .globalName(globalName)
                            .manonTicket(5)
                            .pianusTicket(5)
                            .mapTicket(true)
                            .role(role)
                            .reportCount(0)
                            .image(avatar)
                            .isActive(true)
                            .build();
                    return userRepository.save(user);
                });

        Optional<User> byDiscordId = userRepository.findByDiscordId(discordId);
        User user = byDiscordId.get();



        if (user.getBannedHours() != null && user.getBannedHours().isAfter(LocalDateTime.now())) {
            String reason = user.getBanedReason();
            String description = "⛔ 정지된 계정입니다. 사유: " + (reason != null ? reason : "관리자 설정")
                    + " / 정지 해제 시간: " + user.getBannedHours();
            OAuth2Error error = new OAuth2Error("account_banned", description, null);
            throw new OAuth2AuthenticationException(error);
        }else {
            user.setActive(true);
            userRepository.save(user);
        }




        boolean update = false;

        if(!Objects.equals(user.getGlobalName(),globalName)) {
            user.setGlobalName(globalName);
            update = true;
        }

        if(!Objects.equals(user.getImage(),avatar)) {
            user.setImage(avatar);
            update = true;
        }

        if(update) {
            userRepository.save(user);
        }


        return oAuth2User;
    }
}
