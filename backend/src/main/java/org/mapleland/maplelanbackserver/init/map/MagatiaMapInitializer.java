package org.mapleland.maplelanbackserver.init.map;

import lombok.RequiredArgsConstructor;
import org.mapleland.maplelanbackserver.enumType.Region;
import org.mapleland.maplelanbackserver.enumType.elnath.ElnathRegion;
import org.mapleland.maplelanbackserver.enumType.nihaldesert.NihalDesertRegion;
import org.mapleland.maplelanbackserver.repository.MapleMapRepository;
import org.mapleland.maplelanbackserver.table.MapleMap;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class MagatiaMapInitializer {

    private final MapleMapRepository mapleMapRepository;

    public void initMagatia(){

        mapleMapRepository.save(MapleMap
                .builder().
                mapName("알카드노 연구소:연구소 202호")
                .region(Region.NihalDesert)
                .monsterImageUrl("https://maplestory.io/api/gms/62/mob/9300147/icon?resize=2")
                .miniMapImageUrl("https://maplestory.io/api/gms/70/map/261010102/render")
                .miniMapImageLogoUrl("https://maplestory.io/api/gms/70/map/261010100/icon")
                .subRegion(NihalDesertRegion.Magatia.getDisplay())
                .build());

        mapleMapRepository.save(MapleMap
                .builder().
                mapName("알카드노 연구소 : 연구소 C-3 구역")
                .region(Region.NihalDesert)
                .monsterImageUrl("https://maplestory.io/api/gms/62/mob/9300148/icon?resize=2")
                .miniMapImageUrl("https://maplestory.io/api/gms/70/map/261020500/render")
                .miniMapImageLogoUrl("https://maplestory.io/api/gms/70/map/261010100/icon")
                .subRegion(NihalDesertRegion.Magatia.getDisplay())
                .build());


        mapleMapRepository.save(MapleMap
                .builder().
                mapName("알카드노 연구소: 연구소 C-2 구역")
                .region(Region.NihalDesert)
                .monsterImageUrl("https://maplestory.io/api/gms/62/mob/9300148/icon?resize=2")
                .miniMapImageUrl("https://maplestory.io/api/gms/70/map/261020400/render")
                .miniMapImageLogoUrl("https://maplestory.io/api/gms/70/map/261010100/icon")
                .subRegion(NihalDesertRegion.Magatia.getDisplay())
                .build());


        mapleMapRepository.save(MapleMap
                .builder().
                mapName("알카드노 연구소: 연구소 C-1 구역")
                .region(Region.NihalDesert)
                .monsterImageUrl("https://maplestory.io/api/gms/62/mob/9300149/icon?resize=2")
                .miniMapImageUrl("https://maplestory.io/api/gms/70/map/261020300/render")
                .miniMapImageLogoUrl("https://maplestory.io/api/gms/70/map/261010100/icon")
                .subRegion(NihalDesertRegion.Magatia.getDisplay())
                .build());

        mapleMapRepository.save(MapleMap
                .builder().
                mapName("알카드노 연구소: 연구소 A-1 구역")
                .region(Region.NihalDesert)
                .monsterImageUrl("https://maplestory.io/api/gms/62/mob/4110302/icon?resize=2")
                .miniMapImageUrl("https://maplestory.io/api/gms/70/map/261020100/render")
                .miniMapImageLogoUrl("https://maplestory.io/api/gms/70/map/261010100/icon")
                .subRegion(NihalDesertRegion.Magatia.getDisplay())
                .build());

        mapleMapRepository.save(MapleMap
                .builder().
                mapName("알카드노 연구소 : 연구소 B-1 구역")
                .region(Region.NihalDesert)
                .monsterImageUrl("https://maplestory.io/api/gms/62/mob/4110302/icon?resize=2")
                .miniMapImageUrl("https://maplestory.io/api/gms/70/map/261020200/render")
                .miniMapImageLogoUrl("https://maplestory.io/api/gms/70/map/261010100/icon")
                .subRegion(NihalDesertRegion.Magatia.getDisplay())
                .build());
    }


}
