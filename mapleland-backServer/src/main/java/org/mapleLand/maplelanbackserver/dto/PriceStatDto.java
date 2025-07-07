package org.mapleLand.maplelanbackserver.dto;

import java.time.LocalDateTime;

public record PriceStatDto(String mapName , int price , LocalDateTime dateTime) {
}
