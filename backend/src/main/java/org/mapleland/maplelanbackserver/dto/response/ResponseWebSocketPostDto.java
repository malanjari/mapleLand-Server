package org.mapleland.maplelanbackserver.dto.response;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record ResponseWebSocketPostDto(String userName,
                                       String mapName,
                                       LocalDateTime crateTime) {
}
