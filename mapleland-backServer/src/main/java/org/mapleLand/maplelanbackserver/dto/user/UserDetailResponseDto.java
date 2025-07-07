package org.mapleLand.maplelanbackserver.dto.user;

import java.util.List;

public record UserDetailResponseDto(
        UserInfoDto userInfo,
        List<UserMapRegistrationDto> mapRegistrations
)
{}