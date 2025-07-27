package org.mapleland.maplelanbackserver.enumType.leafre;

import lombok.Getter;

@Getter
public enum Leafre {

    Valley_of_the_Goat("미나르숲:산양의 골짜기 1"),
    Forked_Road_in_the_Forest("미나르숲:숲의 갈림길"),
    Red_Wyvern_Nest("히든스트리트:레드 와이번의 둥지"),
    Blue_Wyvern_Nest("히든스트리트:블루 와이번의 둥지"),
    Destroyed_Dragon_Nest("미나르숲:망가진 용의 둥지"),
    Entrance_to_Dragon_Forest("미나르숲:용의 숲 입구"),
    Battlefield_of_Fire_and_Darkness("미나르숲:불과 어둠의 전장"),
    Black_Kentaurus_Area("미나르숲:검은 켄타우로스의 영역"),
    Blue_Kentaurus_Area("미나르숲:푸른 켄타우로스의 영역"),
    Red_Kentaurus_Area("미나르숲:붉은 켄타우로스의 영역"),
    The_Big_Nest_Peak("미나르숲:큰 둥지 봉우리"),
    Battlefield_of_Fire_and_Water("미나르숲:불과 물의 전장"),
    Dangerous_Dragon_Nest("미나르숲:위험한 용의 둥지"),
    Sky_Nest_2("미나르숲:하늘 둥지2"),
    Abandoned_Dragon_Nest("미나르숲:남겨진 용의 둥지"),
    Forest_of_Manon("미나르숲:마뇽의 숲"),
    Forest_of_Griffey("미나르숲:그리프의 숲"),
    Nest_of_the_Dead_Dragon("미나르숲:죽은 용의 둥지");
    private final String displayName;

    Leafre(String displayName) {
        this.displayName = displayName;
    }
}
