package org.mapleland.maplelanbackserver.cache;

import lombok.RequiredArgsConstructor;
import org.mapleland.maplelanbackserver.service.MapPopularityService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PopularMapScheduler {

    private final MapPopularityService popularityService;


    @Scheduled(fixedRate = 10 * 60 * 1000) // ms 단위 → 5분
    public void updatePopularMapsHourly() {
        popularityService.refreshPopularMaps();
    }

}
