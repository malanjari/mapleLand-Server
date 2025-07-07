package org.mapleLand.maplelanbackserver.cache;

import lombok.RequiredArgsConstructor;
import org.mapleLand.maplelanbackserver.service.MapPopularityService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PopularMapScheduler {

    private final MapPopularityService popularityService;


    @Scheduled(fixedRate = 60 * 60 * 1000) // ms 단위 → 1시간
    public void updatePopularMapsHourly() {
        popularityService.refreshPopularMaps();
    }

}
