package org.mapleland.maplelanbackserver.bot;

import lombok.RequiredArgsConstructor;
import net.dv8tion.jda.api.events.interaction.command.CommandAutoCompleteInteractionEvent;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.Command;
import org.mapleland.maplelanbackserver.exception.notfound.jari.NotFoundUserException;
import org.mapleland.maplelanbackserver.repository.MapInterRestRepository;
import org.mapleland.maplelanbackserver.repository.UserRepository;
import org.mapleland.maplelanbackserver.table.MapInterRest;
import org.mapleland.maplelanbackserver.table.User;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class BotCommandHandler extends ListenerAdapter {

    private final MapInterRestRepository mapInterRestRepository;
    private final UserRepository userRepository;

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {

        Set<String> validCommands = Set.of("리프레", "무릉도원", "아쿠아리움", "루디브리엄",
                "엘나스", "빅토리아","알람해제","마가티아");

        if (!validCommands.contains(event.getName())) return;

        // map 옵션 받아오기
        String mapName = Objects.requireNonNull(event.getOption("map")).getAsString();
        String discordId = event.getUser().getId();

        System.out.println("🔔 알람 등록 시도: discordId=" + discordId + ", map=" + mapName);

        if (event.getName().equals("알람해제")) {
            sendOptOutToSpring(event, discordId, mapName); // 해제 로직 실행
        } else {
            sendOptInToSpring(event, discordId, mapName);  // 기존 알림 등록 로직
        }

    }

    @Override
    public void onCommandAutoCompleteInteraction(CommandAutoCompleteInteractionEvent event) {
        // 예: 명령어 이름이 "알람해제"이고, 자동완성 대상이 map 옵션일 때만 처리
        if (!event.getName().equals("알람해제") || !event.getFocusedOption().getName().equals("map")) return;

        String discordId = event.getUser().getId();


        List<String> mapNames= mapInterRestRepository.findMapNamesByDiscordId(discordId);


        // 최대 25개까지 자동완성 응답 가능
        List<Command.Choice> choices = mapNames.stream()
                .map(name -> new Command.Choice(name, name))
                .limit(25)
                .toList();

        // 자동완성 응답
        event.replyChoices(choices).queue();
    }

    // 알람 설정

    private void sendOptInToSpring(SlashCommandInteractionEvent event, String discordId, String mapName) {
        try {
            HttpClient httpClient = HttpClient.newHttpClient();
            String json = String.format("{\"discordId\":\"%s\", \"mapName\":\"%s\"}", discordId, mapName);

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://bug-known-goblin.ngrok-free.app/api/optin"))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(json))
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                event.reply("✅ '" + mapName + "' 맵에 대한 알림이 등록되었습니다!").setEphemeral(true).queue();
            } else {
                event.reply("❌ 등록 실패: " + response.body()).setEphemeral(true).queue();
            }

        } catch (Exception e) {
            event.reply("🚫 서버 오류: " + e.getMessage()).setEphemeral(true).queue();
        }
    }

    //알람 해제

    private void sendOptOutToSpring(SlashCommandInteractionEvent event, String discordId, String mapName) {
        try {
            HttpClient httpClient = HttpClient.newHttpClient();
            String json = String.format("{\"discordId\":\"%s\", \"mapName\":\"%s\"}", discordId, mapName);

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://bug-known-goblin.ngrok-free.app/api/optout"))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(json))
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                event.reply("✅ '" + mapName + "' 맵에 대한 알림이 해제되었습니다.").setEphemeral(true).queue();
            } else {
                event.reply("❌ 해제 실패: " + response.body()).setEphemeral(true).queue();
            }

        } catch (Exception e) {
            event.reply("🚫 서버 오류: " + e.getMessage()).setEphemeral(true).queue();
        }
    }

}
