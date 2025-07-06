package org.mapleLand.maplelanbackserver.init.map;

import lombok.RequiredArgsConstructor;
import org.mapleLand.maplelanbackserver.enumType.Region;
import org.mapleLand.maplelanbackserver.enumType.victoria.VictoriaLoadRegion;
import org.mapleLand.maplelanbackserver.repository.MapleLandMapListRepository;
import org.mapleLand.maplelanbackserver.table.MapleLandMapListEntity;
import org.springframework.stereotype.Component;
@Component
@RequiredArgsConstructor
public class VictoriaMapInitializer {

    private final MapleLandMapListRepository mapleLandMapListRepository;


        public void VictoriaInit(){


            // --------------- 빅토리아 아일랜드 --------------------------------------------

                mapleLandMapListRepository.save(MapleLandMapListEntity
                        .builder().
                        mapName("히든스트리트: 골렘의 숲")
                        .region(Region.Victoria)
                        .monsterImageUrl(" https://maplestory.io/api/gms/62/mob/5130102/icon?resize=2")
                        .miniMapImageUrl("https://mapledb.kr/Assets/image/minimaps/105040306.png")
                        .subRegion(VictoriaLoadRegion.SLEEPYWOOD.getDisplayName())
                        .miniMapImageLogoUrl("https://maplestory.io/api/gms/62/item/4001148/icon?resize=2")
                        .build());

                mapleLandMapListRepository.save(MapleLandMapListEntity
                        .builder().
                        mapName("일본:버섯의 전당")
                        .region(Region.Victoria)
                        .subRegion("일본")
                        .miniMapImageUrl("https://mapledb.kr/Assets/image/minimaps/800010100.png")
                        .miniMapImageLogoUrl("https://maplestory.io/api/gms/62/mob/9400205/render/stand")
                        .build());

            }
        }


