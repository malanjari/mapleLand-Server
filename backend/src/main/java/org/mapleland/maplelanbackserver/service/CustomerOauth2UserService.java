package org.mapleLand.maplelanbackserver.service;

import lombok.RequiredArgsConstructor;
import org.mapleland.maplelanbackserver.filter.AdminCheckFilter;
import org.mapleland.maplelanbackserver.repository.userRepository;
import org.mapleland.maplelanbackserver.table.User;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerOauth2UserService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {

    private final userRepository userRepository;

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
                            .userReportCount(0)
                            .image(avatar)
                            .isActive(true)
                            .build();
                    return userRepository.save(user);
                });

        Optional<User> byDiscordId = userRepository.findByDiscordId(discordId);
        User user = byDiscordId.get();
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
