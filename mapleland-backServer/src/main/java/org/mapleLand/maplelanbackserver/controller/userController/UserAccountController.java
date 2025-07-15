package org.mapleLand.maplelanbackserver.controller.userController;

import lombok.RequiredArgsConstructor;
import org.mapleLand.maplelanbackserver.dto.user.LoginStatusResponse;
import org.mapleLand.maplelanbackserver.dto.user.ResponseApiUserDto;
import org.mapleLand.maplelanbackserver.dto.user.UserDetailResponseDto;
import org.mapleLand.maplelanbackserver.dto.user.UserMapRegistrationDto;
import org.mapleLand.maplelanbackserver.service.MapleLandUserService;
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
            @RequestHeader(name = "Authorization", required = false) String authHeader) {

        LoginStatusResponse loginStatusResponse = mapleLandUserService.checkLoginStatus(authHeader);

        return ResponseEntity.ok(loginStatusResponse);
    }

    @GetMapping("/api/user/{userId}")
    public ResponseEntity<UserDetailResponseDto> getUserDetail(@PathVariable Integer userId) {
        UserDetailResponseDto userDetail = mapleLandUserService.getUserDetailServiceMethod(userId);

        return ResponseEntity.ok(userDetail);
    }
}
