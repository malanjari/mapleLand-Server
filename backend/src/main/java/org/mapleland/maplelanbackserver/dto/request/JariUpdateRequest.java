package org.mapleland.maplelanbackserver.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record JariUpdateRequest(
        @Schema(description = "맵 PK ", example = "mapId : 101 , mapId : 102")
        @NotNull(message = "멥 id는 필수 입니다.")
        int mapId,
        @Schema(description = "서버 색상 ", example = "빨채 = [Red ] 노채 = [Yellow] 초채 = [Green]")
        @NotNull(message = "서버 색깔은 필수 입니다.")
        String serverColor ,
        @Schema(description = "자리 가격" , example = "price : 45000000")
        @NotNull(message = "가격은 필수 입니다.")
        @Positive(message = "가격은 양수여야만 합니다.")
        int price ,
        @Schema(description = "흥정 여부" ,  example = "흥정 불가 = false , 흥정 가능 = true")
        boolean negotiationOption,
        @Schema(description = "사용자 코멘트" , example = "10시 30분 종료 타마로스 귓<")
        @Size(min = 5, max = 60, message = "코멘트는 최소 5자 이상, 최대 60자까지 입력할 수 있습니다.")
        String comment) {
}
