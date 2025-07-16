package org.mapleland.maplelanbackserver.enumType.victoria;

import lombok.Getter;

@Getter
public enum VictoriaLoadRegion {

    SLEEPYWOOD("슬리피우드"),
    HENESYS("헤네시스"),
    KERNING_CITY("커닝시티"),
    ELLINIA("엘리니아"),
    PERION("페리온");


    private final String displayName;
    VictoriaLoadRegion(String displayName) {
        this.displayName = displayName;
    }
}
