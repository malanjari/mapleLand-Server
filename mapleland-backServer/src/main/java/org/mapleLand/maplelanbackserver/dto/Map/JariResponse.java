package org.mapleland.maplelanbackserver.dto.Map;

import io.swagger.v3.oas.annotations.media.Schema;
import org.mapleland.maplelanbackserver.enumType.Region;
import org.mapleland.maplelanbackserver.enumType.TradeType;

import java.time.LocalDateTime;
@Schema(description = "맵 정보 Dto")
public record JariResponse(
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
) {}
