package org.mapleland.maplelanbackserver.dto.user;

import java.time.LocalDateTime;

public record UserInfoDto(
        int userId,
        String discordId,
        String image,
        LocalDateTime createTime,
        String globalName,
        String userName,
        String email,
        boolean isActive) { }