package org.mapleland.maplelanbackserver.dto.Map;

import org.mapleland.maplelanbackserver.dto.response.DropItemResponse;

import java.util.List;

public record MapInfo(
        Integer mapId,
        String mapName,
        String monsterImageUrl,
        String miniMapImageUrl,
        String miniMapImageLogoUrl,
        List<DropItemResponse> dropItems
) {
}
