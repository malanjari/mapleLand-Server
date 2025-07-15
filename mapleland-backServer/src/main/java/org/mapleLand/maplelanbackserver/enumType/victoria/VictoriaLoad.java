package org.mapleland.maplelanbackserver.enumType.victoria;

import lombok.Getter;
import org.mapleland.maplelanbackserver.exception.MapNameMismatchException;

import java.util.Arrays;

@Getter
public enum VictoriaLoad {

    GOLEMS_FOREST_1("히든스트리트: 골렘의 숲"),
    Night_Market_Alley_1("야시장 사잇길 1"),
    Mushroom_Hall("일본:버섯의 전당");

    private final String displayName;

    VictoriaLoad(String displayName) {
        this.displayName = displayName;
    }

    public static VictoriaLoad fromDisplayName(String displayName) {

        String normalizedDisplayName = normalize(displayName);

        return Arrays.stream(VictoriaLoad.values()) // ← 이 한 줄만 필요함
                .filter(v-> normalize(v.getDisplayName()).equals(normalizedDisplayName))
                .findFirst()
                .orElseThrow(() -> new MapNameMismatchException("해당 맵을 찾을 수 없습니다."));
    }

    private static String normalize(String displayName) {
        return displayName.replaceAll("\\s+","");

    }
}