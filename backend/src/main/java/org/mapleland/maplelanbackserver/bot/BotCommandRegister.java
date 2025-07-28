package org.mapleland.maplelanbackserver.bot;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import net.dv8tion.jda.api.events.session.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import net.dv8tion.jda.api.interactions.commands.Command;
import org.mapleland.maplelanbackserver.enumType.aquarium.Aquarium;
import org.mapleland.maplelanbackserver.enumType.elnath.Elnath;
import org.mapleland.maplelanbackserver.enumType.leafre.Leafre;
import org.mapleland.maplelanbackserver.enumType.ludibrium.Ludibrium;
import org.mapleland.maplelanbackserver.enumType.mulung.MuLungGardenRegion;
import org.mapleland.maplelanbackserver.enumType.victoria.VictoriaLoad;
import org.mapleland.maplelanbackserver.repository.MapInterRestRepository;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@RequiredArgsConstructor
public class BotCommandRegister extends ListenerAdapter {

    private final MapInterRestRepository mapInterRestRepository;

  //디스코드 /커맨더 만드는 곳

    @Override
    public void onReady(ReadyEvent event) {
        System.out.println("🟢 onReady() 호출됨 - 명령어 등록 진입");

        String guildId = "1393488151074308228";

        var guild = event.getJDA().getGuildById(guildId);



//        //건드리지말것
//        guild.retrieveCommands().queue(commands -> {
//            for (var command : commands) {
//                if (command.getName().equals("alarm") || command.getName().equals("알람해제") || command.getName().equals("알람")) {
//                    guild.deleteCommandById(command.getId()).queue(
//                            v -> System.out.println("🗑 기존 /alarm 명령어 삭제됨"),
//                            e -> System.out.println("⚠️ 명령어 삭제 실패: " + e.getMessage())
//                    );
//                }
//            }
//        });

        System.out.println("✅ 명령어 등록 시작");

        // 옵션 생성 + choices 추가
        OptionData leafreOption = new OptionData(OptionType.STRING, "map", "맵 이름을 선택하세요", true);

        for(Leafre leafre : Leafre.values()) {
            leafreOption.addChoice(leafre.getDisplayName(), leafre.getDisplayName());
        }
        //명령어 새로 등록 or 업데이트
        guild.upsertCommand("리프레", "리프레 지역 알람 등록")
                .addOptions(leafreOption)
                .queue(cmd -> System.out.println("✅ /리프레 등록 완료"));

        OptionData ElnathOption = new OptionData(OptionType.STRING,"map","맵 이름을 선택하세요.",true);

        for(Elnath elnath : Elnath.values()) {
            ElnathOption.addChoice(elnath.getDisplayName(), elnath.getDisplayName());
        }

        //명령어 새로 등록 or 업데이트
        guild.upsertCommand("엘나스", "엘나스 지역 알람 등록")
                .addOptions(ElnathOption)
                .queue(cmd -> System.out.println("✅ /엘나스 등록 완료"));


        OptionData aquariumOption = new OptionData(OptionType.STRING,"map","맵 이름을 선택하세요.",true);

        for(Aquarium aquarium : Aquarium.values()) {
            aquariumOption.addChoice(aquarium.getDisplayName(), aquarium.getDisplayName());
        }

        //명령어 새로 등록 or 업데이트
        guild.upsertCommand("아쿠아리움", "아쿠아리움 지역 알람 등록")
                .addOptions(aquariumOption)
                .queue(cmd -> System.out.println("✅ /아쿠아리움 등록 완료"));

        OptionData ludibriumOption = new OptionData(OptionType.STRING,"map","맵 이름을 선택하세요.",true);

        for(Ludibrium ludibrium : Ludibrium.values()) {
            ludibriumOption.addChoice(ludibrium.getDisplayName(), ludibrium.getDisplayName());
        }

        //명령어 새로 등록 or 업데이트
        guild.upsertCommand("루디브리엄", "루디브리엄 지역 알람 등록")
                .addOptions(aquariumOption)
                .queue(cmd -> System.out.println("✅ /루디브리엄 등록 완료"));

        OptionData muLungGardenOption = new OptionData(OptionType.STRING,"map","맵 이름을 선택하세요.",true);

        for(MuLungGardenRegion muLungGardenRegion : MuLungGardenRegion.values()) {
            muLungGardenOption.addChoice(muLungGardenRegion.getDisplayName(), muLungGardenRegion.getDisplayName());
        }

        //명령어 새로 등록 or 업데이트
        guild.upsertCommand("무릉도원", "무릉도원 지역 알람 등록")
                .addOptions(aquariumOption)
                .queue(cmd -> System.out.println("✅ /무릉도원 등록 완료"));

        OptionData victoriaOption = new OptionData(OptionType.STRING,"map","맵 이름을 선택하세요",true);

        for(VictoriaLoad victoriaLoad :  VictoriaLoad.values()) {
            victoriaOption.addChoice(victoriaLoad.getDisplayName(), victoriaLoad.getDisplayName());
        }

        //명령어 새로 등록 or 업데이트
        guild.upsertCommand("빅토리아", "빅토리아 지역 알람 등록")
                .addOptions(aquariumOption)
                .queue(cmd -> System.out.println("✅ /빅토리아 등록 완료"));

        // ------------- 알람 해제 ---------------------------------------------

       OptionData mapOption = new OptionData(OptionType.STRING, "map", "해제할 맵을 선택하세요", true)
               .setAutoComplete(true);

        guild.upsertCommand("알람해제", "알림 등록을 해제합니다")
                .addOptions(mapOption)
                .queue();

    }
}
