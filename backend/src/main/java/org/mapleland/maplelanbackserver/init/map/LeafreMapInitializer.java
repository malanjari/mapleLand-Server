package org.mapleland.maplelanbackserver.init.map;

import lombok.RequiredArgsConstructor;
import org.mapleland.maplelanbackserver.enumType.Region;
import org.mapleland.maplelanbackserver.repository.MapleMapRepository;
import org.mapleland.maplelanbackserver.table.MapleMap;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LeafreMapInitializer{

    private final MapleMapRepository mapleMapRepository;



             public void initLeafre() {




            // -------------------------리프레 ---------------------------------------------


            mapleMapRepository.save(MapleMap
                    .builder().
                    mapName("미나르숲:산양의 골짜기 1")
                    .region(Region.MinarForest)
                    .monsterImageUrl("https://maplestory.io/api/gms/62/mob/8140110/icon?resize=2")
                    .subRegion("미나르 숲")
                    .miniMapImageUrl("https://mapledb.kr/Assets/image/minimaps/240010500.png")
                    .miniMapImageLogoUrl("https://maplestory.io/api/gms/62/map/240010500/icon?resize=2")
                    .build());

            mapleMapRepository.save(MapleMap
                    .builder().
                    mapName("미나르숲:숲의 갈림길")
                    .region(Region.MinarForest)
                    .monsterImageUrl("https://maplestory.io/api/gms/62/mob/8140110/icon?resize=2")
                    .subRegion("미나르 숲")
                    .miniMapImageUrl("https://mapledb.kr/Assets/image/minimaps/240010500.png")
                    .miniMapImageLogoUrl("https://maplestory.io/api/gms/62/map/240010500/icon?resize=2")
                    .build());

            mapleMapRepository.save(MapleMap
                    .builder().
                    mapName("히든스트리트:레드 와이번의 둥지")
                    .region(Region.MinarForest)
                    .monsterImageUrl("https://maplestory.io/api/gms/62/mob/8150300/icon?resize=2")
                    .subRegion("미나르 숲")
                    .miniMapImageUrl("https://mapledb.kr/Assets/image/minimaps/240040310.png")
                    .miniMapImageLogoUrl("https://maplestory.io/api/gms/62/map/240010500/icon?resize=2")
                    .build());

            mapleMapRepository.save(MapleMap
                    .builder().
                    mapName("히든스트리트:블루 와이번의 둥지")
                    .region(Region.MinarForest)
                    .monsterImageUrl("https://maplestory.io/api/gms/62/mob/8150301/icon?resize=2")
                    .subRegion("미나르 숲")
                    .miniMapImageUrl("https://mapledb.kr/Assets/image/minimaps/240040210.png")
                    .miniMapImageLogoUrl("https://maplestory.io/api/gms/62/map/240010500/icon?resize=2")
                    .build());

            mapleMapRepository.save(MapleMap
                    .builder().
                    mapName("미나르숲:망가진 용의 둥지")
                    .region(Region.MinarForest)
                    .monsterImageUrl("https://maplestory.io/api/gms/62/mob/8190000/icon?resize=2")
                    .subRegion("미나르 숲")
                    .miniMapImageUrl("https://mapledb.kr/Assets/image/minimaps/240040520.png")
                    .miniMapImageLogoUrl("https://maplestory.io/api/gms/62/map/240010500/icon?resize=2")
                    .build());

            mapleMapRepository.save(MapleMap
                    .builder().
                    mapName("미나르숲:용의 숲 입구")
                    .region(Region.MinarForest)
                    .monsterImageUrl("https://maplestory.io/api/gms/62/mob/8140701/icon?resize=2")
                    .subRegion("미나르 숲")
                    .miniMapImageUrl("https://mapledb.kr/Assets/image/minimaps/240030000.png")
                    .miniMapImageLogoUrl("https://maplestory.io/api/gms/62/map/240010500/icon?resize=2")
                    .build());

            mapleMapRepository.save(MapleMap
                    .builder().
                    mapName("미나르숲:불과 어둠의 전장")
                    .region(Region.MinarForest)
                    .monsterImageUrl("https://maplestory.io/api/gms/62/mob/8140102/icon?resize=2")
                    .subRegion("미나르 숲")
                    .miniMapImageUrl("https://mapledb.kr/Assets/image/minimaps/240020100.png")
                    .miniMapImageLogoUrl("https://maplestory.io/api/gms/62/map/240010500/icon?resize=2")
                    .build());

            mapleMapRepository.save(MapleMap
                    .builder().
                    mapName("미나르숲:검은 켄타우로스의 영역")
                    .region(Region.MinarForest)
                    .monsterImageUrl("https://maplestory.io/api/gms/62/mob/8140101/icon?resize=2")
                    .subRegion("미나르 숲")
                    .miniMapImageUrl("https://mapledb.kr/Assets/image/minimaps/240020200.png")
                    .miniMapImageLogoUrl("https://maplestory.io/api/gms/62/map/240010500/icon?resize=2")
                    .build());

            mapleMapRepository.save(MapleMap
                    .builder().
                    mapName("미나르숲:붉은 켄타우로스의 영역")
                    .region(Region.MinarForest)
                    .monsterImageUrl("https://maplestory.io/api/gms/62/mob/8140102/icon?resize=2")
                    .subRegion("미나르 숲")
                    .miniMapImageUrl("https://mapledb.kr/Assets/image/minimaps/240020000.png")
                    .miniMapImageLogoUrl("https://maplestory.io/api/gms/62/map/240010500/icon?resize=2")
                    .build());

            mapleMapRepository.save(MapleMap
                    .builder().
                    mapName("미나르숲:푸른 켄타우로스의 영역")
                    .region(Region.MinarForest)
                    .monsterImageUrl("https://maplestory.io/api/gms/62/mob/8140103/icon?resize=2")
                    .subRegion("미나르 숲")
                    .miniMapImageUrl("https://mapledb.kr/Assets/image/minimaps/240020400.png")
                    .miniMapImageLogoUrl("https://maplestory.io/api/gms/62/map/240010500/icon?resize=2")
                    .build());

            mapleMapRepository.save(MapleMap
                    .builder().
                    mapName("미나르숲:하늘 둥지2")
                    .region(Region.MinarForest)
                    .monsterImageUrl("https://maplestory.io/api/gms/62/mob/8140001/icon?resize=2")
                    .subRegion("미나르 숲")
                    .miniMapImageUrl("https://mapledb.kr/Assets/image/minimaps/240010600.png")
                    .miniMapImageLogoUrl("https://maplestory.io/api/gms/62/map/240010500/icon?resize=2")
                    .build());

                 mapleMapRepository.save(MapleMap
                         .builder().
                         mapName("미나르숲:불과 물의 전장")
                         .region(Region.MinarForest)
                         .monsterImageUrl("https://maplestory.io/api/gms/62/mob/8140103/icon?resize=2")
                         .subRegion("미나르 숲")
                         .miniMapImageUrl("https://mapledb.kr/Assets/image/minimaps/240020500.png")
                         .miniMapImageLogoUrl("https://maplestory.io/api/gms/62/map/240010500/icon?resize=2")
                         .build());

                 mapleMapRepository.save(MapleMap
                         .builder().
                         mapName("미나르숲:위험한 용의 둥지")
                         .region(Region.MinarForest)
                         .monsterImageUrl("https://maplestory.io/api/gms/62/mob/8190002/icon?resize=2")
                         .subRegion("미나르 숲")
                         .miniMapImageUrl("https://mapledb.kr/Assets/image/minimaps/240040521.png")
                         .miniMapImageLogoUrl("https://maplestory.io/api/gms/62/map/240010500/icon?resize=2")
                         .build());

                 mapleMapRepository.save(MapleMap
                         .builder().
                         mapName("미나르숲:큰 둥지 봉우리")
                         .region(Region.MinarForest)
                         .monsterImageUrl("https://maplestory.io/api/gms/62/mob/8190004/icon?resize=2")
                         .subRegion("미나르 숲")
                         .miniMapImageUrl("https://mapledb.kr/Assets/image/minimaps/240040600.png")
                         .miniMapImageLogoUrl("https://maplestory.io/api/gms/62/map/240010500/icon?resize=2")
                         .build());

                 mapleMapRepository.save(MapleMap
                         .builder().
                         mapName("미나르숲:남겨진 용의 둥지")
                         .region(Region.MinarForest)
                         .monsterImageUrl("https://maplestory.io/api/gms/62/mob/8190004/icon?resize=2")
                         .subRegion("미나르 숲")
                         .miniMapImageUrl("https://mapledb.kr/Assets/image/minimaps/240040511.png")
                         .miniMapImageLogoUrl("https://maplestory.io/api/gms/62/map/240010500/icon?resize=2")
                         .build());

                 mapleMapRepository.save(MapleMap
                         .builder().
                         mapName("미나르숲:마뇽의 숲")
                         .region(Region.MinarForest)
                         .monsterImageUrl("https://maplestory.io/api/gms/62/mob/9500174/icon?resize=2")
                         .subRegion("미나르 숲")
                         .miniMapImageUrl("https://mapleland-static-files.s3.ap-northeast-2.amazonaws.com/minonForest.png")
                         .miniMapImageLogoUrl("https://maplestory.io/api/gms/62/map/240010500/icon?resize=2")
                         .build());

                 mapleMapRepository.save(MapleMap
                         .builder().
                         mapName("미나르숲:그리프의 숲")
                         .region(Region.MinarForest)
                         .monsterImageUrl("https://maplestory.io/api/gms/62/mob/8180001/icon?resize=2")
                         .subRegion("미나르 숲")
                         .miniMapImageUrl("https://mapleland-static-files.s3.ap-northeast-2.amazonaws.com/grifForest.png")
                         .miniMapImageLogoUrl("https://maplestory.io/api/gms/62/map/240010500/icon?resize=2")
                         .build());




             }

    }

