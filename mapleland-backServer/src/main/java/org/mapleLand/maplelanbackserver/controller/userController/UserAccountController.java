package org.mapleland.maplelanbackserver.controller.userController;

import lombok.RequiredArgsConstructor;
import org.mapleland.maplelanbackserver.dto.user.LoginStatusResponse;
import org.mapleland.maplelanbackserver.dto.user.ResponseUserDetailDto;
import org.mapleland.maplelanbackserver.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserAccountController {

    private final JwtDecoder jwtDecoder;
    private final UserService userService;

    @GetMapping("/api/user")
    public ResponseEntity<?> getUserAccount(
            @RequestHeader(name = "Authorization", required = false) String authHeader) {

        LoginStatusResponse loginStatusResponse = userService.checkLoginStatus(authHeader);

        return ResponseEntity.ok(loginStatusResponse);
    }

    @GetMapping("/api/user/{userId}")
    public ResponseEntity<ResponseUserDetailDto> getUserDetail(@PathVariable Integer userId) {
        ResponseUserDetailDto userDetail = userService.getUserDetailServiceMethod(userId);

        return ResponseEntity.ok(userDetail);
    }
}
