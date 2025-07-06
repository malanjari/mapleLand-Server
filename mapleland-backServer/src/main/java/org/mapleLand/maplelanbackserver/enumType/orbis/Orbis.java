package org.mapleLand.maplelanbackserver.enumType.orbis;

import lombok.Getter;

@Getter
public enum Orbis {
    CLOUD_PARK_6("스카이로드:구름 공원6"),
    CLOUD_PARK_5("스카이로드:구름 공원5"),
    CLOUD_PARK_4("스카이로드:구름 공원4"),
    CLOUD_PARK_3("스카이로드:구름 공원3"),
    CLOUD_PARK_2("스카이로드:구름 공원2"),
    CLOUD_PARK_1("스카이로드:구름 공원1");


    private final String displayName;

    Orbis(String displayName) {
        this.displayName = displayName;
    }
}
