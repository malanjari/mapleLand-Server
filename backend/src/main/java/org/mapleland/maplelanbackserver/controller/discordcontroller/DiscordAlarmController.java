package org.mapleland.maplelanbackserver.controller.discordcontroller;

import lombok.RequiredArgsConstructor;
import org.mapleland.maplelanbackserver.dto.request.AlarmRegisterRequest;
import org.mapleland.maplelanbackserver.utilmethod.UtilMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DiscordAlarmController {

    private final UtilMethod utilMethod;


    @PostMapping("/api/optin")
    public ResponseEntity<?> registerAlarm(@RequestBody AlarmRegisterRequest request) {
        utilMethod.DiscordAlertInterest(request);
        return ResponseEntity.ok().build();
    }
    @PostMapping("/api/optout")
    public ResponseEntity<?> registerOptout(@RequestBody AlarmRegisterRequest request) {
        utilMethod.DiscordAlertInterestOut(request);

        return ResponseEntity.ok().build();
    }
}
