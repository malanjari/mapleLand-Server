package org.mapleland.maplelanbackserver.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;

public record JariUpdateRequest(
        @Schema(description = "맵 PK ", example = "mapId : 101 , mapId : 102")
        int mapId,
        @Schema(description = "서버 색상 ", example = "빨채 = [Red ] 노채 = [Yellow] 초채 = [Green]")
        String serverColor ,
        @Schema(description = "자리 가격" , example = "price : 45000000")
        int price ,
        @Schema(description = "흥정 여부" ,  example = "흥정 불가 = false , 흥정 가능 = true")
        boolean negotiationOption,
        @Schema(description = "사용자 코멘트" , example = "10시 30분 종료 타마로스 귓<")
        String comment) {
}
