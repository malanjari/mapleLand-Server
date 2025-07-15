package org.mapleLand.maplelanbackserver.utilMethod;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mapleLand.maplelanbackserver.controller.errorController.DuplicatedMapInterRestException;
import org.mapleLand.maplelanbackserver.controller.errorController.MaxMapInterestLimitException;
import org.mapleLand.maplelanbackserver.controller.errorController.NotFoundUserException;
import org.mapleLand.maplelanbackserver.dto.Map.InterestAlertRequestDto;
import org.mapleLand.maplelanbackserver.enumType.alert.AlertStatus;
import org.mapleLand.maplelanbackserver.jwtUtil.JwtUtil;
import org.mapleLand.maplelanbackserver.repository.*;
import org.mapleLand.maplelanbackserver.service.DiscordDmService;
import org.mapleLand.maplelanbackserver.service.MapleLandUserService;
import org.mapleLand.maplelanbackserver.table.MapInterestEntity;
import org.mapleLand.maplelanbackserver.table.MapleJariUserEntity;
import org.mapleLand.maplelanbackserver.table.MapleLandMapListEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;
@Component
@RequiredArgsConstructor
@Slf4j
public class UtilMethod {

    private final MapleJariUserRepository userRepository;
    private final MapleLandMapListRepository mapleLandMapListRepository;
    private final MapInterestRepository interestRepository;


    public AlertStatus updateAlertInterest(InterestAlertRequestDto dto,String token) {

        int userId = JwtUtil.getUserId(token);

        //fasle 알람버튼을 안눌렀을 때
        if (dto.alertStatus() == AlertStatus.ALERT_ON) {
            Optional<MapleJariUserEntity> user = userRepository.findByUserId(userId);
            if (user.isEmpty()) throw new NotFoundUserException("사용자를 찾을 수 없습니다.");

            //마뇽 자리

            MapleLandMapListEntity jari = mapleLandMapListRepository.findById(dto.mapId()).get();

            boolean exists = interestRepository.existsByMapleLandMapListEntity_MapleLandMapListIdAndMapleJariUserEntity_UserId(dto.mapId(),userId);

            if (exists) throw new DuplicatedMapInterRestException("⛔ 이미 등록된 관심 맵입니다:");

            long count = interestRepository.countByMapleJariUserEntity(user.get());


            if (count > 1) throw new MaxMapInterestLimitException("⛔ 최대 2개까지 알람 등록이 가능합니다.");


            interestRepository.save(
                    MapInterestEntity.builder().mapleLandMapListEntity(jari)
                            .mapleJariUserEntity(user.get())
                            .build());

            return AlertStatus.ALERT_ON;

        }
        else if(dto.alertStatus() == AlertStatus.ALERT_OFF) {

            Optional<MapleJariUserEntity> byUserId = userRepository.findByUserId(dto.userId());
            if (byUserId.isEmpty()) throw new NotFoundUserException("사용자를 찾을 수 없습니다.");

            boolean exists = interestRepository.
                    existsByMapleLandMapListEntity_MapleLandMapListIdAndMapleJariUserEntity_UserId(dto.mapId(), dto.userId());

            if (exists) {
                MapInterestEntity userInterest = interestRepository
                        .findByMapleJariUserEntity_UserIdAndMapleLandMapListEntity_MapleLandMapListId(
                                dto.userId(), dto.mapId())
                        .orElseThrow(() -> new IllegalStateException("❌ 관심 등록을 찾을 수 없습니다."));

                interestRepository.delete(userInterest);

                return AlertStatus.ALERT_OFF;
            }
        }
        return AlertStatus.INVALID_REQUEST;
    }
}
