package org.mapleland.maplelanbackserver.init.map;

import lombok.RequiredArgsConstructor;
import org.mapleland.maplelanbackserver.enumType.Region;
import org.mapleland.maplelanbackserver.enumType.victoria.VictoriaLoadRegion;
import org.mapleland.maplelanbackserver.repository.MapleMapRepository;
import org.mapleland.maplelanbackserver.table.MapleMap;
import org.springframework.stereotype.Component;
@Component
@RequiredArgsConstructor
public class VictoriaMapInitializer {

    private final MapleMapRepository mapleMapRepository;


        public void VictoriaInit(){


            // --------------- 빅토리아 아일랜드 --------------------------------------------

                mapleMapRepository.save(MapleMap
                        .builder().
                        mapName("히든스트리트: 골렘의 숲")
                        .region(Region.Victoria)
                        .monsterImageUrl(" https://maplestory.io/api/gms/62/mob/5130102/icon?resize=2")
                        .miniMapImageUrl("https://mapledb.kr/Assets/image/minimaps/105040306.png")
                        .subRegion(VictoriaLoadRegion.SLEEPYWOOD.getDisplayName())
                        .miniMapImageLogoUrl("https://maplestory.io/api/gms/62/item/4001148/icon?resize=2")
                        .build());

                mapleMapRepository.save(MapleMap
                        .builder().
                        mapName("일본:버섯의 전당")
                        .region(Region.Victoria)
                        .subRegion("일본")
                        .miniMapImageUrl("https://mapledb.kr/Assets/image/minimaps/800010100.png")
                        .miniMapImageLogoUrl("https://maplestory.io/api/gms/62/mob/9400205/render/stand")
                        .build());

            }
        }


