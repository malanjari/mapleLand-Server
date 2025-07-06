package org.mapleLand.maplelanbackserver.service;

import lombok.RequiredArgsConstructor;
import org.mapleLand.maplelanbackserver.controller.errorController.UserBanGlobalException;
import org.mapleLand.maplelanbackserver.repository.MapleJariUserRepository;
import org.mapleLand.maplelanbackserver.table.MapleJariUserEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MapleLandUserService{


    private final MapleJariUserRepository  mapleJariUserRepository;


    public void userActiveCheck(MapleJariUserEntity mapleJariUserEntity) {

        Optional<MapleJariUserEntity> byDiscordId =
                mapleJariUserRepository.findByDiscordId(mapleJariUserEntity.getDiscordId());

        if(!byDiscordId.get().isActive())
            throw new UserBanGlobalException("차단된 사용자 입니다.",mapleJariUserEntity.getBanedReason());

    }

}
