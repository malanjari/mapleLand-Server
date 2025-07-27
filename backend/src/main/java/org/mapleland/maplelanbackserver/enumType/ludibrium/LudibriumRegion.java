package org.mapleland.maplelanbackserver.enumType.ludibrium;

import lombok.Getter;

@Getter
public enum LudibriumRegion {

    LUDIBRIUM_CASTLE("루디브리엄성"),
    LOWER_CLOCKTOWER("시계탑최하층"),
    Ludus_Lake("루더스 호수");


    private final String displayName;
    LudibriumRegion(String displayName) {

        this.displayName = displayName;
    }
}
