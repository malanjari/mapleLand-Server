package org.mapleland.maplelanbackserver.bot;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DiscordBotStarter {
    @Value("${discord.bot-token}")
    private String discordToken;

    private final BotCommandRegister botCommandRegister;
    private final BotCommandHandler botCommandHandler;


    //봇 등록 메서드
    @PostConstruct
    public void startBot() throws Exception {
        System.out.println("✅ DiscordBotStarter 시작");

        JDA jda = JDABuilder.createDefault(discordToken)
                .enableIntents(GatewayIntent.getIntents(GatewayIntent.ALL_INTENTS))
                .addEventListeners(botCommandHandler, botCommandRegister) // ✅ 리스너 먼저 등록
                .build();

        jda.awaitReady(); // ✅ ReadyEvent 발생

        System.out.println("✅ JDA 봇 생성됨");

        System.out.println("🔍 봇이 속한 서버 목록:");
        jda.getGuilds().forEach(guild -> {
            System.out.println(" - " + guild.getName() + " | ID: " + guild.getId());
        });
    }
}

