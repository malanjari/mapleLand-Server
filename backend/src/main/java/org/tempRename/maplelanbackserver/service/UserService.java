package org.mapleland.maplelanbackserver.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mapleland.maplelanbackserver.exception.NotFoundUserException;
import org.mapleland.maplelanbackserver.exception.UserBanGlobalException;
import org.mapleland.maplelanbackserver.dto.response.AlterDto;
import org.mapleland.maplelanbackserver.dto.user.*;
import org.mapleland.maplelanbackserver.enumType.alert.AlertStatus;
import org.mapleland.maplelanbackserver.repository.MapInterRestRepository;
import org.mapleland.maplelanbackserver.repository.userRepository;
import org.mapleland.maplelanbackserver.repository.jariRepository;
import org.mapleland.maplelanbackserver.table.jari;
import org.mapleland.maplelanbackserver.table.User;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {


    private final userRepository userRepository;
    private final jariRepository jariRepository;
    private final MapInterRestRepository mapInterRestRepository;
    private final JwtDecoder jwtDecoder;


    public void userActiveCheck(User user) {

        Optional<User> byDiscordId =
                userRepository.findByDiscordId(user.getDiscordId());

        if(!byDiscordId.get().isActive())
            throw new UserBanGlobalException("차단된 사용자 입니다.", user.getBanedReason());

    }

    public ResponseUserDetailDto getUserDetailServiceMethod(Integer userId) {
        // 사용자 정보 조회
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundUserException("사용자를 찾을 수 없습니다."));




        // 사용자 정보 DTO 생성
        UserInfoDto userInfo = new UserInfoDto(
                user.getDiscordId(),
                user.getImage(),
                user.getCreateTime(),
                user.getGlobalName(),
                user.getMapTicket(),
                user.getUserName(),
                user.getEmail());

        // 사용자가 등록한 맵 목록 조회
        List<jari> mapRegistrations = jariRepository.findByMapleJariUserEntity_UserId(userId);

        // 맵 등록 정보 DTO 리스트 생성
        List<UserMapRegistrationDto> mapRegistrationDtos = mapRegistrations.stream()
                .map(e -> {
                    var userResult = e.getUser();
                 return new UserMapRegistrationDto(
                        e.getUserMapId(),
                        e.getMapName(),
                        e.getServerColor(),
                        e.getPrice(),
                        e.getTradeType(),
                        e.getNegotiationOption(),
                        e.getArea(),
                        e.getCreateTime(),
                        e.getComment(),
                        e.getMonsterImageUrl(),
                        e.getIsCompleted(),
                         userResult.getImage(),
                         userResult.getUserId(),
                         userResult.getDiscordId(),
                         userResult.getGlobalName()

                );
                })
                .toList();



        return new ResponseUserDetailDto(userInfo, mapRegistrationDtos);
    }

    public LoginStatusResponse checkLoginStatus(String authHeader) {
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return new LoginStatusResponse(false, null, null);
        }

        String token = authHeader.substring(7).trim();

        try {
            Jwt jwt = jwtDecoder.decode(token);
            Map<String, Object> claims = jwt.getClaims();

            Object idObj = claims.get("userId");
            if (!(idObj instanceof Number number)) {
                throw new IllegalStateException("userId가 숫자가 아닙니다: " + idObj);
            }
            int userId = number.intValue();

            List<AlterDto> alertList = mapInterRestRepository
                    .findByUser_UserId(userId)
                    .stream()
                    .map(e -> new AlterDto(
                            e.getMapleMap().getMapleLandMapListId(),
                            AlertStatus.ALERT_ON))
                    .toList();

            ResponseApiUserDto userDto = new ResponseApiUserDto(claims);

            return new LoginStatusResponse(true, userDto, alertList);

        } catch (Exception e) {
            log.info("❌ JWT 검증 실패: {}", e.getMessage());
            return new LoginStatusResponse(false, null, null);
        }
    }


}
