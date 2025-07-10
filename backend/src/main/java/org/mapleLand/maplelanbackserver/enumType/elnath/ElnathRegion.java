package org.mapleLand.maplelanbackserver.enumType.elnath;

import lombok.Getter;

@Getter
public enum ElnathRegion {
    SKYLOAD("스카이로드"),
    EL_NATH_MOUNTAINS("엘나스산맥"),
    ABANDONED_MINE("폐광"),
    Aquarium("아쿠아리움")
    ;

    private final String displayName;

    ElnathRegion(String displayName) {
        this.displayName = displayName;
    }
}
