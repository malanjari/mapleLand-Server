package org.mapleLand.maplelanbackserver.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;

public record PriceStatDto(
        @Schema(description = "맵 아이디", example = "미나르 숲 : 하늘둥지 , 미나르숲 : 남겨진 용의 둥지")
        String mapName ,
        @Schema(description = "거래 금액",example = "price : 45000000")
        int price ,
        @Schema(description = "맵 등록 시간",example = "2025-07-11")
        LocalDateTime dateTime) {
}
