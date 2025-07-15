package org.mapleLand.maplelanbackserver.dto.user;

import org.mapleLand.maplelanbackserver.dto.alert.ResponseAlterDto;
import org.mapleLand.maplelanbackserver.table.MapInterestEntity;

import java.time.LocalDateTime;
import java.util.List;

public record UserInfoDto(
        String discordId,
        String image,
        LocalDateTime createTime,
        String globalName,
        Boolean mapTicket,
        String userName,
        String email) { }