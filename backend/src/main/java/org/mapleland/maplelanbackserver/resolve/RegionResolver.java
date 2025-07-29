package org.mapleland.maplelanbackserver.resolve;
import lombok.extern.slf4j.Slf4j;
import org.mapleland.maplelanbackserver.enumType.mulung.MuLungGarden;
import org.mapleland.maplelanbackserver.enumType.mulung.MuLungGardenRegion;
import org.mapleland.maplelanbackserver.exception.badrequest.MapNameMismatchException;
import org.mapleland.maplelanbackserver.enumType.aquarium.Aquarium;
import org.mapleland.maplelanbackserver.enumType.elnath.Elnath;
import org.mapleland.maplelanbackserver.enumType.Region;
import org.mapleland.maplelanbackserver.enumType.leafre.Leafre;
import org.mapleland.maplelanbackserver.enumType.ludibrium.Ludibrium;
import org.mapleland.maplelanbackserver.enumType.victoria.VictoriaLoad;
import java.util.Arrays;



@Slf4j
public class RegionResolver {

    public static Region getRegionEnumByMapName(String inputMapName) {

        String normalized = normalize(inputMapName);
        // 순서 중요: 더 구체적인 Enum부터 검사
        if (belongsToLeafre(normalized)) {

            return Region.MinarForest;

        } else if (belongsToEllanas(normalized)) {

            return Region.Elnath;

        } else if (belongsToLudibrium(normalized)) {

            return Region.LudusLake;
        }

        else if(belongsToAquarium(normalized)) {
            return Region.AquaRoad;
        }
        else if(belongsToVictoria(normalized)) {
            return Region.Victoria;
        }
        else if(belongsToMuLung(normalized)) {
            return Region.MuLung;
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

    private static boolean belongsToMuLung(String normalized) {
        return Arrays.stream(MuLungGarden.values())
                .anyMatch(m -> normalize(m.getDisplayName()).equals(normalized));
    }

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