package org.mapleland.maplelanbackserver.dto.user;

import java.time.LocalDateTime;

public record UserInfoDto(
        int userId,
        String discordId,
        String image,
        LocalDateTime createTime,
        String globalName,
        Boolean mapTicket,
        String userName,
        String email,
        boolean isActive) { }