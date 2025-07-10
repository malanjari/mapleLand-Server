package org.mapleLand.maplelanbackserver.controller.userController;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.mapleLand.maplelanbackserver.controller.errorController.NotFoundUserException;
import org.mapleLand.maplelanbackserver.dto.BannedDto;
import org.mapleLand.maplelanbackserver.repository.MapleJariUserRepository;
import org.mapleLand.maplelanbackserver.table.MapleJariUserEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;


@RestController
@RequiredArgsConstructor
public class UserController {

    private final MapleJariUserRepository mapleJariUserRepository;

    @PostMapping("/admin/api/banUser")
    public ResponseEntity<Map<String,String>> banUser(@RequestBody BannedDto bannedDto) {
        MapleJariUserEntity mapleJariUserEntity = mapleJariUserRepository
                .findByDiscordId(bannedDto.getDiscordId())
                .orElseThrow(() -> new NotFoundUserException("사용자를 찾을 수 없습니다."));

        mapleJariUserEntity.setActive(false);
        mapleJariUserEntity.setBanedReason(bannedDto.getBanReason());
        mapleJariUserRepository.save(mapleJariUserEntity);

        Map<String,String> map = Map.of(
                "stauts","200 OK",
                "message","사용자가 정상적으로 차단 되었습니다."
        );
        return ResponseEntity.status(HttpStatus.OK).body(map);
    }
    @PostMapping("/admin/api/unbanUser")
    public ResponseEntity<Map<String,String>> unbanUser(@RequestBody  BannedDto bannedDto) {
        MapleJariUserEntity mapleJariUserEntity = mapleJariUserRepository
                .findByDiscordId(bannedDto.getDiscordId())
                .orElseThrow(() -> new NotFoundUserException("사용자를 찾을 수 없습니다."));

        mapleJariUserEntity.setActive(true);
        mapleJariUserEntity.setBanedReason(bannedDto.getBanReason());
        mapleJariUserRepository.save(mapleJariUserEntity);

        Map<String,String> map = Map.of(
                "stauts","200 OK",
                "message","사용자가 정상적으로 해제 되었습니다."
        );
        return ResponseEntity.status(HttpStatus.OK).body(map);
    }
}
