package org.mapleLand.maplelanbackserver.dto.user;

import org.mapleLand.maplelanbackserver.dto.alert.ResponseAlterDto;

import java.util.List;
import java.util.Map;

public record LoginStatusResponse(
        boolean loggedIn,
        ResponseApiUserDto user,
        List<ResponseAlterDto> alertDtoList
) {}

