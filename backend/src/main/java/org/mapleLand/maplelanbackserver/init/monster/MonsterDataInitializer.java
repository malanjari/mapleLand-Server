package org.mapleland.maplelanbackserver.init.monster;

import lombok.RequiredArgsConstructor;
import org.mapleland.maplelanbackserver.repository.MonsterDropItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MonsterDataInitializer implements CommandLineRunner {

    private final MonsterDropItemRepository monsterDropItemRepository;
    private final VictoryMonsterDataInitializer victoryMonsterDataInitializer;
    private final OrbisMonsterDataInitializer orbisMonsterDataInitializer;
    private final LudibriumMonsterDataInitializer ludibriumMonsterDataInitializer;
    private final ElnathMonsterDataInitializer elnathMonsterDataInitializer;
    private final AquariumMonsterDataInitializer aquariumMonsterDataInitializer;
    private final LeafreMonsterDataInitializer leafreMonsterDataInitializer;

    @Override
    public void run(String... args) {
        if (monsterDropItemRepository.count() == 0) {
            try {
                System.out.println("🟡 victoriaMonsterInit() 시작");
                victoryMonsterDataInitializer.victoriaMonsterInit();
                System.out.println("✅ victoriaMonsterInit() 완료");

                System.out.println("🟡 orbisMonsterInit() 시작");
                orbisMonsterDataInitializer.initOrbisMonsterData();
                System.out.println("✅ orbisMonsterInit() 완료");

                System.out.println("🟡 ludibriumMonsterInit() 시작");
                ludibriumMonsterDataInitializer.initLudibriumMonsterData();

                System.out.println("🟡 elnathMonsterInit() 시작");
                elnathMonsterDataInitializer.initElnathMonsterData();

                System.out.println("🟡 aquariumMonsterInit() 시작");
                aquariumMonsterDataInitializer.initAquariumMonsterData();

                leafreMonsterDataInitializer.initAquariumMonsterData();

            } catch (Exception e) {
                System.out.println("❌ 초기화 중단됨: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }
}