package org.mapleLand.maplelanbackserver.init.map;

import lombok.RequiredArgsConstructor;
import org.mapleLand.maplelanbackserver.service.MapPopularityService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@org.springframework.core.annotation.Order(3)
public class PopularMapInitRunner implements CommandLineRunner {

    private final MapPopularityService popularityService;

    @Override
    public void run(String... args) {
        System.out.println("🔥 서버 시작 시 최초 인기맵 캐시 초기화");
        popularityService.refreshPopularMaps();
    }
}
