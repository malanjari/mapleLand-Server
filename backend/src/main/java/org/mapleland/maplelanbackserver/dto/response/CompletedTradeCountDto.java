package org.mapleland.maplelanbackserver.dto.response;

import java.time.LocalDate;

public record CompletedTradeCountDto(LocalDate completionTime, Long count) {
} 