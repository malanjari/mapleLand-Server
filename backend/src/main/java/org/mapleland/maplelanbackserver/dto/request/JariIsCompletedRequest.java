package org.mapleland.maplelanbackserver.dto.request;

import jakarta.validation.constraints.NotNull;

public record JariIsCompletedRequest(
        @NotNull(message = "맵아이디는 필수입니다.")
        int mapId,
        @NotNull(message = "완료 조건은 필수 입니다.")
        boolean isCompleted) {
}
