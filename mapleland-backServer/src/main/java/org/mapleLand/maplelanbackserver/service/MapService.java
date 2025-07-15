package org.mapleLand.maplelanbackserver.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mapleLand.maplelanbackserver.controller.errorController.*;
import org.mapleLand.maplelanbackserver.dto.*;

import org.mapleLand.maplelanbackserver.dto.Map.*;
import org.mapleLand.maplelanbackserver.dto.item.DropItemDto;
import org.mapleLand.maplelanbackserver.dto.update.MapUpdateDto;
import org.mapleLand.maplelanbackserver.dto.update.MapUpdateIsCompletedDto;
import org.mapleLand.maplelanbackserver.dto.update.MapUpdatePriceDto;
import org.mapleLand.maplelanbackserver.dto.update.MapUpdateServerColorDto;
import org.mapleLand.maplelanbackserver.enumType.Region;
import org.mapleLand.maplelanbackserver.enumType.alert.AlertStatus;
import org.mapleLand.maplelanbackserver.jwtUtil.JwtUtil;
import org.mapleLand.maplelanbackserver.repository.*;
import org.mapleLand.maplelanbackserver.resolve.RegionResolver;
import org.mapleLand.maplelanbackserver.table.*;
import org.mapleLand.maplelanbackserver.utilMethod.UtilMethod;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class MapService {

    ModelMapper modelMapper = new ModelMapper();
    private final UserMapRegisterRepository registerRepository;
    private final MapleJariUserRepository userRepository;
    private final MapleLandUserService userActiveCheckService;
    private final MapleLandMapListRepository mapleLandMapListRepository;
    private final UserMapRegisterRepository userMapRegisterRepository;
    private final MapDropItemRepository mapDropItemRepository;
    private final DiscordDmService dmService;
    private final MapInterestRepository interestRepository;
    private final UtilMethod utilMethod;

    String message;
    @Value("${frontend.redirect-url}")
    private String redirectUrl;


    public void mapRegisterServiceMethod(MapRegistrationDto dto) {


        //사용자 검색 -> 사용자 값 꺼내옴
        MapleJariUserEntity user = userRepository.findByUserId(dto.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("유저를 찾을 수 없습니다."));

        //사용자 벤 체크 -> False 벤
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

        interRestUser(dto);
        registerRepository.save(entity);

    }


    public String buildMapUrl(String mapName) {
        String encoded = URLEncoder.encode(mapName, StandardCharsets.UTF_8)
                .replace("+", "%20");
        return redirectUrl + "/jari/" + encoded;
    }
    public void interRestUser(MapRegistrationDto dto){

        Set<Integer> alreadySendCheck = new HashSet<>();

        List<MapInterestEntity> allByMapName = interestRepository.findByMapleLandMapListEntity_MapleLandMapListId(dto.getMapId());

        String url = buildMapUrl(dto.getMapName());

        for(MapInterestEntity user : allByMapName) {
            String discordId = user.getMapleJariUserEntity().getDiscordId();
            MapleJariUserEntity targetUser = user.getMapleJariUserEntity();
            int targetUserId = targetUser.getUserId();


            if (alreadySendCheck.contains(targetUserId)) continue;

            if(targetUser.getUserId().equals(dto.getUserId())) {
                message =  String.format("""
                📢 **%s** 맵이(가) 등록되었습니다!
                        
                💰 가격: %,d 메소 \s
                
                🔗 바로가기: <%s>
                        
                ⚠️ 분쟁 자리 또는 허위 매물 등록 시 제재될 수 있습니다.
                """, dto.getMapName(), dto.getPrice(), url);
            }else  {
                message =  String.format("""
               📢 관심뱁 : **%s** 맵이(가) 등록되었습니다!
                        
                💰 가격: %,d 메소 \s
                
                🔗 바로가기: <%s>
                        
                        
            """, dto.getMapName(), dto.getPrice(),url);
            }


            dmService.sendToUser(discordId,message);
            alreadySendCheck.add(dto.getUserId());
            alreadySendCheck.add(targetUser.getUserId());
        }

        if(!alreadySendCheck.contains(dto.getUserId())) {
            MapleJariUserEntity user = userRepository.findByUserId(dto.getUserId()).
                    orElseThrow(() -> new NotFoundUserException("사용자를 찾을 수 없습니다."));

            String discordId = user.getDiscordId();

            if(discordId!= null) {
                String selfMessage = String.format("""
                 📢  **%s** 맵이(가) 등록되었습니다!
                        
                  💰 가격: %,d 메소 \s
                  
                  🔗 바로가기: <%s>
                        
                  ⚠️ 분쟁 자리 또는 허위 매물 등록 시 제재될 수 있습니다.
            """, dto.getMapName(), dto.getPrice(),url);

                dmService.sendToUser(discordId, selfMessage);
            }
        }

    }
    public AlertStatus MapInterRestServiceMethod(InterestAlertRequestDto dto) {

        return utilMethod.updateAlertInterest(dto);
    }

    public MapListDto searchMapsListKeyword(String keyword){
//        List<MapDto> mapDtos = searchMapsByKeyword(keyword);


        List<DropItemDto> dropItemDtos = monsterInfo(keyword);
        List<PriceStatDto> priceStatDtos = iqrPriceAvgLast6Hours(keyword);



        return new MapListDto(dropItemDtos,priceStatDtos);
    }



    public List<MapDto> searchMapsByKeyword(String keyword) {
        PageRequest pageRequest = PageRequest.of(0, 100); // 첫 페이지, 100개
        List<MapRegistrationEntity> results = userMapRegisterRepository.findTop100ByMapNameWithUser(keyword,pageRequest);
        System.out.println("🔍 검색된 결과 수: " + results.size());





        return results.stream()
                .map(e -> {
                    var user = e.getMapleJariUserEntity();
                    return new MapDto(
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
                            user.getGlobalName(),
                            user.getImage(),
                            user.getUserId(),
                            user.getDiscordId(),
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



        return byArea.stream()
                .map(e -> {
                    var user = e.getMapleJariUserEntity();
                    return new MapDto(
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
                            user.getGlobalName(),
                            user.getImage(),
                            user.getUserId(),
                            user.getDiscordId(),
                            e.getIsCompleted()
                    );
                })
                .toList();
    }

    public List<PriceStatDto> iqrPriceAvgLast6Hours(String keyword) {
        // 1. 최근 6시간 시간대 기준 정의
        LocalDateTime now = LocalDateTime.now().withMinute(0).withSecond(0).withNano(0); // 현재 정각
        LocalDateTime startTime = now.minusHours(6);
        LocalDateTime endTime = now;

        // 2. 최근 6시간 거래 조회 (isCompleted = true)
        List<MapRegistrationEntity> completed =
                userMapRegisterRepository.findCompletedByMapNameIgnoreSpaceAndDate(keyword, startTime, endTime);

        // 3. 시간 슬롯 생성 (6개)
        List<LocalDateTime> hourlySlots = new ArrayList<>();
        LocalDateTime time = startTime;
        while (!time.isAfter(endTime.minusHours(1))) {
            hourlySlots.add(time);
            time = time.plusHours(1);
        }

        // 4. 각 시간대별 거래 필터링 & IQR 평균 계산
        List<PriceStatDto> result = new ArrayList<>();

        for (LocalDateTime slotStart : hourlySlots) {
            LocalDateTime slotEnd = slotStart.plusHours(1);

            List<Integer> prices = completed.stream()
                    .filter(e -> !e.getCreateTime().isBefore(slotStart) && e.getCreateTime().isBefore(slotEnd))
                    .map(MapRegistrationEntity::getPrice)
                    .toList();

            if (prices.isEmpty()) {
                result.add(new PriceStatDto(keyword, 0, slotStart));
            } else {
                double iqrAvg = calculateIqrAverage(prices);
                result.add(new PriceStatDto(keyword, (int) iqrAvg, slotStart));
            }
        }

        return result;
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

    public void updateIsCompleted(MapUpdateIsCompletedDto dto) {
        MapRegistrationEntity byUserMapId = registerRepository.findByUserMapId(dto.mapId());

        if(byUserMapId == null) throw new NotFoundMapException("게시글을 찾을 수 없습니다.");

        byUserMapId.setIsCompleted(true);

        registerRepository.save(byUserMapId);

    }

    public MapNameListResponseDto findAllMaps() {
        List<MapName> MapNameList = mapleLandMapListRepository.findAll()
                .stream()
                .map(e -> new MapName(e.getMapleLandMapListId(),
                        e.getMapName(),e.getMiniMapImageLogoUrl()))
                .toList();

        return new MapNameListResponseDto(MapNameList);
    }
}