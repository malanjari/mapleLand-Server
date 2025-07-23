package org.mapleland.maplelanbackserver.cache;

import lombok.RequiredArgsConstructor;
import org.mapleland.maplelanbackserver.dto.response.PriceStatDto;
import org.mapleland.maplelanbackserver.service.MapService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class PriceStatScheduler {

    private final MapService mapService;
    private final MapPriceStatCacheService cacheService;

    // 미리 지정한 인기 맵 목록만 정각마다 계산 & 캐시
    private static final List<String> popularMapNames = List.of(
            "미나르숲:망가진 용의 둥지",
            "폐광:죽은 나무의 숲 2",
            "히든스트리트:블루 와이번의 둥지",
            "미나르숲:남겨진 용의 둥지",
            "미나르숲:산양의 골짜기 1"
    );

    @Scheduled(cron = "0 0 * * * *")
    public void updatePopularMapStats() {
        for (String rawMapName : popularMapNames) {
            List<PriceStatDto> stats = mapService.iqrPriceAvgLast6Hours(rawMapName);
            cacheService.saveStat(rawMapName, stats); // 캐시 내부에서 normalize됨
        }
    }
}