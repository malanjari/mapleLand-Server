package org.mapleLand.maplelanbackserver.dto;

import org.mapleLand.maplelanbackserver.table.MapDropItemEntity;

import java.util.List;

public record DropItemDto(String mapName ,
                          String itemName ,
                          String itemImageUrl,
                          double dropRate) {
}
