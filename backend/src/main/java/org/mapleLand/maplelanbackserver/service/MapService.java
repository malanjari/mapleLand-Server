package org.mapleLand.maplelanbackserver.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mapleLand.maplelanbackserver.controller.errorController.NotFoundUserException;
import org.mapleLand.maplelanbackserver.dto.DropItemDto;
import org.mapleLand.maplelanbackserver.dto.MapDto;
import org.mapleLand.maplelanbackserver.dto.MapPopularityDto;
import org.mapleLand.maplelanbackserver.dto.MapRegistrationDto;
import org.mapleLand.maplelanbackserver.controller.errorController.NotFoundMapTicketException;

import org.mapleLand.maplelanbackserver.enumType.Region;
import org.mapleLand.maplelanbackserver.repository.MapDropItemRepository;
import org.mapleLand.maplelanbackserver.repository.MapleJariUserRepository;
import org.mapleLand.maplelanbackserver.repository.MapleLandMapListRepository;
import org.mapleLand.maplelanbackserver.repository.UserMapRegisterRepository;
import org.mapleLand.maplelanbackserver.resolve.RegionResolver;
import org.mapleLand.maplelanbackserver.table.MapDropItemEntity;
import org.mapleLand.maplelanbackserver.table.MapRegistrationEntity;
import org.mapleLand.maplelanbackserver.table.MapleJariUserEntity;
import org.mapleLand.maplelanbackserver.table.MapleLandMapListEntity;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class MapService {

    ModelMapper modelMapper = new ModelMapper();
    private final UserMapRegisterRepository registerRepository;
    private final MapleJariUserRepository userRepository;
    private final MapleLandUserService userActiveCheckService;
    private final MapleLandMapListRepository mapleLandMapListRepository;
    private final UserMapRegisterRepository userMapRegisterRepository;
    private final MapDropItemRepository mapDropItemRepository;
    private final MapPopularityService popularityService;

    public void mapRegisterServiceMethod(MapRegistrationDto dto) {

        MapleJariUserEntity user = userRepository.findByUserId(dto.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("유저를 찾을 수 없습니다."));

        userActiveCheckService.userActiveCheck(user);

        // 지역 정보 추출
        Region region = RegionResolver.getRegionEnumByMapName(dto.getMapName());
        log.info("지역이름 = {}", region);

        // 매칭 맵 정보 추출
        MapleLandMapListEntity mapInfo = getFirstMatchedMap(dto.getMapName());

        // 등록 티켓 확인
        if (!user.getMapTicket()) {
            throw new NotFoundMapTicketException("등록 티켓이 없습니다.");
        }

        // 테스트용 코드 (배포 시 false 설정해야 함)
        user.setMapTicket(true);

        // Entity 변환 및 등록
        MapRegistrationEntity entity = modelMapper.map(dto, MapRegistrationEntity.class);
        entity.setUserMapId(null);
        entity.setArea(region);
        entity.setIsCompleted(false);
        entity.setMonsterImageUrl(mapInfo.getMonsterImageUrl());
        entity.setMapleJariUserEntity(user);

        registerRepository.save(entity);
    }


    public List<MapDto> searchMapsByKeyword(String keyword) {

        List<MapRegistrationEntity> results = userMapRegisterRepository.findByMapNameWithUser(keyword);
        System.out.println("🔍 검색된 결과 수: " + results.size());

        MapleLandMapListEntity mapleLandMapListEntity = mapleLandMapListRepository.findByMapName(keyword).stream()
                .findFirst().orElse(null);



        return results.stream()
                .map(e -> {
                    var user = e.getMapleJariUserEntity();
                    return new MapDto(
                            e.getUserMapId(),
                            popularityService.removedPrefixByRegion(e.getMapName(),e.getArea()),
                            e.getServerColor(),
                            e.getPrice(),
                            e.getTradeType(),
                            e.getNegotiationOption(),
                            e.getArea(),
                            e.getCreateTime(),
                            e.getComment(),
                            e.getMonsterImageUrl(),
                            user.getGlobalName(),
                            user.getImage(),
                            user.getUserId(),
                            user.getDiscordId(),
                            user.getUserName(),
                            mapleLandMapListEntity.getMiniMapImageLogoUrl()
                    );
                })
                .toList();
    }

    public MapleLandMapListEntity getFirstMatchedMap(String keyword) {
        return mapleLandMapListRepository
                .findByMapNameExact(keyword)
                .stream()
                .findFirst()
                .orElseThrow(()-> new NotFoundUserException("맵을 찾을 수 없습니다."));
    }


    public List<DropItemDto> monsterInfo(String keyword) {

        List<MapDropItemEntity> byMapName = mapDropItemRepository.findByMapName(keyword);

        return byMapName.stream().map(
                p-> new DropItemDto(p.getMapName(),
                        p.getItemName(),
                        p.getItemImageUrl(),p.getDropRate()))
                .toList();
    }



    public List<MapDto> findByRegionTag(String keyword){
        List<MapRegistrationEntity> byArea = userMapRegisterRepository.findByArea(Region.valueOf(keyword));

        MapleLandMapListEntity mapEntity =
                mapleLandMapListRepository.findByRegion(Region.valueOf(keyword))
                        .stream().findFirst().orElse(null);

        return byArea.stream()
                .map(e -> {
                    var user = e.getMapleJariUserEntity();
                    return new MapDto(
                            e.getUserMapId(),
                            popularityService.removedPrefixByRegion(e.getMapName(),e.getArea()),
                            e.getServerColor(),
                            e.getPrice(),
                            e.getTradeType(),
                            e.getNegotiationOption(),
                            e.getArea(),
                            e.getCreateTime(),
                            e.getComment(),
                            e.getMonsterImageUrl(),
                            user.getGlobalName(),
                            user.getImage(),
                            user.getUserId(),
                            user.getDiscordId(),
                            user.getUserName(),
                            mapEntity.getMiniMapImageLogoUrl()
                    );
                })
                .toList();
    }
}
