package org.mapleLand.maplelanbackserver.enumType.aquarium;

import lombok.Getter;

@Getter
public enum Aquarium {
    SHIP_GRAVEYARD("아쿠아로드:난파선의 무덤"),
    DEEP_SEA_GORGE_1("아쿠아로드:깊은 바다 협곡1"),
    DEEP_SEA_GORGE_2("아쿠아로드:깊은 바다 협곡2"),
    DANGEROUS_SEA_GORGE_1("아쿠아로드:위험한 바다 협곡1"),
    DANGEROUS_SEA_GORGE_2("아쿠아로드:위험한 바다 협곡2"),
    PIANUS_CAVE("아쿠아로드:피아누스의 동굴");

    private final String displayName;

    Aquarium(String displayName) {
        this.displayName = displayName;
    }
}
