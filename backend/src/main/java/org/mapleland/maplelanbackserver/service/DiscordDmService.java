package org.mapleland.maplelanbackserver.service;

import lombok.RequiredArgsConstructor;
import net.dv8tion.jda.api.JDA;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DiscordDmService {

    private final JDA jda;

    public void sendToUser(String discordUserId,String message){
        jda.retrieveUserById(discordUserId).queue(user -> {

            user.openPrivateChannel().queue(channel -> {

                channel.sendMessage(message).queue();
            }, err-> {
                System.out.println("DM 채널 열기 실패 예상 (DM 차단 및 허용 설정 꺼짐");
            });
        }, err -> {
            System.out.println("유저 조회 실패 -> 봇과 같은 서버 없음");
        });
    }
}
