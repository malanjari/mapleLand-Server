package org.mapleLand.maplelanbackserver.init.map;

import lombok.RequiredArgsConstructor;
import org.mapleLand.maplelanbackserver.enumType.Region;
import org.mapleLand.maplelanbackserver.enumType.ludibrium.LudibriumRegion;
import org.mapleLand.maplelanbackserver.repository.MapleLandMapListRepository;
import org.mapleLand.maplelanbackserver.table.MapleLandMapListEntity;
import org.springframework.stereotype.Component;
@Component
@RequiredArgsConstructor
public class LudibriumMapInitializer {

    private final MapleLandMapListRepository mapleLandMapListRepository;


         public void initLudibrium(){

        // ----------------- 루디브리엄 --------------------------------------------

            mapleLandMapListRepository.save(MapleLandMapListEntity
                    .builder().
                    mapName("루디브리엄성:시간의길<1>")
                    .region(Region.Ludibrium)
                    .monsterImageUrl("https://maplestory.io/api/gms/62/mob/4230114/icon?resize=2")
                    .miniMapImageUrl("https://mapledb.kr/Assets/image/minimaps/220040000.png")
                    .subRegion(LudibriumRegion.LUDIBRIUM_CASTLE.getDisplayName())
                    .miniMapImageLogoUrl("https://maplestory.io/api/gms/62/map/220040000/icon?resize=2")
                    .build());

            mapleLandMapListRepository.save(MapleLandMapListEntity
                    .builder().
                    mapName("루디브리엄성:시간의길<2>")
                    .region(Region.Ludibrium)
                    .monsterImageUrl("https://maplestory.io/api/gms/62/mob/3230306/icon?resize=2")
                    .miniMapImageUrl("https://mapledb.kr/Assets/image/minimaps/220040000.png")
                    .subRegion(LudibriumRegion.LUDIBRIUM_CASTLE.getDisplayName())
                    .miniMapImageLogoUrl("https://maplestory.io/api/gms/62/map/220040000/icon?resize=2")
                    .build());

            mapleLandMapListRepository.save(MapleLandMapListEntity
                    .builder().
                    mapName("루디브리엄성:시간의길<3>")
                    .region(Region.Ludibrium)
                    .monsterImageUrl("https://maplestory.io/api/gms/62/mob/3230306/icon?resize=2")
                    .miniMapImageUrl("https://mapledb.kr/Assets/image/minimaps/220040300.png")
                    .subRegion(LudibriumRegion.LUDIBRIUM_CASTLE.getDisplayName())
                    .miniMapImageLogoUrl("https://maplestory.io/api/gms/62/map/220040000/icon?resize=2")
                    .build());

            mapleLandMapListRepository.save(MapleLandMapListEntity
                    .builder().
                    mapName("루디브리엄성:시간의길<4>")
                    .region(Region.Ludibrium)
                    .monsterImageUrl("https://maplestory.io/api/gms/62/mob/4230115/icon?resize=2")
                    .miniMapImageUrl("https://mapledb.kr/Assets/image/minimaps/220040400.png")
                    .subRegion(LudibriumRegion.LUDIBRIUM_CASTLE.getDisplayName())
                    .miniMapImageLogoUrl("https://maplestory.io/api/gms/62/map/220040000/icon?resize=2")
                    .build());

            // ------------- 시계탑 최하층 ---------------------------

            mapleLandMapListRepository.save(MapleLandMapListEntity
                    .builder().
                    mapName("시계탑최하층:뒤틀린 시간의 길<1>")
                    .region(Region.Ludibrium)
                    .monsterImageUrl("https://maplestory.io/api/gms/62/mob/6130200/icon?resize=2")
                    .miniMapImageUrl("https://mapledb.kr/Assets/image/minimaps/220060000.png")
                    .subRegion(LudibriumRegion.LOWER_CLOCKTOWER.getDisplayName())
                    .miniMapImageLogoUrl("https://maplestory.io/api/gms/62/map/220040000/icon?resize=2")
                    .build());


            mapleLandMapListRepository.save(MapleLandMapListEntity
                    .builder().
                    mapName("시계탑최하층:뒤틀린 시간의 길<2>")
                    .region(Region.Ludibrium)
                    .monsterImageUrl("https://maplestory.io/api/gms/62/mob/6400100/icon?resize=2")
                    .subRegion(LudibriumRegion.LOWER_CLOCKTOWER.getDisplayName())
                    .miniMapImageUrl("https://mapledb.kr/Assets/image/minimaps/220060100.png")
                    .miniMapImageLogoUrl("https://maplestory.io/api/gms/62/map/220040000/icon?resize=2")
                    .build());

            mapleLandMapListRepository.save(MapleLandMapListEntity
                    .builder().
                    mapName("시계탑최하층:뒤틀린 시간의 길<3>")
                    .region(Region.Ludibrium)
                    .monsterImageUrl("https://maplestory.io/api/gms/62/mob/7140000/icon?resize=2")
                    .subRegion(LudibriumRegion.LOWER_CLOCKTOWER.getDisplayName())
                    .miniMapImageUrl("https://mapledb.kr/Assets/image/minimaps/220060200.png")
                    .miniMapImageLogoUrl("https://maplestory.io/api/gms/62/map/220040000/icon?resize=2")
                    .build());

            mapleLandMapListRepository.save(MapleLandMapListEntity
                    .builder().
                    mapName("시계탑최하층:뒤틀린 시간의 길<4>")
                    .region(Region.Ludibrium)
                    .monsterImageUrl("https://maplestory.io/api/gms/62/mob/8141000/icon?resize=2")
                    .subRegion(LudibriumRegion.LOWER_CLOCKTOWER.getDisplayName())
                    .miniMapImageUrl("https://mapledb.kr/Assets/image/minimaps/220060300.png")
                    .miniMapImageLogoUrl("https://maplestory.io/api/gms/62/map/220040000/icon?resize=2")
                    .build());

            mapleLandMapListRepository.save(MapleLandMapListEntity
                    .builder().
                    mapName("시계탑최하층:금지된 시간")
                    .region(Region.Ludibrium)
                    .monsterImageUrl("https://maplestory.io/api/gms/62/mob/8143000/icon?resize=2")
                    .subRegion(LudibriumRegion.LOWER_CLOCKTOWER.getDisplayName())
                    .miniMapImageUrl("https://mapledb.kr/Assets/image/minimaps/220070301.png")
                    .miniMapImageLogoUrl("https://maplestory.io/api/gms/62/map/220040000/icon?resize=2")
                    .build());


            mapleLandMapListRepository.save(MapleLandMapListEntity
                    .builder().
                    mapName("시계탑최하층:사라진 시간")
                    .region(Region.Ludibrium)
                    .monsterImageUrl("https://maplestory.io/api/gms/62/mob/7130300/icon?resize=2")
                    .subRegion(LudibriumRegion.LOWER_CLOCKTOWER.getDisplayName())
                    .miniMapImageUrl("https://mapledb.kr/Assets/image/minimaps/220070201.png")
                    .miniMapImageLogoUrl("https://maplestory.io/api/gms/62/map/220040000/icon?resize=2")
                    .build());

            mapleLandMapListRepository.save(MapleLandMapListEntity
                    .builder().
                    mapName("시계탑최하층:삐뚤어진 시간")
                    .region(Region.Ludibrium)
                    .monsterImageUrl("https://maplestory.io/api/gms/62/mob/7160000/icon?resize=2")
                    .subRegion(LudibriumRegion.LOWER_CLOCKTOWER.getDisplayName())
                    .miniMapImageUrl("https://mapledb.kr/Assets/image/minimaps/220060201.png")
                    .miniMapImageLogoUrl("https://maplestory.io/api/gms/62/map/220040000/icon?resize=2")
                    .build());

            mapleLandMapListRepository.save(MapleLandMapListEntity
                    .builder().
                    mapName("시계탑최하층:꼬여버린 시간")
                    .region(Region.Ludibrium)
                    .monsterImageUrl("https://maplestory.io/api/gms/62/mob/8141100/icon?resize=2")
                    .subRegion(LudibriumRegion.LOWER_CLOCKTOWER.getDisplayName())
                    .miniMapImageUrl("https://mapledb.kr/Assets/image/minimaps/220060301.png")
                    .miniMapImageLogoUrl("https://maplestory.io/api/gms/62/map/220040000/icon?resize=2")
                    .build());

        }
    }

