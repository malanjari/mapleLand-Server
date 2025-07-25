package org.mapleland.maplelanbackserver.init.map;

import lombok.RequiredArgsConstructor;
import org.mapleland.maplelanbackserver.repository.MapleMapRepository;
import org.mapleland.maplelanbackserver.service.MapPopularityService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@org.springframework.core.annotation.Order(1) // ✅ 먼저 실행
public class MapDataInitializer implements CommandLineRunner {

    private final EllanasMapInitializer ellanasMapInitializer;
    private final LudibriumMapInitializer ludibriumMapInitializer;
    private final VictoriaMapInitializer victoriaMapInitializer;
    private final LeafreMapInitializer leafreMapInitializer;
    private final MapleMapRepository mapleMapRepository;
    private final MapPopularityService popularityService;

    @Override
    public void run(String... args) throws Exception {

        if(mapleMapRepository.count() == 0){

           ellanasMapInitializer.initEllanas();
           ludibriumMapInitializer.initLudibrium();
           victoriaMapInitializer.VictoriaInit();
           leafreMapInitializer.initLeafre();

        }
    }

}
