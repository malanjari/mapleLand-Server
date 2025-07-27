package org.mapleland.maplelanbackserver.enumType.mulung;

import lombok.Getter;

@Getter
public enum MuLungGardenRegion {
    MuLungGarden("무릉도원"),
    BaekchoVillage("백초마을");

    private final String displayName;

    MuLungGardenRegion(String displayName) {
        this.displayName = displayName;
    }
}
