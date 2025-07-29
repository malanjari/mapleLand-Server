package org.mapleland.maplelanbackserver.enumType.nihaldesert;

import lombok.Getter;

@Getter
public enum NihalDesertRegion {
    Magatia("마가티아"),
    Ariant("아리안트");

    private String display;

    NihalDesertRegion(String display) {
        this.display = display;
    }
}
