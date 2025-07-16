package org.mapleland.maplelanbackserver.dto.Map;

import io.swagger.v3.oas.annotations.media.Schema;
@Schema(description = "인기 맵 정보 DTO")
public record MapPopularityResponse(
        @Schema(description = "맵이름" , example = "미나르숲:하늘둥지2 , 미나르숲: 남겨진 용의 둥지")
        String mapName,
        @Schema(description = "등록된 개수",example = "미나르숲:하늘둥지2 , 매물수 5개.. ")
        int registerCount,
        @Schema(description = "지역이름" ,example = "Leafre , Aquarium , Elnath , LudusLake , Victoria")
        String area,
        @Schema(description = "몬스터 이미지 Url")
        String monsterImageUrl) { }
