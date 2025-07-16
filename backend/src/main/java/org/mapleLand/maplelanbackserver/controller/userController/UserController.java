package org.mapleland.maplelanbackserver.controller.userController;


import lombok.RequiredArgsConstructor;
import org.mapleland.maplelanbackserver.exception.NotFoundUserException;
import org.mapleland.maplelanbackserver.dto.BannedDto;
import org.mapleland.maplelanbackserver.repository.userRepository;
import org.mapleland.maplelanbackserver.table.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;


@RestController
@RequiredArgsConstructor
public class UserController {

    private final userRepository userRepository;

    @PostMapping("/admin/api/banUser")
    public ResponseEntity<Map<String,String>> banUser(@RequestBody BannedDto bannedDto) {
        User user = userRepository
                .findByDiscordId(bannedDto.getDiscordId())
                .orElseThrow(() -> new NotFoundUserException("사용자를 찾을 수 없습니다."));

        user.setActive(false);
        user.setBanedReason(bannedDto.getBanReason());
        userRepository.save(user);

        Map<String,String> map = Map.of(
                "stauts","200 OK",
                "message","사용자가 정상적으로 차단 되었습니다."
        );
        return ResponseEntity.status(HttpStatus.OK).body(map);
    }
    @PostMapping("/admin/api/unbanUser")
    public ResponseEntity<Map<String,String>> unbanUser(@RequestBody  BannedDto bannedDto) {
        User user = userRepository
                .findByDiscordId(bannedDto.getDiscordId())
                .orElseThrow(() -> new NotFoundUserException("사용자를 찾을 수 없습니다."));

        user.setActive(true);
        user.setBanedReason(bannedDto.getBanReason());
        userRepository.save(user);

        Map<String,String> map = Map.of(
                "stauts","200 OK",
                "message","사용자가 정상적으로 해제 되었습니다."
        );
        return ResponseEntity.status(HttpStatus.OK).body(map);
    }
}
