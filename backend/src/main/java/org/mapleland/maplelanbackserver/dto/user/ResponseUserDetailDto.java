package org.mapleland.maplelanbackserver.dto.user;

import java.util.List;

public record ResponseUserDetailDto(
        UserInfoDto userInfo,
        List<UserMapRegistrationDto> mapRegistrations
)
{}