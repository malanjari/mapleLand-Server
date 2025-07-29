package org.mapleland.maplelanbackserver.init.monster;

import lombok.RequiredArgsConstructor;
import org.mapleland.maplelanbackserver.repository.MonsterDropItemRepository;
import org.mapleland.maplelanbackserver.table.MonsterDropItem;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class MagatiaMonsterDataInitializer {

    private final MonsterDropItemRepository monsterDropItemRepository;

    public void initMagatiaMonsterData() {

        monsterDropItemRepository.saveAll(List.of(
                MonsterDropItem.builder()
                        .mapName("알카드노 연구소:연구소 202호")
                        .itemName("투구 지력 주문서 60%")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2040025/icon?resize=2")
                        .dropRate(0.007)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("알카드노 연구소:연구소 202호")
                        .itemName("그륜힐")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1402012/icon?resize=2")
                        .dropRate(0.003)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("알카드노 연구소:연구소 202호")
                        .itemName("석궁 공격력 주문서 60%")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2040025/icon?resize=2")
                        .dropRate(0.007)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("알카드노 연구소:연구소 202호")
                        .itemName("레드 레퀴에르")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1051053/icon?resize=2")
                        .dropRate(0.004)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("알카드노 연구소:연구소 202호")
                        .itemName("레드 리버스부츠")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1072210/icon?resize=2")
                        .dropRate(0.06)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("알카드노 연구소:연구소 202호")
                        .itemName("블루 골드윙캡")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1002275/icon?resize=2")
                        .dropRate(0.06)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("알카드노 연구소:연구소 202호")
                        .itemName("사파이어 카멜부츠")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1072147/icon?resize=2")
                        .dropRate(0.008)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("알카드노 연구소:연구소 202호")
                        .itemName("블루 아나카룬")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1051044/icon?resize=2")
                        .dropRate(0.008)
                        .build()
        ));

        monsterDropItemRepository.saveAll(List.of(
                MonsterDropItem.builder()
                        .mapName("알카드노 연구소 : 연구소 C-3 구역")
                        .itemName("장갑 공격력 주문서 60%")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2040025/icon?resize=2")
                        .dropRate(0.01)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("알카드노 연구소 : 연구소 C-3 구역")
                        .itemName("방패 방어력 주문서 60%")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2040025/icon?resize=2")
                        .dropRate(0.01)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("알카드노 연구소 : 연구소 C-3 구역")
                        .itemName("백궁우")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1002269/icon?resize=2")
                        .dropRate(0.005)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("알카드노 연구소 : 연구소 C-3 구역")
                        .itemName("실버 하이드후드")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1002248/icon?resize=2")
                        .dropRate(0.005)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("알카드노 연구소 : 연구소 C-3 구역")
                        .itemName("레드 오리엔트 헬멧")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1002029/icon?resize=2")
                        .dropRate(0.005)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("알카드노 연구소 : 연구소 C-3 구역")
                        .itemName("그린 고어부츠")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1072146/icon?resize=2")
                        .dropRate(0.005)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("알카드노 연구소 : 연구소 C-3 구역")
                        .itemName("블루 루이마리")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1051037/icon?resize=2")
                        .dropRate(0.008)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("알카드노 연구소 : 연구소 C-3 구역")
                        .itemName("황월 장갑")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1082066/icon?resize=2")
                        .dropRate(0.008)
                        .build()
        ));

        monsterDropItemRepository.saveAll(List.of(
                MonsterDropItem.builder()
                        .mapName("알카드노 연구소: 연구소 C-2 구역")
                        .itemName("귀 장식 행운 주문서 10%")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2040323/icon?resize=2")
                        .dropRate(0.007)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("알카드노 연구소: 연구소 C-2 구역")
                        .itemName("블루 오리엔타이칸 바지")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1060081/icon?resize=2")
                        .dropRate(0.008)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("알카드노 연구소: 연구소 C-2 구역")
                        .itemName("블루 오리엔타이칸")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1040092/icon?resize=2")
                        .dropRate(0.008)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("알카드노 연구소: 연구소 C-2 구역")
                        .itemName("블루 숄더메일 바지")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1060076/icon?resize=2")
                        .dropRate(0.008)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("알카드노 연구소: 연구소 C-2 구역")
                        .itemName("블루 숄더메일")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1040087/icon?resize=2")
                        .dropRate(0.008)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("알카드노 연구소: 연구소 C-2 구역")
                        .itemName("장갑 공격력 주문서 60%")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2040804/icon?resize=2")
                        .dropRate(0.01)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("알카드노 연구소: 연구소 C-2 구역")
                        .itemName("황월 장갑")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1082066/icon?resize=2")
                        .dropRate(0.008)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("알카드노 연구소: 연구소 C-2 구역")
                        .itemName("블루 루이마리")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1051037/icon?resize=2")
                        .dropRate(0.008)
                        .build()
        ));

        monsterDropItemRepository.saveAll(List.of(
                MonsterDropItem.builder()
                        .mapName("알카드노 연구소: 연구소 C-1 구역")
                        .itemName("귀 장식 행운 주문서 10%")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2040323/icon?resize=2")
                        .dropRate(0.007)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("알카드노 연구소: 연구소 C-1 구역")
                        .itemName("블루 오리엔타이칸 바지")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1060081/icon?resize=2")
                        .dropRate(0.008)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("알카드노 연구소: 연구소 C-1 구역")
                        .itemName("블루 오리엔타이칸")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1040092/icon?resize=2")
                        .dropRate(0.008)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("알카드노 연구소: 연구소 C-1 구역")
                        .itemName("블루 숄더메일 바지")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1060076/icon?resize=2")
                        .dropRate(0.008)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("알카드노 연구소: 연구소 C-1 구역")
                        .itemName("블루 숄더메일")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1040087/icon?resize=2")
                        .dropRate(0.008)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("알카드노 연구소: 연구소 C-1 구역")
                        .itemName("청선백궁")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1050052/icon?resize=2")
                        .dropRate(0.008)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("알카드노 연구소: 연구소 C-1 구역")
                        .itemName("황일바지")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1060085/icon?resize=2")
                        .dropRate(0.008)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("알카드노 연구소: 연구소 C-1 구역")
                        .itemName("황일")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1040096/icon?resize=2")
                        .dropRate(0.008)
                        .build()
        ));

        monsterDropItemRepository.saveAll(List.of(
                MonsterDropItem.builder()
                        .mapName("알카드노 연구소: 연구소 A-1 구역")
                        .itemName("투구 민첩 주문서 100%")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2040027/icon?resize=2")
                        .dropRate(0.007)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("알카드노 연구소: 연구소 A-1 구역")
                        .itemName("귀 장식 민첩 주문서 60%")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2040317/icon?resize=2")
                        .dropRate(0.006)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("알카드노 연구소: 연구소 A-1 구역")
                        .itemName("석궁 공격력 주문서 10%")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2044602/icon?resize=2")
                        .dropRate(0.007)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("알카드노 연구소: 연구소 A-1 구역")
                        .itemName("베즐러드")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1332011/icon?resize=2")
                        .dropRate(0.008)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("알카드노 연구소: 연구소 A-1 구역")
                        .itemName("크로미")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1372007/icon?resize=2")
                        .dropRate(0.005)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("알카드노 연구소: 연구소 A-1 구역")
                        .itemName("플레임 골든서클릿")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1002215/icon?resize=2")
                        .dropRate(0.005)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("알카드노 연구소: 연구소 A-1 구역")
                        .itemName("두손도끼 공격력 주문서 10%")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2044602/icon?resize=2")
                        .dropRate(0.007)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("알카드노 연구소: 연구소 A-1 구역")
                        .itemName("엄버 숄더메일")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1040089/icon?resize=2")
                        .dropRate(0.005)
                        .build()
        ));

        monsterDropItemRepository.saveAll(List.of(
                MonsterDropItem.builder()
                        .mapName("알카드노 연구소 : 연구소 B-1 구역")
                        .itemName("엄버 숄더메일")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1040089/icon?resize=2")
                        .dropRate(0.005)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("알카드노 연구소 : 연구소 B-1 구역")
                        .itemName("두손도끼 공격력 주문서 10%")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2044602/icon?resize=2")
                        .dropRate(0.007)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("알카드노 연구소 : 연구소 B-1 구역")
                        .itemName("플레임 골든서클릿")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1002215/icon?resize=2")
                        .dropRate(0.005)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("알카드노 연구소 : 연구소 B-1 구역")
                        .itemName("크로미")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1372007/icon?resize=2")
                        .dropRate(0.005)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("알카드노 연구소 : 연구소 B-1 구역")
                        .itemName("투구 방어력 주문서 60%")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2040001/icon?resize=2")
                        .dropRate(0.007)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("알카드노 연구소 : 연구소 B-1 구역")
                        .itemName("민첩성의 크리스탈")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/4004002/icon?resize=2")
                        .dropRate(0.008)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("알카드노 연구소 : 연구소 B-1 구역")
                        .itemName("소환의 돌")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/4006001/icon?resize=2")
                        .dropRate(0.07)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("알카드노 연구소 : 연구소 B-1 구역")
                        .itemName("미스릴 파편")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/4000359/icon?resize=2")
                        .dropRate(40)
                        .build()
        ));




    }
}

