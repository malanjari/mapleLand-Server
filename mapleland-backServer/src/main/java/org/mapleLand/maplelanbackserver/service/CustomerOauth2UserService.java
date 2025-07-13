package org.mapleLand.maplelanbackserver.service;

import lombok.RequiredArgsConstructor;
import org.mapleLand.maplelanbackserver.filter.AdminCheckFilter;
import org.mapleLand.maplelanbackserver.repository.MapleJariUserRepository;
import org.mapleLand.maplelanbackserver.table.MapleJariUserEntity;
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

    private final MapleJariUserRepository mapleJariUserRepository;

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

        mapleJariUserRepository.findByDiscordId(discordId).
                orElseGet(() -> {
                    MapleJariUserEntity mapleJariUserEntity = MapleJariUserEntity.builder()
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
                    return mapleJariUserRepository.save(mapleJariUserEntity);
                });

        Optional<MapleJariUserEntity> byDiscordId = mapleJariUserRepository.findByDiscordId(discordId);
        MapleJariUserEntity mapleJariUserEntity = byDiscordId.get();
        boolean update = false;

        if(!Objects.equals(mapleJariUserEntity.getGlobalName(),globalName)) {
            mapleJariUserEntity.setGlobalName(globalName);
            update = true;
        }

        if(!Objects.equals(mapleJariUserEntity.getImage(),avatar)) {
            mapleJariUserEntity.setImage(avatar);
            update = true;
        }

        if(update) {
            mapleJariUserRepository.save(mapleJariUserEntity);
        }

        return oAuth2User;
    }
}
