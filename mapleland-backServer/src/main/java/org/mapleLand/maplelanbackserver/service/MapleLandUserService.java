package org.mapleLand.maplelanbackserver.service;

import lombok.RequiredArgsConstructor;
import org.mapleLand.maplelanbackserver.controller.errorController.NotFoundUserException;
import org.mapleLand.maplelanbackserver.controller.errorController.UserBanGlobalException;
import org.mapleLand.maplelanbackserver.dto.user.UserDetailResponseDto;
import org.mapleLand.maplelanbackserver.dto.user.UserInfoDto;
import org.mapleLand.maplelanbackserver.dto.user.UserMapRegistrationDto;
import org.mapleLand.maplelanbackserver.repository.MapleJariUserRepository;
import org.mapleLand.maplelanbackserver.repository.UserMapRegisterRepository;
import org.mapleLand.maplelanbackserver.table.MapRegistrationEntity;
import org.mapleLand.maplelanbackserver.table.MapleJariUserEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MapleLandUserService{


    private final MapleJariUserRepository  mapleJariUserRepository;
    private final UserMapRegisterRepository userMapRegisterRepository;


    public void userActiveCheck(MapleJariUserEntity mapleJariUserEntity) {

        Optional<MapleJariUserEntity> byDiscordId =
                mapleJariUserRepository.findByDiscordId(mapleJariUserEntity.getDiscordId());

        if(!byDiscordId.get().isActive())
            throw new UserBanGlobalException("차단된 사용자 입니다.",mapleJariUserEntity.getBanedReason());

    }

    public UserDetailResponseDto getUserDetailServiceMethod(Integer userId) {
        // 사용자 정보 조회
        MapleJariUserEntity user = mapleJariUserRepository.findById(userId)
                .orElseThrow(() -> new NotFoundUserException("사용자를 찾을 수 없습니다."));

        // 사용자 정보 DTO 생성
        UserInfoDto userInfo = new UserInfoDto(
                user.getDiscordId(),
                user.getImage(),
                user.getCreateTime(),
                user.getGlobalName(),
                user.getMapTicket(),
                user.getUserName(),
                user.getEmail()
        );

        // 사용자가 등록한 맵 목록 조회
        List<MapRegistrationEntity> mapRegistrations = userMapRegisterRepository.findByMapleJariUserEntity_UserId(userId);

        // 맵 등록 정보 DTO 리스트 생성
        List<UserMapRegistrationDto> mapRegistrationDtos = mapRegistrations.stream()
                .map(e -> {
                    var userResult = e.getMapleJariUserEntity();
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



        return new UserDetailResponseDto(userInfo, mapRegistrationDtos);
    }
}
