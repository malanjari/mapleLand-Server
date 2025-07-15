package org.mapleLand.maplelanbackserver.dto.user;

import org.mapleLand.maplelanbackserver.dto.alert.ResponseAlterDto;

import java.util.List;
import java.util.Map;

public record ResponseApiUserDto(
        int userId,
        String username,
        String globalName,
        String role,
        String avatar,
        String id,
        String iat,
        String exp
) {
    public ResponseApiUserDto(Map<String, Object> claims) {
        this(
                ((Number) claims.get("userId")).intValue(),
                (String) claims.get("username"),
                (String) claims.get("globalName"),
                (String) claims.get("role"),
                (String) claims.get("avatar"),
                (String) claims.get("id"),
                String.valueOf(claims.get("iat")),
                String.valueOf(claims.get("exp"))
        );
    }
}
