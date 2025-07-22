package org.mapleland.maplelanbackserver.dto.Map;

import jakarta.validation.constraints.NotNull;
import org.mapleland.maplelanbackserver.enumType.alert.AlertStatus;

public record AlertRequest(
        @NotNull(message = "유저아이디는 필수 입니다.")
        Integer userId,
        @NotNull(message = "맵 아이디는 필수 입니다.")
        Integer mapId,
        @NotNull(message = "알람 상태는 필수 입니다.")
        AlertStatus alertStatus) {
}
