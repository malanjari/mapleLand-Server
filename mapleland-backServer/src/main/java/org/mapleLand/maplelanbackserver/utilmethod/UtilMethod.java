package org.mapleland.maplelanbackserver.utilmethod;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mapleland.maplelanbackserver.exception.DuplicatedMapInterRestException;
import org.mapleland.maplelanbackserver.exception.MaxMapInterestLimitException;
import org.mapleland.maplelanbackserver.exception.NotFoundUserException;
import org.mapleland.maplelanbackserver.dto.Map.AlertRequest;
import org.mapleland.maplelanbackserver.enumType.alert.AlertStatus;
import org.mapleland.maplelanbackserver.jwtUtil.JwtUtil;
import org.mapleland.maplelanbackserver.repository.*;
import org.mapleland.maplelanbackserver.table.MapInterRest;
import org.mapleland.maplelanbackserver.table.User;
import org.mapleland.maplelanbackserver.table.MapleMap;
import org.springframework.stereotype.Component;

import java.util.Optional;
@Component
@RequiredArgsConstructor
@Slf4j
public class UtilMethod {

    private final userRepository userRepository;
    private final MapleMapRepository mapleMapRepository;
    private final MapInterRestRepository interestRepository;


    public AlertStatus updateAlertInterest(AlertRequest dto, String token) {

        int userId = JwtUtil.getUserId(token);

        //fasle 알람버튼을 안눌렀을 때
        if (dto.alertStatus() == AlertStatus.ALERT_ON) {
            Optional<User> user = userRepository.findByUserId(userId);
            if (user.isEmpty()) throw new NotFoundUserException("사용자를 찾을 수 없습니다.");

            //마뇽 자리

            MapleMap jari = mapleMapRepository.findById(dto.mapId()).get();

            boolean exists = interestRepository.existsByMapleMap_MapleLandMapListIdAndUser_UserId(dto.mapId(),userId);

            if (exists) throw new DuplicatedMapInterRestException("⛔ 이미 등록된 관심 맵입니다:");

            long count = interestRepository.countByUser(user.get());


            if (count > 1) throw new MaxMapInterestLimitException("⛔ 최대 2개까지 알람 등록이 가능합니다.");


            interestRepository.save(
                    MapInterRest.builder().mapleMap(jari)
                            .user(user.get())
                            .build());

            return AlertStatus.ALERT_ON;

        }
        else if(dto.alertStatus() == AlertStatus.ALERT_OFF) {

            Optional<User> byUserId = userRepository.findByUserId(dto.userId());
            if (byUserId.isEmpty()) throw new NotFoundUserException("사용자를 찾을 수 없습니다.");

            boolean exists = interestRepository.
                    existsByMapleMap_MapleLandMapListIdAndUser_UserId(dto.mapId(), dto.userId());

            if (exists) {
                MapInterRest userInterest = interestRepository
                        .findByUser_UserIdAndMapleMap_MapleLandMapListId(
                                dto.userId(), dto.mapId())
                        .orElseThrow(() -> new IllegalStateException("❌ 관심 등록을 찾을 수 없습니다."));

                interestRepository.delete(userInterest);

                return AlertStatus.ALERT_OFF;
            }
        }
        return AlertStatus.INVALID_REQUEST;
    }
}
