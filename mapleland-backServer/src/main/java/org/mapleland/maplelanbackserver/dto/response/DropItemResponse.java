package org.mapleland.maplelanbackserver.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

public record DropItemResponse(
        @Schema(description = "사용자가 검색한 맵 이름", example = "미나르숲:위험한 용의 둥지 , 미나르숲:남겨진 용의 둥지")
        String mapName ,
        @Schema(description = "해당 맵에 드랍되는 아이템 이름"
                ,example = "피아누스의 동굴 = [샤프 아이즈 20 , 페이크 20 ,피아누스의 미니어쳐 등]")
        String itemName ,
        @Schema(description = "몬스터 이미지 Url" ,example = "피아누스의 동굴 -> 피아누스 이미지")
        String itemImageUrl,
        @Schema(description = "드랍 확률",example = "레드 크리븐 -> 0.0003%")
        double dropRate) {
}
