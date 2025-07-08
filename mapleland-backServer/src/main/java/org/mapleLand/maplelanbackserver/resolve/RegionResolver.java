package org.mapleLand.maplelanbackserver.resolve;

import lombok.extern.slf4j.Slf4j;
import org.mapleLand.maplelanbackserver.controller.errorController.MapNameMismatchException;
import org.mapleLand.maplelanbackserver.enumType.aquarium.Aquarium;
import org.mapleLand.maplelanbackserver.enumType.elnath.Elnath;
import org.mapleLand.maplelanbackserver.enumType.Region;
import org.mapleLand.maplelanbackserver.enumType.leafre.Leafre;
import org.mapleLand.maplelanbackserver.enumType.ludibrium.Ludibrium;
import org.mapleLand.maplelanbackserver.enumType.victoria.VictoriaLoad;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Slf4j
public class RegionResolver {

    public static Region getRegionEnumByMapName(String inputMapName) {

        String normalized = normalize(inputMapName);
        log.info("지역이름 = {}", inputMapName);
        log.info("자른 후  = {}", normalized);
        // 순서 중요: 더 구체적인 Enum부터 검사
        if (belongsToLeafre(normalized)) {

            return Region.MinarForest;

        } else if (belongsToEllanas(normalized)) {
            log.info("여기 들어감???   = {}", normalized);
            return Region.Elnath;

        } else if (belongsToLudibrium(normalized)) {

            return Region.LudusLake;
        }
//        else if(belongsToOrbis(normalized)) {
//            return Region.Orbis;
//        }
        else if(belongsToAquarium(normalized)) {
            return Region.AquaRoad;
        }
        else if(belongsToVictoria(normalized)) {
            return Region.Victoria;
        }

        throw new MapNameMismatchException("해당 맵을 찾을 수 없습니다.");
    }

    private static boolean belongsToLeafre(String normalized) {


        return Arrays.stream(Leafre.values())
                .anyMatch(m -> normalize(m.getDisplayName()).equals(normalized));
    }

    private static boolean belongsToEllanas(String normalized) {
        return Arrays.stream(Elnath.values())
                .anyMatch(m -> normalize(m.getDisplayName()).equals(normalized));
    }

    private static boolean belongsToLudibrium(String normalized) {
        return Arrays.stream(Ludibrium.values())
                .anyMatch(m -> normalize(m.getDisplayName()).equals(normalized));
    }
//    private static boolean belongsToOrbis(String normalized) {
//        return Arrays.stream(Orbis.values())
//                .anyMatch(m -> normalize(m.getDisplayName()).equals(normalized));
//    }
    private static boolean belongsToAquarium(String normalized) {
        return Arrays.stream(Aquarium.values())
                .anyMatch(m -> normalize(m.getDisplayName()).equals(normalized));
    }
    private static boolean belongsToVictoria(String normalized) {
        return Arrays.stream(VictoriaLoad.values())
                .anyMatch(m -> normalize(m.getDisplayName()).equals(normalized));
    }

    private static String normalize(String str) {
        return str.replaceAll("\\s+", "");
    }

}