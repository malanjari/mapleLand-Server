package org.mapleLand.maplelanbackserver.service;

import lombok.RequiredArgsConstructor;
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
