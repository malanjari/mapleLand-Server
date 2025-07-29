package org.mapleland.maplelanbackserver.init.map;

import lombok.RequiredArgsConstructor;
import org.mapleland.maplelanbackserver.enumType.Region;
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
    private final MuLungGardenMapInitializer muLungGardenMapInitializer;
    private final MagatiaMapInitializer magatiaMapInitializer;

    @Override
    public void run(String... args) throws Exception {

//        if(!mapleMapRepository.existsByRegion(Region.MuLung)) {
//
//        }

        if(mapleMapRepository.count() == 0){
            muLungGardenMapInitializer.initMuLungGarden();
           ellanasMapInitializer.initEllanas();
           ludibriumMapInitializer.initLudibrium();
           victoriaMapInitializer.VictoriaInit();
           leafreMapInitializer.initLeafre();
            muLungGardenMapInitializer.initMuLungGarden();
            magatiaMapInitializer.initMagatia();



        }
    }

}
