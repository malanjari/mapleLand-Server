package org.mapleland.maplelanbackserver.enumType.nihaldesert;

import lombok.Getter;

@Getter
public enum Magatia {
    LAB_202("알카드노 연구소:연구소 202호"),
    LAB_C_3("알카드노 연구소 : 연구소 C-3 구역"),
    LAB_C_2("알카드노 연구소: 연구소 C-2 구역"),
    LAB_C_1("알카드노 연구소: 연구소 C-1 구역"),
    LAB_A_1("알카드노 연구소: 연구소 A-1 구역"),
    LAB_B_1("알카드노 연구소 : 연구소 B-1 구역");
    // -------- 현재 이까지 함 -----------------------


    private String display;

    Magatia(String display) {
        this.display = display;
    }
}
