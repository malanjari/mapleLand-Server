package org.mapleland.maplelanbackserver.init.monster;

import lombok.RequiredArgsConstructor;
import org.mapleland.maplelanbackserver.repository.MonsterDropItemRepository;
import org.mapleland.maplelanbackserver.table.MonsterDropItem;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class LeafreMonsterDataInitializer {

    private final MonsterDropItemRepository monsterDropItemRepository;

    public void initAquariumMonsterData() {

        monsterDropItemRepository.saveAll(List.of(
                MonsterDropItem.builder()
                        .mapName("미나르숲:산양의 골짜기 1")
                        .itemName("화이트 네쉐르")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1462015/icon?resize=2")
                        .dropRate(0.0003)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("미나르숲:산양의 골짜기 1")
                        .itemName("피나카")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1432030/icon?resize=2")
                        .dropRate(0.0003)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("미나르숲:산양의 골짜기 1")
                        .itemName("일비 표창")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2070006/icon?resize=2")
                        .dropRate(0.008)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("미나르숲:산양의 골짜기 1")
                        .itemName("코브라 스티어")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1472031/icon?resize=2")
                        .dropRate(0.008)
                        .build(),
                MonsterDropItem.builder()
                        .mapName("미나르숲:산양의 골짜기 1")
                        .itemName("피닉스 완드")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1372016/icon?resize=2")
                        .dropRate(0.008)
                        .build(),
                MonsterDropItem.builder()
                        .mapName("미나르숲:산양의 골짜기 1")
                        .itemName("다이몬의 완드")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1372010/icon?resize=2")
                        .dropRate(0.0001)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("미나르숲:산양의 골짜기 1")
                        .itemName("아대 공격력 주문서 10%")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2044702/icon?resize=2")
                        .dropRate(0.002)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("미나르숲:산양의 골짜기 1")
                        .itemName("호진공창")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1432010/icon?resize=2")
                        .dropRate(0.007)
                        .build()
        ));

        monsterDropItemRepository.saveAll(List.of(
                MonsterDropItem.builder()
                        .mapName("미나르숲:숲의 갈림길")
                        .itemName("화이트 네쉐르")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1462015/icon?resize=2")
                        .dropRate(0.0003)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("미나르숲:숲의 갈림길")
                        .itemName("피나카")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1432030/icon?resize=2")
                        .dropRate(0.0003)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("미나르숲:숲의 갈림길")
                        .itemName("일비 표창")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2070006/icon?resize=2")
                        .dropRate(0.008)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("미나르숲:숲의 갈림길")
                        .itemName("코브라 스티어")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1472031/icon?resize=2")
                        .dropRate(0.008)
                        .build(),
                MonsterDropItem.builder()
                        .mapName("미나르숲:숲의 갈림길")
                        .itemName("피닉스 완드")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1372016/icon?resize=2")
                        .dropRate(0.008)
                        .build(),
                MonsterDropItem.builder()
                        .mapName("미나르숲:숲의 갈림길")
                        .itemName("다이몬의 완드")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1372010/icon?resize=2")
                        .dropRate(0.0001)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("미나르숲:숲의 갈림길")
                        .itemName("아대 공격력 주문서 10%")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2044702/icon?resize=2")
                        .dropRate(0.002)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("미나르숲:숲의 갈림길")
                        .itemName("호진공창")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1432010/icon?resize=2")
                        .dropRate(0.007)
                        .build()
        ));


        monsterDropItemRepository.saveAll(List.of(
                MonsterDropItem.builder()
                        .mapName("히든스트리트:레드 와이번의 둥지")
                        .itemName("드래곤의 비늘")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/4000245/icon?resize=2")
                        .dropRate(0.0003)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("히든스트리트:레드 와이번의 둥지")
                        .itemName("드래곤의 영혼")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/4000244/icon?resize=2")
                        .dropRate(0.0003)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("히든스트리트:레드 와이번의 둥지")
                        .itemName("한손검 공격력 주문서 10%")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2043002/icon?resize=2")
                        .dropRate(0.006)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("히든스트리트:레드 와이번의 둥지")
                        .itemName("전신 갑옷 행운 주문서 60%")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2040516/icon?resize=2")
                        .dropRate(0.001)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("히든스트리트:레드 와이번의 둥지")
                        .itemName("블루 아데스")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1050089/icon?resize=2")
                        .dropRate(0.007)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("히든스트리트:레드 와이번의 둥지")
                        .itemName("그린 바르슈즈")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1072223/icon?resize=2")
                        .dropRate(0.01)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("히든스트리트:레드 와이번의 둥지")
                        .itemName("메투스")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1452017/icon?resize=2")
                        .dropRate(0.009)
                        .build(),
                MonsterDropItem.builder()
                        .mapName("히든스트리트:레드 와이번의 둥지")
                        .itemName("레드 미스트 슈트")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1041118/icon?resize=2")
                        .dropRate(0.007)
                        .build()
        ));


        monsterDropItemRepository.saveAll(List.of(
                MonsterDropItem.builder()
                        .mapName("히든스트리트:블루 와이번의 둥지")
                        .itemName("드래곤의 비늘")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/4000245/icon?resize=2")
                        .dropRate(0.0003)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("히든스트리트:블루 와이번의 둥지")
                        .itemName("드래곤의 영혼")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/4000244/icon?resize=2")
                        .dropRate(0.0003)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("히든스트리트:블루 와이번의 둥지")
                        .itemName("다이몬의 완드")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1372010/icon?resize=2")
                        .dropRate(0.0002)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("히든스트리트:블루 와이번의 둥지")
                        .itemName("두손검 공격력 주문서 60%")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2044001/icon?resize=2")
                        .dropRate(0.006)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("히든스트리트:블루 와이번의 둥지")
                        .itemName("그린 아르미스")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1051105/icon?resize=2")
                        .dropRate(0.006)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("히든스트리트:블루 와이번의 둥지")
                        .itemName("레드 아르나슈즈")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1072227/icon?resize=2")
                        .dropRate(0.01)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("히든스트리트:블루 와이번의 둥지")
                        .itemName("적견랑포")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1050094/icon?resize=2")
                        .dropRate(0.01)
                        .build(),
                MonsterDropItem.builder()
                        .mapName("히든스트리트:블루 와이번의 둥지")
                        .itemName("레오마이트")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1422013/icon?resize=2")
                        .dropRate(0.006)
                        .build()
        ));


        monsterDropItemRepository.saveAll(List.of(
                MonsterDropItem.builder()
                        .mapName("미나르숲:망가진 용의 둥지")
                        .itemName("라 투핸더")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1402016/icon?resize=2")
                        .dropRate(0.007)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("미나르숲:망가진 용의 둥지")
                        .itemName("드래곤의 영혼")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/4000244/icon?resize=2")
                        .dropRate(0.0003)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("미나르숲:망가진 용의 둥지")
                        .itemName("드래곤의 비늘")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/4000245/icon?resize=2")
                        .dropRate(0.0003)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("미나르숲:망가진 용의 둥지")
                        .itemName("[마스터리 북]패럴 라이즈 20")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2290030/icon?resize=2")
                        .dropRate(0.04)
                        .build(),
                MonsterDropItem.builder()
                        .mapName("미나르숲:망가진 용의 둥지")
                        .itemName("[마스터리 북]드래곤 펄스 20")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2290030/icon?resize=2")
                        .dropRate(0.004)
                        .build(),
                MonsterDropItem.builder()
                        .mapName("미나르숲:망가진 용의 둥지")
                        .itemName("[마스터리 북]크로스 보우 엑스퍼트 20")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2290030/icon?resize=2")
                        .dropRate(0.001)
                        .build(),
                MonsterDropItem.builder()
                        .mapName("미나르숲:망가진 용의 둥지")
                        .itemName("[마스터리 북]암살 20")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2290030/icon?resize=2")
                        .dropRate(0.001)
                        .build(),
                MonsterDropItem.builder()
                        .mapName("미나르숲:망가진 용의 둥지")
                        .itemName("레드 카테")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1051092/icon?resize=2")
                        .dropRate(0.01)
                        .build()
        ));

        monsterDropItemRepository.saveAll(List.of(
                MonsterDropItem.builder()
                        .mapName("미나르숲:용의 숲 입구")
                        .itemName("캐스터스")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1472033/icon?resize=2")
                        .dropRate(0.007)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("미나르숲:용의 숲 입구")
                        .itemName("드래곤의 영혼")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/4000244/icon?resize=2")
                        .dropRate(0.0003)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("미나르숲:용의 숲 입구")
                        .itemName("마기코라스")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1372009/icon?resize=2")
                        .dropRate(0.007)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("미나르숲:용의 숲 입구")
                        .itemName("망토 행운 주문서 60%")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2044001/icon?resize=2")
                        .dropRate(0.006)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("미나르숲:용의 숲 입구")
                        .itemName("프라우테")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1302023/icon?resize=2")
                        .dropRate(0.007)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("미나르숲:용의 숲 입구")
                        .itemName("바키트")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1332027/icon?resize=2")
                        .dropRate(0.007)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("미나르숲:용의 숲 입구")
                        .itemName("석궁 공격력 주문서 60%")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2044601/icon?resize=2")
                        .dropRate(0.006)
                        .build(),
                MonsterDropItem.builder()
                        .mapName("미나르숲:용의 숲 입구")
                        .itemName("드래곤의 비늘")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/4000245/icon?resize=2")
                        .dropRate(0.0003)
                        .build()
        ));

        monsterDropItemRepository.saveAll(List.of(
                MonsterDropItem.builder()
                        .mapName("미나르숲:불과 어둠의 전장") // << --- 여기 수정해야함
                        .itemName("레드 크리븐")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1472053/icon?resize=2")
                        .dropRate(0.0003)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("미나르숲:불과 어둠의 전장")
                        .itemName("참화도")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1402035/icon?resize=2")
                        .dropRate(0.0003)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("미나르숲:불과 어둠의 전장")
                        .itemName("토마호크")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1312030/icon?resize=2")
                        .dropRate(0.0003)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("미나르숲:불과 어둠의 전장")
                        .itemName("케이그")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1382008/icon?resize=2")
                        .dropRate(0.007)
                        .build(),
                MonsterDropItem.builder()
                        .mapName("미나르숲:불과 어둠의 전장")
                        .itemName("블루마린")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1382035/icon?resize=2")
                        .dropRate(0.0003)
                        .build(),
                MonsterDropItem.builder()
                        .mapName("미나르숲:불과 어둠의 전장")
                        .itemName("화이트 니스록")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1452019/icon?resize=2")
                        .dropRate(0.0003)
                        .build(),
                MonsterDropItem.builder()
                        .mapName("미나르숲:불과 어둠의 전장")
                        .itemName("장갑 공격력 주문서 10%")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2040805/icon?resize=2")
                        .dropRate(0.004)
                        .build(),
                MonsterDropItem.builder()
                        .mapName("미나르숲:불과 어둠의 전장")
                        .itemName("청운검")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1402004/icon?resize=2")
                        .dropRate(0.008)
                        .build()

        ));

        monsterDropItemRepository.saveAll(List.of(
                MonsterDropItem.builder()
                        .mapName("미나르숲:검은 켄타우로스의 영역")
                        .itemName("레드 크리븐")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1472053/icon?resize=2")
                        .dropRate(0.0003)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("미나르숲:검은 켄타우로스의 영역")
                        .itemName("참화도")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1402035/icon?resize=2")
                        .dropRate(0.0003)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("미나르숲:검은 켄타우로스의 영역")
                        .itemName("토마호크")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1312030/icon?resize=2")
                        .dropRate(0.0003)
                        .build(),
                MonsterDropItem.builder()
                        .mapName("미나르숲:검은 켄타우로스의 영역")
                        .itemName("케이그")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1382008/icon?resize=2")
                        .dropRate(0.007)
                        .build(),
                MonsterDropItem.builder()
                        .mapName("미나르숲:검은 켄타우로스의 영역")
                        .itemName("골드 아룬드")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1452014/icon?resize=2")
                        .dropRate(0.008)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("미나르숲:검은 켄타우로스의 영역")
                        .itemName("딸기 귀고리")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1032023/icon?resize=2")
                        .dropRate(0.009)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("미나르숲:검은 켄타우로스의 영역")
                        .itemName("레드 피라테")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1040109/icon?resize=2")
                        .dropRate(0.009)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("미나르숲:검은 켄타우로스의 영역")
                        .itemName("다크 엠페러")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1082117/icon?resize=2")
                        .dropRate(0.008)
                        .build()
        ));


        monsterDropItemRepository.saveAll(List.of(
                MonsterDropItem.builder()
                        .mapName("미나르숲:푸른 켄타우로스의 영역")
                        .itemName("타바르")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1412021/icon?resize=2")
                        .dropRate(0.0003)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("미나르숲:푸른 켄타우로스의 영역")
                        .itemName("배틀해머")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1322045/icon?resize=2")
                        .dropRate(0.0003)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("미나르숲:푸른 켄타우로스의 영역")
                        .itemName("골드 트윈 나이프")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1332051/icon?resize=2")
                        .dropRate(0.0003)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("미나르숲:푸른 켄타우로스의 영역")
                        .itemName("페어프로즌")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1432011/icon?resize=2")
                        .dropRate(0.004)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("미나르숲:푸른 켄타우로스의 영역")
                        .itemName("월아산")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1442019/icon?resize=2")
                        .dropRate(0.007)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("미나르숲:푸른 켄타우로스의 영역")
                        .itemName("파이어 아룬드")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1452013/icon?resize=2")
                        .dropRate(0.007)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("미나르숲:푸른 켄타우로스의 영역")
                        .itemName("블러드 엠페러")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1082116/icon?resize=2")
                        .dropRate(0.009)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("미나르숲:푸른 켄타우로스의 영역")
                        .itemName("헬리오스")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1412009/icon?resize=2")
                        .dropRate(0.008)
                        .build()
        ));


        monsterDropItemRepository.saveAll(List.of(
                MonsterDropItem.builder()
                        .mapName("미나르숲:붉은 켄타우로스의 영역")
                        .itemName("블루마린")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1382035/icon?resize=2")
                        .dropRate(0.0003)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("미나르숲:붉은 켄타우로스의 영역")
                        .itemName("화이트 니스록")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1452019/icon?resize=2")
                        .dropRate(0.0003)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("미나르숲:붉은 켄타우로스의 영역")
                        .itemName("골드 스미스 해머")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1422027/icon?resize=2")
                        .dropRate(0.0003)
                        .build(),
                MonsterDropItem.builder()
                        .mapName("미나르숲:붉은 켄타우로스의 영역")
                        .itemName("장갑 공격력 주문서 10%")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2040805/icon?resize=2")
                        .dropRate(0.004)
                        .build(),
                MonsterDropItem.builder()
                        .mapName("미나르숲:붉은 켄타우로스의 영역")
                        .itemName("용천권")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1332023/icon?resize=2")
                        .dropRate(0.008)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("미나르숲:붉은 켄타우로스의 영역")
                        .itemName("장팔사모")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1432004/icon?resize=2")
                        .dropRate(0.009)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("미나르숲:붉은 켄타우로스의 영역")
                        .itemName("청운검")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1402004/icon?resize=2")
                        .dropRate(0.008)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("미나르숲:붉은 켄타우로스의 영역")
                        .itemName("청운검")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1402004/icon?resize=2")
                        .dropRate(0.008)
                        .build()
        ));

        monsterDropItemRepository.saveAll(List.of(
                MonsterDropItem.builder()
                        .mapName("미나르숲:큰 둥지 봉우리")
                        .itemName("[마스터리 북]샤프 아이즈 30")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2290053/icon?resize=2")
                        .dropRate(0.0002)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("미나르숲:큰 둥지 봉우리")
                        .itemName("[마스터리 북]부매랑 스탭 20")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2290090/icon?resize=2")
                        .dropRate(0.0002)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("미나르숲:큰 둥지 봉우리")
                        .itemName("[마스터리 북]어드밴스드 콤보 30")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2290009/icon?resize=2")
                        .dropRate(0.0002)
                        .build(),
                MonsterDropItem.builder()
                        .mapName("미나르숲:큰 둥지 봉우리")
                        .itemName("[마스터리 북]햄스트링 20")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2290009/icon?resize=2")
                        .dropRate(0.0002)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("미나르숲:큰 둥지 봉우리")
                        .itemName("드래곤의 비늘")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/4000245/icon?resize=2")
                        .dropRate(0.0004)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("미나르숲:큰 둥지 봉우리")
                        .itemName("드래곤의 영혼")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/4000244/icon?resize=2")
                        .dropRate(0.0004)
                        .build(),
                MonsterDropItem.builder()
                        .mapName("미나르숲:큰 둥지 봉우리")
                        .itemName("[마스터리 북]홀리 실드 20")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2290034/icon?resize=2")
                        .dropRate(0.001)
                        .build(),
                MonsterDropItem.builder()
                        .mapName("미나르숲:큰 둥지 봉우리")
                        .itemName("[마스터리 북]아킬레스 20")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2290034/icon?resize=2")
                        .dropRate(0.001)
                        .build()
        ));
        // ----------------------------- 여기임 ------------------------------
        monsterDropItemRepository.saveAll(List.of(
                MonsterDropItem.builder()
                        .mapName("미나르숲:불과 물의 전장")
                        .itemName("블루마린")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1382035/icon?resize=2")
                        .dropRate(0.0003)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("미나르숲:불과 물의 전장")
                        .itemName("화이트 니스록")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1452019/icon?resize=2")
                        .dropRate(0.0003)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("미나르숲:불과 물의 전장")
                        .itemName("골든 스미스해머")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1422027/icon?resize=2")
                        .dropRate(0.0003)
                        .build(),
                MonsterDropItem.builder()
                        .mapName("미나르숲:불과 물의 전장")
                        .itemName("장갑 공격력 주문서 10%")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2040805/icon?resize=2")
                        .dropRate(0.004)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("미나르숲:불과 물의 전장")
                        .itemName("페어프로즌")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1432011/icon?resize=2")
                        .dropRate(0.004)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("미나르숲:불과 물의 전장")
                        .itemName("장팔사모")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1432004/icon?resize=2")
                        .dropRate(0.009)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("미나르숲:불과 물의 전장")
                        .itemName("청운검")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1402004/icon?resize=2")
                        .dropRate(0.008)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("미나르숲:불과 물의 전장")
                        .itemName("골드 트윈 나이프")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1332051/icon?resize=2")
                        .dropRate(0.0003)
                        .build()
        ));

        // ----------------------------- 여기임 ------------------------------
        monsterDropItemRepository.saveAll(List.of(
                MonsterDropItem.builder()
                        .mapName("미나르숲:위험한 용의 둥지")
                        .itemName("라 투핸더")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1402016/icon?resize=2")
                        .dropRate(0.007)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("미나르숲:위험한 용의 둥지")
                        .itemName("드래곤의 영혼")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/4000244/icon?resize=2")
                        .dropRate(0.0003)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("미나르숲:위험한 용의 둥지")
                        .itemName("드래곤의 비늘")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/4000245/icon?resize=2")
                        .dropRate(0.0003)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("미나르숲:위험한 용의 둥지")
                        .itemName("[마스터리 북]패럴 라이즈 20")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2290030/icon?resize=2")
                        .dropRate(0.04)
                        .build(),
                MonsterDropItem.builder()
                        .mapName("미나르숲:위험한 용의 둥지")
                        .itemName("[마스터리 북]드래곤 펄스 20")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2290030/icon?resize=2")
                        .dropRate(0.004)
                        .build(),
                MonsterDropItem.builder()
                        .mapName("미나르숲:위험한 용의 둥지")
                        .itemName("[마스터리 북]크로스 보우 엑스퍼트 20")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2290030/icon?resize=2")
                        .dropRate(0.001)
                        .build(),
                MonsterDropItem.builder()
                        .mapName("미나르숲:위험한 용의 둥지")
                        .itemName("[마스터리 북]암살 20")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2290030/icon?resize=2")
                        .dropRate(0.001)
                        .build(),
                MonsterDropItem.builder()
                        .mapName("미나르숲:위험한 용의 둥지")
                        .itemName("레드 카테")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1051092/icon?resize=2")
                        .dropRate(0.01)
                        .build()
        ));

        // ----------------------------- 여기임 ------------------------------
        monsterDropItemRepository.saveAll(List.of(
                MonsterDropItem.builder()
                        .mapName("미나르숲:하늘 둥지2")
                        .itemName("뇌전 수리검")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2070005/icon?resize=2")
                        .dropRate(0.003)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("미나르숲:하늘 둥지2")
                        .itemName("석궁 공격력 주문서 10%")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2044602/icon?resize=2")
                        .dropRate(0.004)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("미나르숲:하늘 둥지2")
                        .itemName("골든 힌켈")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1452011/icon?resize=2")
                        .dropRate(0.007)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("미나르숲:하늘 둥지2")
                        .itemName("사파이어 엠페러")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1082114/icon?resize=2")
                        .dropRate(0.007)
                        .build(),
                MonsterDropItem.builder()
                        .mapName("미나르숲:하늘 둥지2")
                        .itemName("황룡도")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1442008/icon?resize=2")
                        .dropRate(0.008)
                        .build(),
                MonsterDropItem.builder()
                        .mapName("미나르숲:하늘 둥지2")
                        .itemName("레드 라피스 샌들")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1072158/icon?resize=2")
                        .dropRate(0.01)
                        .build(),
                MonsterDropItem.builder()
                        .mapName("미나르숲:하늘 둥지2")
                        .itemName("미하일")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1312010/icon?resize=2")
                        .dropRate(0.01)
                        .build(),
                MonsterDropItem.builder()
                        .mapName("미나르숲:하늘 둥지2")
                        .itemName("마법의 돌")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/4006000/icon?resize=2")
                        .dropRate(0.07)
                        .build()
        ));

        // ----------------------------- 여기임 ------------------------------
        monsterDropItemRepository.saveAll(List.of(
                MonsterDropItem.builder()
                        .mapName("미나르숲:남겨진 용의 둥지")
                        .itemName("[마스터리 북]샤프 아이즈 30")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2290068/icon?resize=2")
                        .dropRate(0.0002)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("미나르숲:남겨진 용의 둥지")
                        .itemName("[마스터리 북]부메랑 스탭 20")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2290068/icon?resize=2")
                        .dropRate(0.0002)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("미나르숲:남겨진 용의 둥지")
                        .itemName("[마스터리 북]어드밴스드 콤보 30")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2290068/icon?resize=2")
                        .dropRate(0.0002)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("미나르숲:남겨진 용의 둥지")
                        .itemName("드래곤의 비늘")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/4000245/icon?resize=2")
                        .dropRate(0.0004)
                        .build(),
                MonsterDropItem.builder()
                        .mapName("미나르숲:남겨진 용의 둥지")
                        .itemName("드래곤의 영혼")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/4000244/icon?resize=2")
                        .dropRate(0.0004)
                        .build(),
                MonsterDropItem.builder()
                        .mapName("미나르숲:남겨진 용의 둥지")
                        .itemName("[마스터리 북]피닉스 20")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2290062/icon?resize=2")
                        .dropRate(0.0003)
                        .build(),
                MonsterDropItem.builder()
                        .mapName("미나르숲:남겨진 용의 둥지")
                        .itemName("장갑 공격력 주문서 10%")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2044602/icon?resize=2")
                        .dropRate(0.004)
                        .build(),
                MonsterDropItem.builder()
                        .mapName("미나르숲:남겨진 용의 둥지")
                        .itemName("전신 갑옷 힘 주문서10%")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2044602/icon?resize=2")
                        .dropRate(0.005)
                        .build()
        ));


        monsterDropItemRepository.saveAll(List.of(
                MonsterDropItem.builder()
                        .mapName("미나르숲:마뇽의 숲")
                        .itemName("마뇽의 울음소리")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/4001076/icon?resize=2")
                        .dropRate(60)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("미나르숲:마뇽의 숲")
                        .itemName("[마스터리 북]패럴라이즈 20")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2290068/icon?resize=2")
                        .dropRate(0.8)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("미나르숲:마뇽의 숲")
                        .itemName("레드 크리븐")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1472053/icon?resize=2")
                        .dropRate(0.01)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("미나르숲:마뇽의 숲")
                        .itemName("블루 마린")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1382035/icon?resize=2")
                        .dropRate(0.01)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("미나르숲:마뇽의 숲")
                        .itemName("피나카")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1432030/icon?resize=2")
                        .dropRate(0.01)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("미나르숲:마뇽의 숲")
                        .itemName("화이트 니스록")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1452019/icon?resize=2")
                        .dropRate(0.01)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("미나르숲:마뇽의 숲")
                        .itemName("화이트 네쉐르")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1462015/icon?resize=2")
                        .dropRate(0.01)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("미나르숲:마뇽의 숲")
                        .itemName("다이몬의 완드")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1372010/icon?resize=2")
                        .dropRate(0.01)
                        .build()
        ));

        monsterDropItemRepository.saveAll(List.of(
                MonsterDropItem.builder()
                        .mapName("미나르숲:그리프의 숲")
                        .itemName("[마스터리북]체인 라이트닝 20")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2290032/icon?resize=2")
                        .dropRate(2)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("미나르숲:그리프의 숲")
                        .itemName("[마스터리북]아이스 데몬20")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2290042/icon?resize=2")
                        .dropRate(1)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("미나르숲:그리프의 숲")
                        .itemName("[마스터리북]암살 20")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2290042/icon?resize=2")
                        .dropRate(0.2)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("미나르숲:그리프의 숲")
                        .itemName("영웅의 별")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/4031344/icon?resize=2")
                        .dropRate(40)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("미나르숲:그리프의 숲")
                        .itemName("피나카")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1432030/icon?resize=2")
                        .dropRate(0.01)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("미나르숲:그리프의 숲")
                        .itemName("화이트 니스록")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1452019/icon?resize=2")
                        .dropRate(0.01)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("미나르숲:그리프의 숲")
                        .itemName("화이트 네쉐르")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1462015/icon?resize=2")
                        .dropRate(0.01)
                        .build()
                ));
    }
}
