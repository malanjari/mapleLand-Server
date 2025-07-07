package org.mapleLand.maplelanbackserver.dto.Map;

import io.swagger.v3.oas.annotations.media.Schema;
import org.mapleLand.maplelanbackserver.enumType.Region;
import org.mapleLand.maplelanbackserver.enumType.TradeType;

import java.time.LocalDateTime;
@Schema(description = "맵 정보 Dto")
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
        String discordId,
        boolean isCompleted
) {
}
