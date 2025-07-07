package org.mapleLand.maplelanbackserver.enumType.elnath;

import lombok.Getter;
import org.mapleLand.maplelanbackserver.controller.errorController.MapNameMismatchException;

import java.util.Arrays;

@Getter
public enum Elnath {
    Forest_of_Dead_Trees_1("폐광:죽은 나무의 숲 1"),
    Forest_of_Dead_Trees_2("폐광:죽은 나무의 숲 2"),
    Forest_of_Dead_Trees_3("폐광:죽은 나무의 숲 3"),
    Forest_of_Dead_Trees_4("폐광:죽은 나무의 숲 4"),
    Freezing_Field("엘나스산맥:차디찬 벌판"),
    CLOUD_PARK_6("스카이로드:구름 공원6"),
    CLOUD_PARK_5("스카이로드:구름 공원5"),
    CLOUD_PARK_4("스카이로드:구름 공원4"),
    CLOUD_PARK_3("스카이로드:구름 공원3"),
    CLOUD_PARK_2("스카이로드:구름 공원2"),
    CLOUD_PARK_1("스카이로드:구름 공원1");



    private final String displayName;

    Elnath(String displayName) {
        this.displayName = displayName;
    }

}





