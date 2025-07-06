package org.mapleLand.maplelanbackserver.dto;

import java.util.List;

public record UserDetailResponseDto(
        UserInfoDto userInfo,
        List<UserMapRegistrationDto> mapRegistrations
) {
} 