package org.mapleLand.maplelanbackserver.cache;

import lombok.RequiredArgsConstructor;
import org.mapleLand.maplelanbackserver.dto.PriceStatDto;
import org.mapleLand.maplelanbackserver.service.MapService;
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
            "미나르 숲:망가진용의둥지",
            "시계탑최하층:꼬여버린시간",
            "미나르 숲:마뇽의 숲",
            "미나르 숲:남겨진 용의 둥지",
            "미나르 숲:산양의 골짜기"
    );

    @Scheduled(cron = "0 0 * * * *")
    public void updatePopularMapStats() {
        for (String rawMapName : popularMapNames) {
            List<PriceStatDto> stats = mapService.iqrPriceAvgLast6Hours(rawMapName);
            cacheService.saveStat(rawMapName, stats); // 캐시 내부에서 normalize됨
        }
    }
}