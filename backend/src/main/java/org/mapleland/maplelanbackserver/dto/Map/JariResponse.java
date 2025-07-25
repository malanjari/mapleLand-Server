package org.mapleland.maplelanbackserver.dto.Map;

import io.swagger.v3.oas.annotations.media.Schema;
import org.mapleland.maplelanbackserver.enumType.Region;
import org.mapleland.maplelanbackserver.enumType.TradeType;
import org.mapleland.maplelanbackserver.table.Jari;

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
) {

    public static JariResponse from(Jari jari) {
        return new JariResponse(
                jari.getUserMapId(),
                jari.getMapName(),
                jari.getServerColor(),
                jari.getPrice(),
                jari.getTradeType(),
                jari.getNegotiationOption(),
                jari.getArea(),
                jari.getCreateTime(),
                jari.getComment(),
                jari.getMonsterImageUrl(),
                jari.getUser().getGlobalName(),
                jari.getUser().getImage(),
                jari.getUser().getUserId(),
                jari.getUser().getDiscordId(),
                jari.getIsCompleted()
        );
    }
}
