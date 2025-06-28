package org.mapleLand.maplelanbackserver.Service;

import lombok.RequiredArgsConstructor;
import org.mapleLand.maplelanbackserver.Repository.MapleJariUserRepository;
import org.mapleLand.maplelanbackserver.Table.MapleJariUser;
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


        /**
         * 함수형 인터페이스
         * {}는 여러 줄 실행 또는 return을 명시해야 할 때 사용.
         */

        mapleJariUserRepository.findByDiscordId(discordId).
                orElseGet(() -> {
                    MapleJariUser mapleJariUser = MapleJariUser.builder()
                            .discordId(discordId)
                            .email(email)
                            .userName(username)
                            .globalName(globalName)
                            .manonTicket(5)
                            .pianusTicket(5)
                            .mapTicket(true)
                            .role("ROLE_USER")
                            .userReportCount(0)
                            .image(avatar)
                            .build();
                    return mapleJariUserRepository.save(mapleJariUser);
                });

        Optional<MapleJariUser> byDiscordId = mapleJariUserRepository.findByDiscordId(discordId);
        MapleJariUser mapleJariUser = byDiscordId.get();
        boolean update = false;

        if(!Objects.equals(mapleJariUser.getGlobalName(),globalName)) {
            mapleJariUser.setGlobalName(globalName);
            update = true;
        }

        if(!Objects.equals(mapleJariUser.getImage(),avatar)) {
            mapleJariUser.setImage(avatar);
            update = true;
        }

        if(update) {
            mapleJariUserRepository.save(mapleJariUser);
        }

        return oAuth2User;
    }
}
