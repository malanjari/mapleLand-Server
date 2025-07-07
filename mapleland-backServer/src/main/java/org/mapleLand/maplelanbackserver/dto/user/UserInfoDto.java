package org.mapleLand.maplelanbackserver.dto.user;

import java.time.LocalDateTime;

public record UserInfoDto(
        String discordId,
        String image,
        LocalDateTime createTime,
        String globalName,
        Boolean mapTicket,
        String userName,
        String email
) {
} 