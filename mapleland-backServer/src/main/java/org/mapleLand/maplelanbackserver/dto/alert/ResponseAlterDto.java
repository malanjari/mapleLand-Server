package org.mapleLand.maplelanbackserver.dto.alert;

import org.mapleLand.maplelanbackserver.enumType.alert.AlertStatus;

public record ResponseAlterDto(int mapId, AlertStatus alertStatus) {
}
