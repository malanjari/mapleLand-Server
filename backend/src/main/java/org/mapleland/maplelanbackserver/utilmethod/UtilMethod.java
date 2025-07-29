package org.mapleland.maplelanbackserver.utilmethod;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mapleland.maplelanbackserver.dto.Map.JariCreatedRequest;
import org.mapleland.maplelanbackserver.dto.request.AlarmRegisterRequest;
import org.mapleland.maplelanbackserver.enumType.Region;
import org.mapleland.maplelanbackserver.enumType.TradeType;
import org.mapleland.maplelanbackserver.exception.coflict.ConflictException;
import org.mapleland.maplelanbackserver.exception.coflict.DuplicatedMapInterRestException;
import org.mapleland.maplelanbackserver.exception.badrequest.MaxMapInterestLimitException;
import org.mapleland.maplelanbackserver.exception.notfound.jari.NotFoundMapException;
import org.mapleland.maplelanbackserver.exception.notfound.jari.NotFoundUserException;
import org.mapleland.maplelanbackserver.dto.Map.AlertRequest;
import org.mapleland.maplelanbackserver.enumType.alert.AlertStatus;
import org.mapleland.maplelanbackserver.exception.unauthorization.UserMismatchException;
import org.mapleland.maplelanbackserver.jwtUtil.JwtUtil;
import org.mapleland.maplelanbackserver.repository.*;
import org.mapleland.maplelanbackserver.service.DiscordDmService;
import org.mapleland.maplelanbackserver.service.MapService;
import org.mapleland.maplelanbackserver.service.WebSocketService;
import org.mapleland.maplelanbackserver.table.Jari;
import org.mapleland.maplelanbackserver.table.MapInterRest;
import org.mapleland.maplelanbackserver.table.User;
import org.mapleland.maplelanbackserver.table.MapleMap;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
@Component
@RequiredArgsConstructor
@Slf4j
public class UtilMethod {

    ModelMapper modelMapper = new ModelMapper();
    private final UserRepository userRepository;
    private final MapleMapRepository mapleMapRepository;
    private final MapInterRestRepository interestRepository;
    private final JariRepository jariRepository;





    public AlertStatus updateAlertInterest(AlertRequest dto, String token) {

       
        int userId = JwtUtil.getUserId(token);

        if(userId != dto.userId()) throw new UserMismatchException("사용자가 다릅니다."); // 401

        //fasle 알람버튼을 안눌렀을 때
        if (dto.alertStatus() == AlertStatus.ALERT_ON) {
            Optional<User> user = userRepository.findByUserId(userId);
            if (user.isEmpty()) throw new NotFoundUserException("사용자를 찾을 수 없습니다."); // 404

            //마뇽 자리

            MapleMap jari = mapleMapRepository.findById(dto.mapId())
                    .orElseThrow(()-> new NotFoundMapException("맵을 찾을 수 없습니다.")); // 404

            boolean exists = interestRepository.existsByMapleMap_MapleLandMapListIdAndUser_UserId(dto.mapId(),userId);

            if (exists) throw new DuplicatedMapInterRestException("⛔ 이미 등록된 관심 맵입니다:"); // 409

            long count = interestRepository.countByUser(user.get());


            if (count > 1) throw new MaxMapInterestLimitException("⛔ 최대 2개까지 알람 등록이 가능합니다."); //400


            interestRepository.save(
                    MapInterRest.builder().mapleMap(jari)
                            .user(user.get())
                            .build());

            return AlertStatus.ALERT_ON;

        }
        else if(dto.alertStatus() == AlertStatus.ALERT_OFF) {

            Optional<User> byUserId = userRepository.findByUserId(dto.userId());
            if (byUserId.isEmpty()) throw new NotFoundUserException("사용자를 찾을 수 없습니다."); // 404

            boolean exists = interestRepository.
                    existsByMapleMap_MapleLandMapListIdAndUser_UserId(dto.mapId(), dto.userId());

            if (exists) {
                MapInterRest userInterest = interestRepository
                        .findByUser_UserIdAndMapleMap_MapleLandMapListId(
                                dto.userId(), dto.mapId())
                        .orElseThrow(() -> new NotFoundMapException("관심 등록을 찾을 수 없습니다.")); // 404

                interestRepository.delete(userInterest);

                return AlertStatus.ALERT_OFF;
            }
        }
        return AlertStatus.INVALID_REQUEST;
    }


    public void DiscordAlertInterest(AlarmRegisterRequest request) {

        User user = userRepository.findByDiscordId(request.discordId()).
                orElseThrow(() -> new NotFoundUserException("사용자를 찾을 수 없음"));

        long count = interestRepository.countByUser(user);

        if (count >= 2) {
            // ❌ 2개 초과 등록은 불가
            throw new MaxMapInterestLimitException("알림은 최대 두개까지 등록 가능합니다. \n 알람 해제를 통해 맵을 삭제하세요.");
        }

        List<MapleMap> byMapName = mapleMapRepository.findByMapName(request.mapName());

        boolean exists = interestRepository.existsByUser_UserIdAndMapleMap_MapleLandMapListId
                (user.getUserId(),byMapName.get(0).getMapleLandMapListId());
        if (exists) {
            throw new DuplicatedMapInterRestException("⛔ 이미 등록된 맵입니다.");
        }


        MapInterRest mapInterRest = new MapInterRest();

        mapInterRest.setUser(user);
        mapInterRest.setMapleMap(byMapName.get(0));

        interestRepository.save(mapInterRest);

    }
    public void DiscordAlertInterestOut(AlarmRegisterRequest request) {
        User user = userRepository.findByDiscordId(request.discordId()).
                orElseThrow(() -> new NotFoundUserException("사용자를 찾을 수 없음"));

        List<MapleMap> byMapName = mapleMapRepository.findByMapName(request.mapName());

        if(byMapName.isEmpty()) throw new NotFoundMapException("알람 등록한 맵이 아닙니다!");

        MapInterRest mapInterRest = interestRepository.findByUser_UserIdAndMapleMap_MapName(user.getUserId(), request.mapName())
                .orElseThrow(() -> new NotFoundUserException("관심 등록한 맵을 찾을 수 없습니다."));

        interestRepository.delete(mapInterRest);

    }
}
