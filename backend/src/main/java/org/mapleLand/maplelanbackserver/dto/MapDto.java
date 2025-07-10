package org.mapleLand.maplelanbackserver.dto;

import org.mapleLand.maplelanbackserver.enumType.Region;
import org.mapleLand.maplelanbackserver.enumType.TradeType;

import java.time.LocalDateTime;
import java.util.List;

public record MapDto(
        Integer userMapId,
        String mapName,
        String serverColor,
        int price,
        TradeType tradeType,
        Boolean negotiationOption,
        Region area,
        LocalDateTime createTime,
        String comment,
        String monsterImageUrl,
        String globalName,
        String userImage,
        int userId,
        String uniqueId,
        String socialId,
        String miniMapImageLogo
) {
}
