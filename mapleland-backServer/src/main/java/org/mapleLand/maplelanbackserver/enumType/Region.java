package org.mapleLand.maplelanbackserver.enumType;

import lombok.Getter;

@Getter
public enum Region {
    Victoria("빅토리아"),
    Ludibrium("루디브리엄"),
    Elnath("엘나스"),
    Leafre("리프레"),
    Orbis("오르비스"),
    Aquarium("아쿠아리움");
    private final String displayName;
    Region(String displayName) {
        this.displayName = displayName;
    }
}
