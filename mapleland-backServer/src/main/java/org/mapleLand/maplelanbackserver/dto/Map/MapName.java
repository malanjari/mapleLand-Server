package org.mapleLand.maplelanbackserver.dto.Map;

public record MapName(
        Integer mapId,
        String mapName,
        String monsterImageUrl,
        String miniMapImageUrl
) {
}
