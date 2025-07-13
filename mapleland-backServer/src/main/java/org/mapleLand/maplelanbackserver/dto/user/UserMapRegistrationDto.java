package org.mapleLand.maplelanbackserver.dto.user;

import org.mapleLand.maplelanbackserver.enumType.Region;
import org.mapleLand.maplelanbackserver.enumType.TradeType;

import java.time.LocalDateTime;

public record UserMapRegistrationDto(
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
        Boolean isCompleted,
        String userImage,
        int userId,
        String discordId,
        String globalName
) {
}