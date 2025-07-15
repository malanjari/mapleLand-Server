package org.mapleland.maplelanbackserver.dto.Map;

import org.mapleland.maplelanbackserver.enumType.alert.AlertStatus;

public record AlertRequest(int userId, int mapId, AlertStatus alertStatus) {
}
