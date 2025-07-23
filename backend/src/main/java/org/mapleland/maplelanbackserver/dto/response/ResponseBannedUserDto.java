package org.mapleland.maplelanbackserver.dto.response;

import java.time.LocalDateTime;

public record ResponseBannedUserDto(
        Integer userId,
        String userName,
        String discordId,
        String globalName,
        String role,
        String email,
        String banedReason,
        String image,
        LocalDateTime createTime,
        int reportedCount,
        LocalDateTime bannedHours) {
}
