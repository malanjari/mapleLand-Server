package org.mapleland.maplelanbackserver.dto.jari;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.mapleland.maplelanbackserver.enumType.TradeType;
import org.mapleland.maplelanbackserver.table.Jari;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class JariCompletedEvent {
    private int jariId;
    private String mapName;
    private String globalName;
    private TradeType tradeType;
    private int price;
    private boolean isCompleted;
    private LocalDateTime completedTime;

    public static JariCompletedEvent from(Jari jari, String globalName) {
        return new JariCompletedEvent(
                jari.getUserMapId(),
                jari.getMapName(),
                globalName,
                jari.getTradeType(),
                jari.getPrice(),
                jari.getIsCompleted(),
                jari.getUpdateTime()
        );
    }
}
