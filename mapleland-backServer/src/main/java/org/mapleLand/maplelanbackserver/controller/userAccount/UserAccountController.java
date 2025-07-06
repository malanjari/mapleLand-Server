package org.mapleLand.maplelanbackserver.controller.userAccount;

import lombok.RequiredArgsConstructor;
import org.mapleLand.maplelanbackserver.dto.UserDetailResponseDto;
import org.mapleLand.maplelanbackserver.service.MapleLandUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class UserAccountController {

    private final JwtDecoder jwtDecoder;
    private final MapleLandUserService mapleLandUserService;

    @GetMapping("/api/user")
    public ResponseEntity<?> getUserAccount(
            @RequestHeader(name = "Authorization", required = false) String authHeader
    ) {
        // 1) 인증 헤더가 없는 경우 → 로그인 안 한 사용자로 간주
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return ResponseEntity.ok(Map.of("loggedIn", false));
        }

        String token = authHeader.substring(7);

        Jwt jwt;
        try {
            jwt = jwtDecoder.decode(token);
        } catch (Exception ex) {
            // 토큰은 있는데 유효하지 않으면 → 로그인 만료 or 변조된 토큰
            return ResponseEntity.ok(Map.of("loggedIn", false));
        }

        // 로그인된 사용자
        return ResponseEntity.ok(Map.of(
                "loggedIn", true,
                "user", jwt.getClaims()  // 또는 필요한 필드만 추려서 반환
        ));
    // 또는 필요한 필드만 추려서 반환
    }

    @GetMapping("/api/user/{userId}")
    public ResponseEntity<UserDetailResponseDto> getUserDetail(@PathVariable Integer userId) {
        UserDetailResponseDto userDetail = mapleLandUserService.getUserDetailByUserId(userId);
        return ResponseEntity.ok(userDetail);
    }
}
