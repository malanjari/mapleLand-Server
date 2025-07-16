package org.mapleland.maplelanbackserver.dto.user;

import org.mapleland.maplelanbackserver.dto.response.AlterDto;

import java.util.List;

public record LoginStatusResponse(
        boolean loggedIn,
        ResponseApiUserDto user,
        List<AlterDto> alertDtoList
) {}

