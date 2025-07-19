package org.mapleland.maplelanbackserver.dto.response;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record ResponseAllUserDto(LocalDate createTime, Long count) {
}
