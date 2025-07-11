package org.mapleLand.maplelanbackserver.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mapleLand.maplelanbackserver.dto.Map.MapPopularityDto;
import org.mapleLand.maplelanbackserver.enumType.Region;
import org.mapleLand.maplelanbackserver.repository.UserMapRegisterRepository;
import org.mapleLand.maplelanbackserver.table.MapRegistrationEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Slf4j
public class MapPopularityService {

    private List<MapPopularityDto> cachedPopularMaps = List.of();

    private final UserMapRegisterRepository mapRegisterRepository;


    private static final Map<Region, List<String>> regionPrefixes = Map.of(
            Region.Victoria, List.of("빅토리아 로드:"),
            Region.LudusLake, List.of("루디브리엄성:"),
            Region.Elnath, List.of("엘나스산맥:"),
            Region.MinarForest, List.of("히든스트리트:","미나르숲:"),
            Region.AquaRoad, List.of("아쿠아로드:"),
            Region.Orbis, List.of("스카이로드:")
            // 필요한 지역 더 추가 가능
    );

    public List<MapPopularityDto> getTopPopularMaps(int limit) {
        return cachedPopularMaps.stream().limit(limit).toList();
    }
    public void refreshPopularMaps() {
        LocalDateTime oneWeekAgo = LocalDateTime.now().minusDays(7);
        List<MapRegistrationEntity> entities = mapRegisterRepository.findAllWithinOneWeek(oneWeekAgo);

        System.out.println("🕒 [인기맵 갱신] 최근 일주일 등록 수: " + entities.size());

        Map<String, List<MapRegistrationEntity>> grouped = entities.stream()
                .collect(Collectors.groupingBy(MapRegistrationEntity::getMapName));

        this.cachedPopularMaps = grouped.entrySet().stream()
                .map(entry -> {
                    String mapName = entry.getKey();
                    List<MapRegistrationEntity> maps = entry.getValue();

                    int registerCount = maps.size();
                    String area = maps.get(0).getArea().name();
                    String monsterImg = maps.get(0).getMonsterImageUrl();

                    return new MapPopularityDto(mapName, registerCount, area, monsterImg);
                })
                .sorted(Comparator.comparingInt(MapPopularityDto::registerCount).reversed())
                .limit(9)
                .toList();

        System.out.println("✅ [인기맵 갱신 완료] 캐시된 인기맵 수: " + this.cachedPopularMaps.size());
    }
    public String removedPrefixByRegion(String input,Region region) {
        List<String> strings = regionPrefixes.get(region);

        for(String item : strings) {
            if(input.startsWith(item)) {
                return input.substring(item.length()).trim();
            }
        }
        return input;
    }
    private double getPercentile(List<Integer> sortedList, double percentile) {
        if (sortedList.isEmpty()) return 0;
        int index = (int) Math.ceil(percentile / 100.0 * sortedList.size()) - 1;
        return sortedList.get(Math.max(0, Math.min(index, sortedList.size() - 1)));
    }
}
