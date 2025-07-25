//package org.mapleland.maplelanbackserver.init;
//
//import lombok.RequiredArgsConstructor;
//import org.mapleland.maplelanbackserver.enumType.Region;
//import org.mapleland.maplelanbackserver.enumType.TradeType;
//import org.mapleland.maplelanbackserver.enumType.aquarium.Aquarium;
//import org.mapleland.maplelanbackserver.enumType.elnath.Elnath;
//import org.mapleland.maplelanbackserver.enumType.leafre.Leafre;
//import org.mapleland.maplelanbackserver.enumType.ludibrium.Ludibrium;
//import org.mapleland.maplelanbackserver.repository.UserRepository;
//import org.mapleland.maplelanbackserver.repository.MapleMapRepository;
//import org.mapleland.maplelanbackserver.repository.JariRepository;
//import org.mapleland.maplelanbackserver.resolve.RegionResolver;
//import org.mapleland.maplelanbackserver.table.Jari;
//import org.mapleland.maplelanbackserver.table.User;
//import org.mapleland.maplelanbackserver.table.MapleMap;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.List;
//import java.util.Random;
//import java.util.stream.Collectors;
//import java.util.stream.IntStream;
//import java.util.stream.Stream;
//
//@Configuration
//@RequiredArgsConstructor
//@org.springframework.core.annotation.Order(2) // ✅ 먼저 실행
//public class DummyDataInitializer {
//
//    private final UserRepository userRepository;
//    private final JariRepository mapRegisterRepository;
//    private final MapleMapRepository mapListRepository;
//
//    @Bean
//    public CommandLineRunner initDummyUsersAndMaps() {
//        return args -> {
//            if (userRepository.count() > 3) {
//                System.out.println("⚠️ 더미 데이터가 이미 존재합니다. 생성을 건너뜁니다.");
//                return;
//            }
//
//            Random random = new Random();
//
//            List<User> users = IntStream.rangeClosed(1, 100)
//                    .mapToObj(i -> User.builder()
//                            .userName("User" + i)
//                            .discordId("discord-" + i)
//                            .globalName("GlobalName" + i)
//                            .role("ROLE_USER")
//                            .email("user" + i + "@test.com")
//                            .mapTicket(true)
//                            .pianusTicket(0)
//                            .manonTicket(0)
//                            .reportCount(0)
//                            .isActive(true)
//                            .image("")
//                            .build())
//                    .collect(Collectors.toList());
//
//            userRepository.saveAll(users);
//
//            List<String> mapNames = Stream.concat(
//                    Stream.of(Aquarium.values()).map(Aquarium::getDisplayName),
//                    Stream.concat(
//                            Stream.of(Elnath.values()).map(Elnath::getDisplayName),
//                            Stream.concat(
//                                    Stream.of(Leafre.values()).map(Leafre::getDisplayName),
//                                    Stream.of(Ludibrium.values()).map(Ludibrium::getDisplayName)
//                            )
//                    )
//            ).collect(Collectors.toList());
//
//            List<Jari> registrations = users.stream().map(user -> {
//                String mapName = mapNames.get(random.nextInt(mapNames.size()));
//                Region region = RegionResolver.getRegionEnumByMapName(mapName);
//
//                // 공백 제거해서 조회 (정확 매칭)
//                String normalizedMapName = mapName.replaceAll("\\s+", "");
//                // ✅ 공백 제거 없이, 원본 mapName으로 조회
//                MapleMap mapInfo = mapListRepository.findByMapNameExact(mapName)
//                        .stream().findFirst().orElse(null);
//
//                return Jari.builder()
//                        .user(user)
//                        .mapName(mapName)
//                        .area(region)
//                        .isCompleted(random.nextBoolean())
//                        .comment("자동 생성된 더미 코멘트")
//                        .serverColor(List.of("Red", "Blue", "Green").get(random.nextInt(3)))
//                        .price(1000 + random.nextInt(10000))
//                        .negotiationOption(random.nextBoolean())
//                        .tradeType(random.nextBoolean() ? TradeType.SELL : TradeType.BUY)
//                        .monsterImageUrl(mapInfo != null ? mapInfo.getMonsterImageUrl() : null)
//                        .build();
//            }).collect(Collectors.toList());
//
//            mapRegisterRepository.saveAll(registrations);
//
//            System.out.println("✅ 더미 유저 및 맵 데이터 100개 생성 완료!");
//        };
//    }
//}