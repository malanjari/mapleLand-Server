package org.mapleLand.maplelanbackserver.enumType.ludibrium;

import lombok.Getter;

@Getter
public enum LudibriumRegion {

    LUDIBRIUM_CASTLE("루디브리엄성"),
    LOWER_CLOCKTOWER("시계탑최하층");


    private final String displayName;
    LudibriumRegion(String displayName) {

        this.displayName = displayName;
    }
}
