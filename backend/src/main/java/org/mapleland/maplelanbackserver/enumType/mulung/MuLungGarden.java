package org.mapleland.maplelanbackserver.enumType.mulung;

import lombok.Getter;

@Getter
public enum MuLungGarden {
    Sky_Forest_Entrance("무릉도원: 하늘 숲 입구"),
    Sky_Forest_Trail("무릉도원: 하늘 숲 오솔길"),
    Deep_Sky_Forest("무릉도원: 하늘 숲 깊은 곳"),
    End_of_Sky_Forest("무릉도원: 하늘 숲이 끝나는 곳"),
    Flower_Serpent_Territory("무릉도원: 꽃뱀의 영토"),
    Wild_Bear_Territory_1("무릉도원: 야생곰의 영토1"),
    Wild_Bear_Territory_2("무릉도원: 야생곰의 영토2"),
    Wild_Bear_Territory_3("무릉도원: 야생곰의 영토3"),
    Wandering_Bear_Territory("무릉도원: 떠돌이곰의 영토"),
    Foggy_Forest("무릉도원: 안개 낀 숲"),
    Hermits_Forest("무릉도원: 선인의 숲"),
    Yokai_Forest("무릉도원: 요괴의 숲"),
    Yokai_Forest_2("히든스트리트: 요괴의 숲2"),
    Heavenly_Orchard_1("무릉도원: 천도 과수원1"),
    Heavenly_Orchard_2("무릉도원: 천도 과수원2"),
    Heavenly_Orchard_3("무릉도원: 천도 과수원3"),
    Red_Nose_Pirate_Den_1("무릉도원: 빨간코 해적단 소굴1"),
    Red_Nose_Pirate_Den_2("무릉도원: 빨간코 해적단 소굴2"),
    Red_Nose_Pirate_Den_3("무릉도원: 빨간코 해적단 소굴3");









    private final String displayName;
    MuLungGarden(String displayName) {
        this.displayName = displayName;
    }
}

