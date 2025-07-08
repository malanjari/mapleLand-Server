package org.mapleLand.maplelanbackserver.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mapleLand.maplelanbackserver.controller.errorController.NotFoundUserException;
import org.mapleLand.maplelanbackserver.dto.*;
import org.mapleLand.maplelanbackserver.controller.errorController.NotFoundMapTicketException;

import org.mapleLand.maplelanbackserver.dto.Map.MapDto;
import org.mapleLand.maplelanbackserver.dto.Map.MapRegistrationDto;
import org.mapleLand.maplelanbackserver.dto.item.DropItemDto;
import org.mapleLand.maplelanbackserver.dto.update.MapUpdateDto;
import org.mapleLand.maplelanbackserver.dto.update.MapUpdatePriceDto;
import org.mapleLand.maplelanbackserver.dto.update.MapUpdateServerColorDto;
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
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
                            mapleLandMapListEntity.getMiniMapImageLogoUrl(),
                            e.getIsCompleted()
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
                            mapEntity.getMiniMapImageLogoUrl(),
                            e.getIsCompleted()
                    );
                })
                .toList();
    }

    public List<PriceStatDto> iqrPriceAvg(String keyword) {
        System.out.println("✅ iqrPriceAvg 진입: " + keyword);

        LocalDateTime today = LocalDate.now().atStartOfDay().plusDays(1);
        LocalDateTime sevenDaysAgo = today.minusDays(7);

        // 1. 최근 7일간 isCompleted = true + mapName 일치하는 거래 조회
        List<MapRegistrationEntity> completed =
                userMapRegisterRepository.findCompletedByMapNameIgnoreSpaceAndDate(
                        keyword, sevenDaysAgo, today
                );
        System.out.println("✅ iqrPriceAvg 진입: " + completed.stream().map(MapRegistrationEntity::getMapName));

        // 2. 날짜(LocalDate) 기준으로 묶기
        Map<LocalDate, List<Integer>> groupedByDate = completed.stream()
                .collect(Collectors.groupingBy(
                        e -> e.getCreateTime().toLocalDate(), // 날짜 단위로 그룹핑
                        Collectors.mapping(MapRegistrationEntity::getPrice, Collectors.toList())
                ));

        // 3. 각 날짜별 IQR 평균 계산
        return groupedByDate.entrySet().stream()
                .map(entry -> {
                    LocalDate date = entry.getKey();
                    List<Integer> prices = entry.getValue();
                    double iqrAvg = calculateIqrAverage(prices);

                    return new PriceStatDto(
                            keyword,
                            (int) iqrAvg,
                            date.atStartOfDay() // LocalDateTime으로 변환
                    );
                })
                .sorted(Comparator.comparing(PriceStatDto::dateTime)) // 날짜순 정렬
                .toList();
    }

    private double calculateIqrAverage(List<Integer> prices) {
        if (prices.size() < 4) return prices.stream().mapToInt(i -> i).average().orElse(0);

        List<Integer> sorted = prices.stream().sorted().toList();
        int q1Index = sorted.size() / 4;
        int q3Index = sorted.size() * 3 / 4;
        double q1 = sorted.get(q1Index);
        double q3 = sorted.get(q3Index);
        double iqr = q3 - q1;

        double lower = q1 - 1.5 * iqr;
        double upper = q3 + 1.5 * iqr;

        List<Integer> filtered = sorted.stream()
                .filter(p -> p >= lower && p <= upper)
                .toList();

        return filtered.stream().mapToInt(i -> i).average().orElse(0);
    }

    public void mapUpdateAll(MapUpdateDto mapUpdateDto){
        log.info("mapUpdateDto.mapId() = {}", mapUpdateDto.mapId());
        MapRegistrationEntity byUserMapId = registerRepository.findByUserMapId(mapUpdateDto.mapId());
        if (byUserMapId == null) {
            log.error("❌ 해당 mapId로 MapRegistrationEntity 를 찾을 수 없습니다: {}", mapUpdateDto.mapId());
            throw new RuntimeException("존재하지 않는 mapId입니다: " + mapUpdateDto.mapId());
        }

        byUserMapId.setServerColor(mapUpdateDto.serverColor());
        byUserMapId.setPrice(mapUpdateDto.price());
        byUserMapId.setNegotiationOption(mapUpdateDto.negotiationOption());
        byUserMapId.setComment(mapUpdateDto.comment());

        registerRepository.save(byUserMapId);

    }


    public void mapUpdatePrice(MapUpdatePriceDto priceDto) {
        MapRegistrationEntity byUserId = registerRepository.findByUserMapId(priceDto.mapId());
        byUserId.setPrice(priceDto.price());
        registerRepository.save(byUserId);

    }

    public void mapUpdateServerColor(MapUpdateServerColorDto dto) {
        MapRegistrationEntity byUserId = registerRepository.findByUserMapId(dto.mapId());
        byUserId.setServerColor(dto.color());
        registerRepository.save(byUserId);
    }

    public void mapDelete(int mapId) {
        MapRegistrationEntity byUserId = registerRepository.findByUserMapId(mapId);
        registerRepository.delete(byUserId);
    }
}