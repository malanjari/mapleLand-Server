package org.mapleland.maplelanbackserver.init.map;

import lombok.RequiredArgsConstructor;
import org.mapleland.maplelanbackserver.enumType.Region;
import org.mapleland.maplelanbackserver.enumType.mulung.MuLungGardenRegion;
import org.mapleland.maplelanbackserver.repository.MapleMapRepository;
import org.mapleland.maplelanbackserver.table.MapleMap;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MuLungGardenMapInitializer {

    private final MapleMapRepository mapleMapRepository;

    public void initMuLungGarden() {
        mapleMapRepository.save(MapleMap
                .builder().
                mapName("무릉도원: 하늘 숲 입구")
                .region(Region.MuLung)
                .monsterImageUrl("https://maplestory.io/api/gms/62/mob/4230500/icon?resize=2")
                .miniMapImageUrl("https://mapledb.kr/Assets/image/minimaps/250010000.png")
                .miniMapImageLogoUrl("https://maplestory.io/api/gms/62/map/250010000/icon?resize=2")
                .subRegion(MuLungGardenRegion.MuLungGarden.getDisplayName())
                .build());

        mapleMapRepository.save(MapleMap
                .builder().
                mapName("무릉도원: 하늘 숲 오솔길")
                .region(Region.MuLung)
                .monsterImageUrl("https://maplestory.io/api/gms/62/mob/4230501/icon?resize=2")
                .miniMapImageUrl("https://mapledb.kr/Assets/image/minimaps/250010100.png")
                .miniMapImageLogoUrl("https://maplestory.io/api/gms/62/map/250010000/icon?resize=2")
                .subRegion(MuLungGardenRegion.MuLungGarden.getDisplayName())
                .build());

        mapleMapRepository.save(MapleMap
                .builder().
                mapName("무릉도원: 하늘 숲 깊은 곳")
                .region(Region.MuLung)
                .monsterImageUrl("https://maplestory.io/api/gms/62/mob/4230502/icon?resize=2")
                .miniMapImageUrl("https://mapledb.kr/Assets/image/minimaps/250010200.png")
                .miniMapImageLogoUrl("https://maplestory.io/api/gms/62/map/250010000/icon?resize=2")
                .subRegion(MuLungGardenRegion.MuLungGarden.getDisplayName())
                .build());

        mapleMapRepository.save(MapleMap
                .builder().
                mapName("무릉도원: 하늘 숲이 끝나는 곳")
                .region(Region.MuLung)
                .monsterImageUrl("https://maplestory.io/api/gms/62/mob/4230504/icon?resize=2")
                .miniMapImageUrl("https://mapledb.kr/Assets/image/minimaps/250010400.png")
                .miniMapImageLogoUrl("https://maplestory.io/api/gms/62/map/250010000/icon?resize=2")
                .subRegion(MuLungGardenRegion.MuLungGarden.getDisplayName())
                .build());

        mapleMapRepository.save(MapleMap
                .builder().
                mapName("무릉도원: 하늘 숲이 끝나는 곳")
                .region(Region.MuLung)
                .monsterImageUrl("https://maplestory.io/api/gms/62/mob/4230504/icon?resize=2")
                .miniMapImageUrl("https://mapledb.kr/Assets/image/minimaps/250010400.png")
                .miniMapImageLogoUrl("https://maplestory.io/api/gms/62/map/250010000/icon?resize=2")
                .subRegion(MuLungGardenRegion.MuLungGarden.getDisplayName())
                .build());

        mapleMapRepository.save(MapleMap
                .builder().
                mapName("무릉도원: 꽃뱀의 영토")
                .region(Region.MuLung)
                .monsterImageUrl("https://maplestory.io/api/gms/62/mob/9300160/icon?resize=2")
                .miniMapImageUrl("https://mapledb.kr/Assets/image/minimaps/250010300.png")
                .miniMapImageLogoUrl("https://maplestory.io/api/gms/62/map/250010000/icon?resize=2")
                .subRegion(MuLungGardenRegion.MuLungGarden.getDisplayName())
                .build());

        mapleMapRepository.save(MapleMap
                .builder().
                mapName("무릉도원: 야생곰의 영토1")
                .region(Region.MuLung)
                .monsterImageUrl("https://maplestory.io/api/gms/62/mob/5120500/icon?resize=2")
                .miniMapImageUrl("https://mapledb.kr/Assets/image/minimaps/250010301.png")
                .miniMapImageLogoUrl("https://maplestory.io/api/gms/62/map/250010000/icon?resize=2")
                .subRegion(MuLungGardenRegion.MuLungGarden.getDisplayName())
                .build());

        mapleMapRepository.save(MapleMap
                .builder().
                mapName("무릉도원: 야생곰의 영토2")
                .region(Region.MuLung)
                .monsterImageUrl("https://maplestory.io/api/gms/62/mob/6130203/icon?resize=2")
                .miniMapImageUrl("https://mapledb.kr/Assets/image/minimaps/250010302.png")
                .miniMapImageLogoUrl("https://maplestory.io/api/gms/62/map/250010000/icon?resize=2")
                .subRegion(MuLungGardenRegion.MuLungGarden.getDisplayName())
                .build());

        mapleMapRepository.save(MapleMap
                .builder().
                mapName("무릉도원: 야생곰의 영토2")
                .region(Region.MuLung)
                .monsterImageUrl("https://maplestory.io/api/gms/62/mob/6130203/icon?resize=2")
                .miniMapImageUrl("https://mapledb.kr/Assets/image/minimaps/250010302.png")
                .miniMapImageLogoUrl("https://maplestory.io/api/gms/62/map/250010000/icon?resize=2")
                .subRegion(MuLungGardenRegion.MuLungGarden.getDisplayName())
                .build());

        mapleMapRepository.save(MapleMap
                .builder().
                mapName("무릉도원: 야생곰의 영토3")
                .region(Region.MuLung)
                .monsterImageUrl("https://maplestory.io/api/gms/62/mob/6130203/icon?resize=2")
                .miniMapImageUrl("https://mapledb.kr/Assets/image/minimaps/250010303.png")
                .miniMapImageLogoUrl("https://maplestory.io/api/gms/62/map/250010000/icon?resize=2")
                .subRegion(MuLungGardenRegion.MuLungGarden.getDisplayName())
                .build());

        mapleMapRepository.save(MapleMap
                .builder().
                mapName("무릉도원: 떠돌이곰의 영토")
                .region(Region.MuLung)
                .monsterImageUrl("https://maplestory.io/api/gms/62/mob/6130203/icon?resize=2")
                .miniMapImageUrl("https://mapledb.kr/Assets/image/minimaps/250010304.png")
                .miniMapImageLogoUrl("https://maplestory.io/api/gms/62/map/250010000/icon?resize=2")
                .subRegion(MuLungGardenRegion.MuLungGarden.getDisplayName())
                .build());

        mapleMapRepository.save(MapleMap
                .builder().
                mapName("무릉도원: 안개 낀 숲")
                .region(Region.MuLung)
                .monsterImageUrl("https://maplestory.io/api/gms/62/mob/9300164/icon?resize=2")
                .miniMapImageUrl("https://mapledb.kr/Assets/image/minimaps/250010501.png")
                .miniMapImageLogoUrl("https://maplestory.io/api/gms/62/map/250010000/icon?resize=2")
                .subRegion(MuLungGardenRegion.MuLungGarden.getDisplayName())
                .build());

        mapleMapRepository.save(MapleMap
                .builder().
                mapName("무릉도원: 선인의 숲")
                .region(Region.MuLung)
                .monsterImageUrl("https://maplestory.io/api/gms/62/mob/6130209/icon?resize=2")
                .miniMapImageUrl("https://mapledb.kr/Assets/image/minimaps/250010502.png")
                .miniMapImageLogoUrl("https://maplestory.io/api/gms/62/map/250010000/icon?resize=2")
                .subRegion(MuLungGardenRegion.MuLungGarden.getDisplayName())
                .build());

        mapleMapRepository.save(MapleMap
                .builder().
                mapName("무릉도원: 요괴의 숲")
                .region(Region.MuLung)
                .monsterImageUrl("https://maplestory.io/api/gms/62/mob/6130209/icon?resize=2")
                .miniMapImageUrl("https://mapledb.kr/Assets/image/minimaps/250010503.png")
                .miniMapImageLogoUrl("https://maplestory.io/api/gms/62/map/250010000/icon?resize=2")
                .subRegion(MuLungGardenRegion.MuLungGarden.getDisplayName())
                .build());

        mapleMapRepository.save(MapleMap
                .builder().
                mapName("히든스트리트: 요괴의 숲2")
                .region(Region.MuLung)
                .monsterImageUrl("https://maplestory.io/api/gms/62/mob/6130209/icon?resize=2")
                .miniMapImageUrl("https://mapledb.kr/Assets/image/minimaps/250010504.png")
                .miniMapImageLogoUrl("https://maplestory.io/api/gms/62/map/250010000/icon?resize=2")
                .subRegion(MuLungGardenRegion.MuLungGarden.getDisplayName())
                .build());

        mapleMapRepository.save(MapleMap
                .builder().
                mapName("무릉도원: 천도 과수원1")
                .region(Region.MuLung)
                .monsterImageUrl("https://maplestory.io/api/gms/62/mob/9300165/icon?resize=2")
                .miniMapImageUrl("https://mapledb.kr/Assets/image/minimaps/250010500.png")
                .miniMapImageLogoUrl("https://maplestory.io/api/gms/62/map/250010000/icon?resize=2")
                .subRegion(MuLungGardenRegion.MuLungGarden.getDisplayName())
                .build());

        mapleMapRepository.save(MapleMap
                .builder().
                mapName("무릉도원: 천도 과수원2")
                .region(Region.MuLung)
                .monsterImageUrl("https://maplestory.io/api/gms/62/mob/5120505/icon?resize=2")
                .miniMapImageUrl("https://mapledb.kr/Assets/image/minimaps/250010600.png")
                .miniMapImageLogoUrl("https://maplestory.io/api/gms/62/map/250010000/icon?resize=2")
                .subRegion(MuLungGardenRegion.MuLungGarden.getDisplayName())
                .build());

        mapleMapRepository.save(MapleMap
                .builder().
                mapName("무릉도원: 천도 과수원3")
                .region(Region.MuLung)
                .monsterImageUrl("https://maplestory.io/api/gms/62/mob/5120505/icon?resize=2")
                .miniMapImageUrl("https://mapledb.kr/Assets/image/minimaps/250010700.png")
                .miniMapImageLogoUrl("https://maplestory.io/api/gms/62/map/250010000/icon?resize=2")
                .subRegion(MuLungGardenRegion.MuLungGarden.getDisplayName())
                .build());

        mapleMapRepository.save(MapleMap
                .builder().
                mapName("무릉도원: 빨간코 해적단 소굴1")
                .region(Region.MuLung)
                .monsterImageUrl("https://maplestory.io/api/gms/62/mob/6130208/icon?resize=2")
                .miniMapImageUrl("https://mapledb.kr/Assets/image/minimaps/251010401.png")
                .miniMapImageLogoUrl("https://maplestory.io/api/gms/62/map/251010401/icon?resize=2")
                .subRegion(MuLungGardenRegion.BaekchoVillage.getDisplayName())
                .build());

        mapleMapRepository.save(MapleMap
                .builder().
                mapName("무릉도원: 빨간코 해적단 소굴2")
                .region(Region.MuLung)
                .monsterImageUrl("https://maplestory.io/api/gms/62/mob/7130104/icon?resize=2")
                .miniMapImageUrl("https://mapledb.kr/Assets/image/minimaps/251010402.png")
                .miniMapImageLogoUrl("https://maplestory.io/api/gms/62/map/251010401/icon?resize=2")
                .subRegion(MuLungGardenRegion.BaekchoVillage.getDisplayName())
                .build());

        mapleMapRepository.save(MapleMap
                .builder().
                mapName("무릉도원: 빨간코 해적단 소굴3")
                .region(Region.MuLung)
                .monsterImageUrl("https://maplestory.io/api/gms/62/mob/7130104/icon?resize=2")
                .miniMapImageUrl("https://mapledb.kr/Assets/image/minimaps/251010403.png")
                .miniMapImageLogoUrl("https://maplestory.io/api/gms/62/map/251010401/icon?resize=2")
                .subRegion(MuLungGardenRegion.BaekchoVillage.getDisplayName())
                .build());
    }
}
