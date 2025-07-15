package org.mapleLand.maplelanbackserver.dto.Map;

import org.mapleLand.maplelanbackserver.enumType.alert.AlertStatus;

public record InterestAlertRequestDto(int userId, int mapId, AlertStatus alertStatus) {
}
