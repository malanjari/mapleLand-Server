package org.mapleland.maplelanbackserver.dto.response;

import org.mapleland.maplelanbackserver.enumType.alert.AlertStatus;

public record AlterDto(int mapId, AlertStatus alertStatus) {
}
