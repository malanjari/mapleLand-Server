package org.mapleland.maplelanbackserver.dto.Map;

public record MapName(
        Integer mapId,
        String mapName,
        String monsterImageUrl,
        String miniMapImageUrl,
        String miniMapImageLogoUrl
) {
}
