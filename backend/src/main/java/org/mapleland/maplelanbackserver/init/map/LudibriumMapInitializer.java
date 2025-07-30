package org.mapleland.maplelanbackserver.init.map;

import lombok.RequiredArgsConstructor;
import org.mapleland.maplelanbackserver.enumType.Region;
import org.mapleland.maplelanbackserver.enumType.ludibrium.LudibriumRegion;
import org.mapleland.maplelanbackserver.repository.MapleMapRepository;
import org.mapleland.maplelanbackserver.table.MapleMap;
import org.springframework.stereotype.Component;
@Component
@RequiredArgsConstructor
public class LudibriumMapInitializer {

    private final MapleMapRepository mapleMapRepository;


         public void initLudibrium(){

        // ----------------- 루디브리엄 --------------------------------------------

            mapleMapRepository.save(MapleMap
                    .builder().
                    mapName("루디브리엄성:시간의길<1>")
                    .region(Region.LudusLake)
                    .monsterImageUrl("https://maplestory.io/api/gms/62/mob/4230114/icon?resize=2")
                    .miniMapImageUrl("https://mapledb.kr/Assets/image/minimaps/220040000.png")
                    .subRegion(LudibriumRegion.LUDIBRIUM_CASTLE.getDisplayName())
                    .miniMapImageLogoUrl("https://maplestory.io/api/gms/62/map/220040000/icon?resize=2")
                    .build());

            mapleMapRepository.save(MapleMap
                    .builder().
                    mapName("루디브리엄성:시간의길<2>")
                    .region(Region.LudusLake)
                    .monsterImageUrl("https://maplestory.io/api/gms/62/mob/3230306/icon?resize=2")
                    .miniMapImageUrl("https://mapledb.kr/Assets/image/minimaps/220040000.png")
                    .subRegion(LudibriumRegion.LUDIBRIUM_CASTLE.getDisplayName())
                    .miniMapImageLogoUrl("https://maplestory.io/api/gms/62/map/220040000/icon?resize=2")
                    .build());

            mapleMapRepository.save(MapleMap
                    .builder().
                    mapName("루디브리엄성:시간의길<3>")
                    .region(Region.LudusLake)
                    .monsterImageUrl("https://maplestory.io/api/gms/62/mob/3230306/icon?resize=2")
                    .miniMapImageUrl("https://mapledb.kr/Assets/image/minimaps/220040300.png")
                    .subRegion(LudibriumRegion.LUDIBRIUM_CASTLE.getDisplayName())
                    .miniMapImageLogoUrl("https://maplestory.io/api/gms/62/map/220040000/icon?resize=2")
                    .build());

            mapleMapRepository.save(MapleMap
                    .builder().
                    mapName("루디브리엄성:시간의길<4>")
                    .region(Region.LudusLake)
                    .monsterImageUrl("https://maplestory.io/api/gms/62/mob/4230115/icon?resize=2")
                    .miniMapImageUrl("https://mapledb.kr/Assets/image/minimaps/220040400.png")
                    .subRegion(LudibriumRegion.LUDIBRIUM_CASTLE.getDisplayName())
                    .miniMapImageLogoUrl("https://maplestory.io/api/gms/62/map/220040000/icon?resize=2")
                    .build());

            // ------------- 시계탑 최하층 ---------------------------

            mapleMapRepository.save(MapleMap
                    .builder().
                    mapName("시계탑최하층:뒤틀린 시간의 길<1>")
                    .region(Region.LudusLake)
                    .monsterImageUrl("https://maplestory.io/api/gms/62/mob/6130200/icon?resize=2")
                    .miniMapImageUrl("https://mapledb.kr/Assets/image/minimaps/220060000.png")
                    .subRegion(LudibriumRegion.LOWER_CLOCKTOWER.getDisplayName())
                    .miniMapImageLogoUrl("https://maplestory.io/api/gms/62/map/220040000/icon?resize=2")
                    .build());


            mapleMapRepository.save(MapleMap
                    .builder().
                    mapName("시계탑최하층:뒤틀린 시간의 길<2>")
                    .region(Region.LudusLake)
                    .monsterImageUrl("https://maplestory.io/api/gms/62/mob/6400100/icon?resize=2")
                    .subRegion(LudibriumRegion.LOWER_CLOCKTOWER.getDisplayName())
                    .miniMapImageUrl("https://mapledb.kr/Assets/image/minimaps/220060100.png")
                    .miniMapImageLogoUrl("https://maplestory.io/api/gms/62/map/220040000/icon?resize=2")
                    .build());

            mapleMapRepository.save(MapleMap
                    .builder().
                    mapName("시계탑최하층:뒤틀린 시간의 길<3>")
                    .region(Region.LudusLake)
                    .monsterImageUrl("https://maplestory.io/api/gms/62/mob/7140000/icon?resize=2")
                    .subRegion(LudibriumRegion.LOWER_CLOCKTOWER.getDisplayName())
                    .miniMapImageUrl("https://mapledb.kr/Assets/image/minimaps/220060200.png")
                    .miniMapImageLogoUrl("https://maplestory.io/api/gms/62/map/220040000/icon?resize=2")
                    .build());

            mapleMapRepository.save(MapleMap
                    .builder().
                    mapName("시계탑최하층:뒤틀린 시간의 길<4>")
                    .region(Region.LudusLake)
                    .monsterImageUrl("https://maplestory.io/api/gms/62/mob/8141000/icon?resize=2")
                    .subRegion(LudibriumRegion.LOWER_CLOCKTOWER.getDisplayName())
                    .miniMapImageUrl("https://mapledb.kr/Assets/image/minimaps/220060300.png")
                    .miniMapImageLogoUrl("https://maplestory.io/api/gms/62/map/220040000/icon?resize=2")
                    .build());

            mapleMapRepository.save(MapleMap
                    .builder().
                    mapName("시계탑최하층:금지된 시간")
                    .region(Region.LudusLake)
                    .monsterImageUrl("https://maplestory.io/api/gms/62/mob/8143000/icon?resize=2")
                    .subRegion(LudibriumRegion.LOWER_CLOCKTOWER.getDisplayName())
                    .miniMapImageUrl("https://mapledb.kr/Assets/image/minimaps/220070301.png")
                    .miniMapImageLogoUrl("https://maplestory.io/api/gms/62/map/220040000/icon?resize=2")
                    .build());


            mapleMapRepository.save(MapleMap
                    .builder().
                    mapName("시계탑최하층:사라진 시간")
                    .region(Region.LudusLake)
                    .monsterImageUrl("https://maplestory.io/api/gms/62/mob/7130300/icon?resize=2")
                    .subRegion(LudibriumRegion.LOWER_CLOCKTOWER.getDisplayName())
                    .miniMapImageUrl("https://mapledb.kr/Assets/image/minimaps/220070201.png")
                    .miniMapImageLogoUrl("https://maplestory.io/api/gms/62/map/220040000/icon?resize=2")
                    .build());

            mapleMapRepository.save(MapleMap
                    .builder().
                    mapName("시계탑최하층:삐뚤어진 시간")
                    .region(Region.LudusLake)
                    .monsterImageUrl("https://maplestory.io/api/gms/62/mob/7160000/icon?resize=2")
                    .subRegion(LudibriumRegion.LOWER_CLOCKTOWER.getDisplayName())
                    .miniMapImageUrl("https://mapledb.kr/Assets/image/minimaps/220060201.png")
                    .miniMapImageLogoUrl("https://maplestory.io/api/gms/62/map/220040000/icon?resize=2")
                    .build());

            mapleMapRepository.save(MapleMap
                    .builder().
                    mapName("시계탑최하층:꼬여버린 시간")
                    .region(Region.LudusLake)
                    .monsterImageUrl("https://maplestory.io/api/gms/62/mob/8141100/icon?resize=2")
                    .subRegion(LudibriumRegion.LOWER_CLOCKTOWER.getDisplayName())
                    .miniMapImageUrl("https://mapledb.kr/Assets/image/minimaps/220060301.png")
                    .miniMapImageLogoUrl("https://maplestory.io/api/gms/62/map/220040000/icon?resize=2")
                    .build());


             mapleMapRepository.save(MapleMap
                     .builder().
                     mapName("루디브리엄성: 잃어버린시간<1>")
                     .region(Region.LudusLake)
                     .monsterImageUrl("https://maplestory.io/api/gms/62/mob/4230114/icon?resize=2")
                     .subRegion(LudibriumRegion.LUDIBRIUM_CASTLE.getDisplayName())
                     .miniMapImageUrl("https://mapledb.kr/Assets/image/minimaps/220040000.png")
                     .miniMapImageLogoUrl("https://maplestory.io/api/gms/62/map/220040000/icon?resize=2")
                     .build());

             mapleMapRepository.save(MapleMap
                     .builder().
                     mapName("루디브리엄성: 잃어버린시간<2>")
                     .region(Region.LudusLake)
                     .monsterImageUrl("https://maplestory.io/api/gms/62/mob/4230115/icon?resize=2")
                     .subRegion(LudibriumRegion.LUDIBRIUM_CASTLE.getDisplayName())
                     .miniMapImageUrl("https://mapledb.kr/Assets/image/minimaps/220050200.png")
                     .miniMapImageLogoUrl("https://maplestory.io/api/gms/62/map/220040000/icon?resize=2")
                     .build());

             mapleMapRepository.save(MapleMap
                     .builder().
                     mapName("루더스호수: 까막산 입구")
                     .region(Region.LudusLake)
                     .monsterImageUrl("https://maplestory.io/api/gms/62/mob/4230300/icon?resize=2")
                     .subRegion(LudibriumRegion.Ludus_Lake.getDisplayName())
                     .miniMapImageUrl("https://mapledb.kr/Assets/image/minimaps/222010000.png")
                     .miniMapImageLogoUrl("https://maplestory.io/api/gms/62/map/222010001/icon?resize=2")
                     .build());

             mapleMapRepository.save(MapleMap
                     .builder().
                     mapName("루더스호수: 까막산 기슭")
                     .region(Region.LudusLake)
                     .monsterImageUrl("https://maplestory.io/api/gms/62/mob/5100003/icon?resize=2")
                     .subRegion(LudibriumRegion.Ludus_Lake.getDisplayName())
                     .miniMapImageUrl("https://mapledb.kr/Assets/image/minimaps/222010001.png")
                     .miniMapImageLogoUrl("https://maplestory.io/api/gms/62/map/222010001/icon?resize=2")
                     .build());

             mapleMapRepository.save(MapleMap
                     .builder().
                     mapName("루더스호수: 까막산 골짜기")
                     .region(Region.LudusLake)
                     .monsterImageUrl("https://maplestory.io/api/gms/62/mob/5100004/icon?resize=2")
                     .subRegion(LudibriumRegion.Ludus_Lake.getDisplayName())
                     .miniMapImageUrl("https://mapledb.kr/Assets/image/minimaps/222010201.png")
                     .miniMapImageLogoUrl("https://maplestory.io/api/gms/62/map/222010001/icon?resize=2")
                     .build());

             mapleMapRepository.save(MapleMap
                     .builder().
                     mapName("시계탑최하층: 시간의 근원")
                     .region(Region.LudusLake)
                     .monsterImageUrl("https://maplestory.io/api/gms/62/mob/8500001/icon?resize=2")
                     .subRegion(LudibriumRegion.LOWER_CLOCKTOWER.getDisplayName())
                     .miniMapImageUrl("https://maplestory.io/api/gms/70/map/220080001/render")
                     .miniMapImageLogoUrl("https://maplestory.io/api/gms/62/map/220040000/icon?resize=2")
                     .build());


         }
    }

