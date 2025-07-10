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
    Freezing_Field("엘나스산맥:차디찬 벌판");



    private final String displayName;

    Elnath(String displayName) {
        this.displayName = displayName;
    }

}





