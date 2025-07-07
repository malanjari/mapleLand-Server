package org.mapleLand.maplelanbackserver.dto.item;

public record DropItemDto(String mapName ,
                          String itemName ,
                          String itemImageUrl,
                          double dropRate) {
}
