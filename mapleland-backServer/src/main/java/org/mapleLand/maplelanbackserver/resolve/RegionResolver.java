package org.mapleLand.maplelanbackserver.resolve;

import org.mapleLand.maplelanbackserver.controller.errorController.MapNameMismatchException;
import org.mapleLand.maplelanbackserver.enumType.aquarium.Aquarium;
import org.mapleLand.maplelanbackserver.enumType.elnath.Elnath;
import org.mapleLand.maplelanbackserver.enumType.Region;
import org.mapleLand.maplelanbackserver.enumType.leafre.Leafre;
import org.mapleLand.maplelanbackserver.enumType.ludibrium.Ludibrium;
import org.mapleLand.maplelanbackserver.enumType.orbis.Orbis;
import software.amazon.awssdk.services.s3.endpoints.internal.Value;

import java.util.Arrays;
import java.util.List;

public class RegionResolver {

    public static Region getRegionEnumByMapName(String inputMapName) {

        String normalized = normalize(inputMapName);

        // 순서 중요: 더 구체적인 Enum부터 검사
        if (belongsToLeafre(normalized)) {

            return Region.Leafre;

        } else if (belongsToEllanas(normalized)) {

            return Region.Elnath;

        } else if (belongsToLudibrium(normalized)) {

            return Region.Ludibrium;
        }
        else if(belongsToOrbis(normalized)) {
            return Region.Orbis;
        }
        else if(belongsToAquarium(normalized)) {
            return Region.Aquarium;
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
    private static boolean belongsToOrbis(String normalized) {
        return Arrays.stream(Orbis.values())
                .anyMatch(m -> normalize(m.getDisplayName()).equals(normalized));
    }
    private static boolean belongsToAquarium(String normalized) {
        return Arrays.stream(Aquarium.values())
                .anyMatch(m -> normalize(m.getDisplayName()).equals(normalized));
    }

    private static String normalize(String str) {
        return str.replaceAll("\\s+", "");
    }

}