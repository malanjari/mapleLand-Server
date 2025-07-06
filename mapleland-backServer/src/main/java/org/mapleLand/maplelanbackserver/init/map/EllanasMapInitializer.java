package org.mapleLand.maplelanbackserver.init.map;

import lombok.RequiredArgsConstructor;
import org.mapleLand.maplelanbackserver.enumType.elnath.ElnathRegion;
import org.mapleLand.maplelanbackserver.enumType.Region;
import org.mapleLand.maplelanbackserver.repository.MapleLandMapListRepository;
import org.mapleLand.maplelanbackserver.table.MapleLandMapListEntity;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class EllanasMapInitializer{


    private final MapleLandMapListRepository mapleLandMapListRepository;

        public void initEllanas() {

        // ---------------------스카이로드 --------------------------------

            mapleLandMapListRepository.save(MapleLandMapListEntity
                    .builder().
                    mapName("스카이로드:구름 공원1")
                    .region(Region.Orbis)
                    .monsterImageUrl("https://maplestory.io/api/gms/62/mob/3230200/icon?resize=2")
                    .miniMapImageUrl("https://mapledb.kr/Assets/image/minimaps/200010000.png")
                    .miniMapImageLogoUrl("https://maplestory.io/api/gms/62/map/200000000/icon?resize=2")
                    .subRegion(ElnathRegion.SKYLOAD.getDisplayName())
                    .build());


            mapleLandMapListRepository.save(MapleLandMapListEntity
                    .builder().
                    mapName("스카이로드:구름 공원2")
                    .region(Region.Orbis)
                    .monsterImageUrl("https://maplestory.io/api/gms/62/mob/4230106/icon?resize=2")
                    .miniMapImageUrl("https://mapledb.kr/Assets/image/minimaps/200020000.png")
                    .miniMapImageLogoUrl("https://maplestory.io/api/gms/62/map/200000000/icon?resize=2")
                    .subRegion(ElnathRegion.SKYLOAD.getDisplayName())
                    .build());


            mapleLandMapListRepository.save(MapleLandMapListEntity
                    .builder().
                    mapName("스카이로드:구름 공원3")
                    .region(Region.Orbis)
                    .monsterImageUrl("https://maplestory.io/api/gms/62/mob/4230106/icon?resize=2")
                    .miniMapImageUrl("https://mapledb.kr/Assets/image/minimaps/200040000.png")
                    .miniMapImageLogoUrl("https://maplestory.io/api/gms/62/map/200000000/icon?resize=2")
                    .subRegion(ElnathRegion.SKYLOAD.getDisplayName())
                    .build());


            mapleLandMapListRepository.save(MapleLandMapListEntity
                    .builder().
                    mapName("스카이로드:구름 공원4")
                    .region(Region.Orbis)
                    .monsterImageUrl("https://maplestory.io/api/gms/62/mob/3000001/icon?resize=2")
                    .miniMapImageUrl("https://mapledb.kr/Assets/image/minimaps/200050000.png")
                    .miniMapImageLogoUrl("https://maplestory.io/api/gms/62/map/200000000/icon?resize=2")
                    .subRegion(ElnathRegion.SKYLOAD.getDisplayName())
                    .build());


            mapleLandMapListRepository.save(MapleLandMapListEntity
                    .builder().
                    mapName("스카이로드:구름 공원5")
                    .region(Region.Orbis)
                    .monsterImageUrl("https://maplestory.io/api/gms/62/mob/5120000/icon?resize=2")
                    .miniMapImageUrl("https://mapledb.kr/Assets/image/minimaps/200070000.png")
                    .miniMapImageLogoUrl("https://maplestory.io/api/gms/62/map/200000000/icon?resize=2")
                    .subRegion(ElnathRegion.SKYLOAD.getDisplayName())
                    .build());


            mapleLandMapListRepository.save(MapleLandMapListEntity
                    .builder().
                    mapName("스카이로드:구름 공원6")
                    .region(Region.Elnath)
                    .monsterImageUrl("https://maplestory.io/api/gms/62/mob/5120000/icon?resize=2")
                    .miniMapImageUrl("https://mapledb.kr/Assets/image/minimaps/200080000.png")
                    .miniMapImageLogoUrl("https://maplestory.io/api/gms/62/map/200000000/icon?resize=2")
                    .subRegion(ElnathRegion.SKYLOAD.getDisplayName())
                    .build());


            // ------------------------- 엘나스 ---------------------------------------------

            mapleLandMapListRepository.save(MapleLandMapListEntity
                    .builder().
                    mapName("폐광:죽은 나무의 숲 1")
                    .region(Region.Elnath)
                    .monsterImageUrl("https://maplestory.io/api/gms/62/mob/5130107/icon?resize=2")
                    .miniMapImageUrl("https://mapledb.kr/Assets/image/minimaps/211041100.png")
                    .subRegion(ElnathRegion.ABANDONED_MINE.getDisplayName())
                    .miniMapImageLogoUrl("https://maplestory.io/api/gms/62/map/211040300/icon?resize=2")
                    .build());


            mapleLandMapListRepository.save(MapleLandMapListEntity
                    .builder().
                    mapName("폐광:죽은 나무의 숲 2")
                    .region(Region.Elnath)
                    .monsterImageUrl("https://maplestory.io/api/gms/62/mob/5130107/icon?resize=2")
                    .miniMapImageUrl("https://mapledb.kr/Assets/image/minimaps/211041200.png")
                    .subRegion(ElnathRegion.ABANDONED_MINE.getDisplayName())
                    .miniMapImageLogoUrl("https://maplestory.io/api/gms/62/map/211040300/icon?resize=2")
                    .build());

            mapleLandMapListRepository.save(MapleLandMapListEntity
                    .builder().
                    mapName("폐광:죽은 나무의 숲 3")
                    .region(Region.Elnath)
                    .monsterImageUrl("https://maplestory.io/api/gms/62/mob/5130107/icon?resize=2")
                    .miniMapImageUrl("https://mapledb.kr/Assets/image/minimaps/211041300.png")
                    .subRegion(ElnathRegion.ABANDONED_MINE.getDisplayName())
                    .miniMapImageLogoUrl("https://maplestory.io/api/gms/62/map/211040300/icon?resize=2")
                    .build());

            mapleLandMapListRepository.save(MapleLandMapListEntity
                    .builder().
                    mapName("폐광:죽은 나무의 숲 4")
                    .region(Region.Elnath)
                    .monsterImageUrl("https://maplestory.io/api/gms/62/mob/5130107/icon?resize=2")
                    .miniMapImageUrl("https://mapledb.kr/Assets/image/minimaps/211041400.png")
                    .subRegion(ElnathRegion.ABANDONED_MINE.getDisplayName())
                    .miniMapImageLogoUrl("https://maplestory.io/api/gms/62/map/211040300/icon?resize=2")
                    .build());

            mapleLandMapListRepository.save(MapleLandMapListEntity
                    .builder().
                    mapName("엘나스산맥:차디찬 벌판")
                    .region(Region.Elnath)
                    .monsterImageUrl("https://maplestory.io/api/gms/62/mob/5140000/icon?resize=2")
                    .miniMapImageUrl("https://mapledb.kr/Assets/image/minimaps/211050000.png")
                    .subRegion(ElnathRegion.EL_NATH_MOUNTAINS.getDisplayName())
                    .miniMapImageLogoUrl("https://maplestory.io/api/gms/62/map/211000000/icon?resize=2")
                    .build());

            // ----------아쿠아리움 ------------------

            mapleLandMapListRepository.save(MapleLandMapListEntity
                    .builder().
                    mapName("아쿠아로드:난파선의 무덤")
                    .region(Region.Aquarium)
                    .monsterImageUrl("https://maplestory.io/api/gms/62/mob/8150101/icon?resize=2")
                    .miniMapImageUrl("https://mapledb.kr/Assets/image/minimaps/230040400.png")
                    .miniMapImageLogoUrl("https://maplestory.io/api/gms/62/map/230040400/icon?resize=2")
                    .subRegion(ElnathRegion.Aquarium.getDisplayName())
                    .build());

            mapleLandMapListRepository.save(MapleLandMapListEntity
                    .builder().
                    mapName("아쿠아로드:깊은 바다 협곡1")
                    .region(Region.Aquarium)
                    .monsterImageUrl("https://maplestory.io/api/gms/62/mob/8140600/icon?resize=2")
                    .miniMapImageUrl("https://mapledb.kr/Assets/image/minimaps/230040000.png")
                    .miniMapImageLogoUrl("https://maplestory.io/api/gms/62/map/230040400/icon?resize=2")
                    .subRegion(ElnathRegion.Aquarium.getDisplayName())
                    .build());

            mapleLandMapListRepository.save(MapleLandMapListEntity
                    .builder().
                    mapName("아쿠아로드:깊은 바다 협곡2")
                    .region(Region.Aquarium)
                    .monsterImageUrl("https://maplestory.io/api/gms/62/mob/8140555/icon?resize=2")
                    .miniMapImageUrl("https://mapledb.kr/Assets/image/minimaps/230040100.png")
                    .miniMapImageLogoUrl("https://maplestory.io/api/gms/62/map/230040400/icon?resize=2")
                    .subRegion(ElnathRegion.Aquarium.getDisplayName())
                    .build());

            mapleLandMapListRepository.save(MapleLandMapListEntity
                    .builder().
                    mapName("아쿠아로드:위험한 바다 협곡1")
                    .region(Region.Aquarium)
                    .monsterImageUrl("https://maplestory.io/api/gms/62/mob/8141300/icon?resize=2")
                    .miniMapImageUrl("https://mapledb.kr/Assets/image/minimaps/230040200.png")
                    .miniMapImageLogoUrl("https://maplestory.io/api/gms/62/map/230040400/icon?resize=2")
                    .subRegion(ElnathRegion.Aquarium.getDisplayName())
                    .build());

            mapleLandMapListRepository.save(MapleLandMapListEntity
                    .builder().
                    mapName("아쿠아로드:위험한 바다 협곡2")
                    .region(Region.Aquarium)
                    .monsterImageUrl("https://maplestory.io/api/gms/62/mob/8142100/icon?resize=2")
                    .miniMapImageUrl("https://mapledb.kr/Assets/image/minimaps/230040300.png")
                    .miniMapImageLogoUrl("https://maplestory.io/api/gms/62/map/230040400/icon?resize=2")
                    .subRegion(ElnathRegion.Aquarium.getDisplayName())
                    .build());



        }
    }

