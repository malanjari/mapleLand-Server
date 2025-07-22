package org.mapleland.maplelanbackserver.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mapleland.maplelanbackserver.dto.Map.*;
import org.mapleland.maplelanbackserver.dto.response.DropItemResponse;
import org.mapleland.maplelanbackserver.dto.request.JariUpdateRequest;
import org.mapleland.maplelanbackserver.dto.request.JariIsCompletedRequest;
import org.mapleland.maplelanbackserver.dto.response.PriceStatDto;
import org.mapleland.maplelanbackserver.dto.update.PriceUpdateRequest;
import org.mapleland.maplelanbackserver.dto.update.ServerColorRequest;
import org.mapleland.maplelanbackserver.enumType.Region;
import org.mapleland.maplelanbackserver.enumType.alert.AlertStatus;
import org.mapleland.maplelanbackserver.exception.coflict.CoolDownConflictException;
import org.mapleland.maplelanbackserver.exception.notfound.jari.NotFoundMapException;
import org.mapleland.maplelanbackserver.exception.notfound.jari.NotFoundMapTicketException;
import org.mapleland.maplelanbackserver.exception.notfound.jari.NotFoundUserException;
import org.mapleland.maplelanbackserver.exception.unauthorization.UserMismatchException;
import org.mapleland.maplelanbackserver.filter.AdminCheckFilter;
import org.mapleland.maplelanbackserver.jwtUtil.JwtUtil;
import org.mapleland.maplelanbackserver.repository.*;
import org.mapleland.maplelanbackserver.resolve.RegionResolver;
import org.mapleland.maplelanbackserver.table.*;
import org.mapleland.maplelanbackserver.utilmethod.UtilMethod;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.*;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class MapService {

    ModelMapper modelMapper = new ModelMapper();
    private final JariRepository registerRepository;
    private final UserRepository userRepository;
    private final MapleMapRepository mapleMapRepository;
    private final JariRepository jariRepository;
    private final MonsterDropItemRepository monsterDropItemRepository;
    private final DiscordDmService dmService;
    private final MapInterRestRepository interestRepository;
    private final UtilMethod utilMethod;
    private final WebSocketService webSocketService;

    String message;
    @Value("${frontend.redirect-url}")
    private String redirectUrl;


    public void mapRegisterServiceMethod(JariCreatedRequest dto, String token) {

        int userId = JwtUtil.getUserId(token);
        String discordId = JwtUtil.getDiscordId(token);


        //사용자 검색 -> 사용자 값 꺼내옴
        User user = userRepository.findByUserId(userId)
                .orElseThrow(() -> new NotFoundUserException("유저를 찾을 수 없습니다."));



        // 지역 정보 추출
        Region region = RegionResolver.getRegionEnumByMapName(dto.getMapName());


        // 매칭 맵 정보 추출
        MapleMap mapInfo = getFirstMatchedMap(dto.getMapName());

        // 등록 티켓 확인
        if (!user.getMapTicket()) {
            throw new NotFoundMapTicketException("등록 티켓이 없습니다. \n 등록한 자리를 거래 완료 처리를 해야 합니다");
        }

        String role = AdminCheckFilter.adminCheckFilter(discordId);

        if(role.equals("ROLE_ADMIN")) user.setMapTicket(true);


        else user.setMapTicket(false);

        // Entity 변환 및 등록
        Jari entity = modelMapper.map(dto, Jari.class);
        entity.setUserMapId(null);
        entity.setArea(region);
        entity.setIsCompleted(false);
        entity.setMonsterImageUrl(mapInfo.getMonsterImageUrl());
        entity.setUser(user);

        interRestUser(dto,userId);
        registerRepository.save(entity);
        webSocketService.sendLatestPosts(userId);


    }


    public String buildMapUrl(String mapName) {
        String encoded = URLEncoder.encode(mapName, StandardCharsets.UTF_8)
                .replace("+", "%20");
        return redirectUrl + "/jari/" + encoded;
    }
    public void interRestUser(JariCreatedRequest dto, int userId){

        Set<Integer> alreadySendCheck = new HashSet<>();


        List<MapInterRest> allByMapName = interestRepository.
                findByMapleMap_MapleLandMapListId(dto.getMapId());

        String url = buildMapUrl(dto.getMapName());

        for(MapInterRest user : allByMapName) {
            String discordId = user.getUser().getDiscordId();

            User targetUser = user.getUser();
            int targetUserId = targetUser.getUserId();

            if (alreadySendCheck.contains(targetUserId)) continue;

            if(targetUser.getUserId().equals(userId)) {
                message =  String.format("""
                📢 **%s** 맵이(가) 등록되었습니다!
                        
                💰 가격: %,d 메소 \s
                
                🔗 바로가기: <%s>
                        
                ⚠️ 분쟁 자리 또는 허위 매물 등록 시 제재될 수 있습니다.
                """, dto.getMapName(), dto.getPrice(), url);
            }else  {
                message =  String.format("""
               📢 관심맵 : **%s** 맵이(가) 등록되었습니다!
                        
                💰 가격: %,d 메소 \s
                
                🔗 바로가기: <%s>
                        
                        
            """, dto.getMapName(), dto.getPrice(),url);
            }


            dmService.sendToUser(discordId,message);
            alreadySendCheck.add(targetUser.getUserId());
        }

        if(!alreadySendCheck.contains(userId)) {
            User user = userRepository.findByUserId(userId).
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

    public AlertStatus MapInterRestServiceMethod(AlertRequest dto, String token) {

        return utilMethod.updateAlertInterest(dto,token);
    }

    public MapResponse searchMapsListKeyword(String keyword){



        List<DropItemResponse> dropItemResponses = monsterInfo(keyword);
        List<PriceStatDto> priceStatDtos = iqrPriceAvgLast6Hours(keyword);



        return new MapResponse(dropItemResponses, priceStatDtos);
    }



    public List<JariResponse> searchMapsByKeyword(String keyword) {
        PageRequest pageRequest = PageRequest.of(0, 100); // 첫 페이지, 100개
        List<Jari> results = jariRepository.findTop100ByMapNameWithUser(keyword,pageRequest);


        return results.stream()
                .map(e -> {
                    var user = e.getUser();
                    return new JariResponse(
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

    public MapleMap getFirstMatchedMap(String keyword) {
        return mapleMapRepository
                .findByMapNameExact(keyword)
                .stream()
                .findFirst()
                .orElseThrow(()-> new NotFoundUserException("맵을 찾을 수 없습니다."));
    }


    public List<DropItemResponse> monsterInfo(String keyword) {

        List<MonsterDropItem> byMapName = monsterDropItemRepository.findByMapName(keyword);

        return byMapName.stream().map(
                        p-> new DropItemResponse(p.getMapName(),
                                p.getItemName(),
                                p.getItemImageUrl(),p.getDropRate()))
                .toList();
    }



    public List<JariResponse> findByRegionTag(String keyword){
        List<Jari> byArea = jariRepository.findByArea(Region.valueOf(keyword));



        return byArea.stream()
                .map(e -> {
                    var user = e.getUser();
                    return new JariResponse(
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
        List<Jari> completed =
                jariRepository.findCompletedByMapNameIgnoreSpaceAndDate(keyword, startTime, endTime);

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
                    .map(Jari::getPrice)
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

    public void mapUpdateAll(JariUpdateRequest jariUpdateRequest,String token){

        //jwt 유저 토큰 아이디
        int userId = JwtUtil.getUserId(token);

        Jari byUserMapId = registerRepository.findByUserMapId(jariUpdateRequest.mapId());
        if (byUserMapId == null) {
            throw new NotFoundMapException("존재하지 않는 mapId입니다: " + jariUpdateRequest.mapId());
        }
        Jari jariId = jariRepository.findByUserMapId(jariUpdateRequest.mapId());


        if(userId != jariId.getUserMapId()) throw new UserMismatchException("사용자가 다릅니다.");

        byUserMapId.setServerColor(jariUpdateRequest.serverColor());
        byUserMapId.setPrice(jariUpdateRequest.price());
        byUserMapId.setNegotiationOption(jariUpdateRequest.negotiationOption());
        byUserMapId.setComment(jariUpdateRequest.comment());

        registerRepository.save(byUserMapId);

    }


    public void mapUpdatePrice(PriceUpdateRequest priceDto) {
        Jari byUserId = registerRepository.findByUserMapId(priceDto.mapId());
        byUserId.setPrice(priceDto.price());
        registerRepository.save(byUserId);

    }

    public void mapUpdateServerColor(ServerColorRequest dto) {
        Jari byUserId = registerRepository.findByUserMapId(dto.mapId());
        byUserId.setServerColor(dto.color());
        registerRepository.save(byUserId);
    }

    public void mapDelete(int mapId,String token) {


        Jari byUserId = registerRepository.findByUserMapId(mapId);
        int userId = JwtUtil.getUserId(token);

        if(byUserId.getUser().getUserId() == userId || JwtUtil.getRole(token).equals("ROLE_ADMIN")) {
            registerRepository.delete(byUserId);
        }
        else throw new UserMismatchException("등록된 게시글과 다른 사용자 입니다.");



    }

    public void updateIsCompleted(JariIsCompletedRequest dto , String token) {
        int userId = JwtUtil.getUserId(token);
        Jari jari = registerRepository.findByUserMapId(dto.mapId());
        if(jari == null) throw new NotFoundMapException("게시글을 찾을 수 없습니다.");


        if(jari.getUser().getUserId() != userId) throw new UserMismatchException("사용자가 다릅니다.");

        User user = userRepository.findByUserId(userId).
                orElseThrow(() -> new NotFoundUserException("사용자를 찾을 수 없습니다."));

        jari.setIsCompleted(true);
        user.setMapTicket(true);



        registerRepository.save(jari);
        userRepository.save(user);

    }

    public MapNameListResponse findAllMaps() {
        List<MapName> MapNameList = mapleMapRepository.findAll()
                .stream()
                .map(e -> new MapName(e.getMapleLandMapListId(),
                        e.getMapName(),
                        e.getMonsterImageUrl(),
                        e.getMiniMapImageUrl(),
                        e.getMiniMapImageLogoUrl()
                ))
                .toList();

        return new MapNameListResponse(MapNameList);
    }

    public void bumpJari(UserInformationService userInformationService, Integer jariId) {

        Jari jari = jariRepository.findById(jariId).orElseThrow(RuntimeException::new);


        if (!jari.validateOwner(userInformationService.getUserId())) {
            throw new UserMismatchException("사용자가 아닙니다."); // 401
        }

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime createTime = jari.getCreateTime();
        long minutesElapsed = Duration.between(createTime, now).toMinutes();
        long remainingMinutes = 60 - minutesElapsed;
        long remainingSeconds = Duration.between(createTime, now).getSeconds() % 60;


        if (Duration.between(createTime, now).toMinutes() < 60) {
            String message = String.format
                    ("끌올은 한 시간에 한 번만 가능합니다. \n(%d분 %d초 후 다시 시도해주세요)", remainingMinutes, 60 - remainingSeconds);
            throw new CoolDownConflictException(message); // 404
        }

        jari.bump(now);

    }
}
