package org.mapleland.maplelanbackserver.init.monster;

import lombok.RequiredArgsConstructor;
import org.mapleland.maplelanbackserver.repository.MonsterDropItemRepository;
import org.mapleland.maplelanbackserver.table.MonsterDropItem;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@RequiredArgsConstructor
public class ElnathMonsterDataInitializer {

    private final MonsterDropItemRepository monsterDropItemRepository;

    public void initElnathMonsterData() {

        monsterDropItemRepository.saveAll(List.of(
                MonsterDropItem.builder()
                        .mapName("폐광:죽은 나무의 숲 1")
                        .itemName("벅")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1312008/icon?resize=2")
                        .dropRate(0.007)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("폐광:죽은 나무의 숲 1")
                        .itemName("크리스탈 플라워링")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1032019/icon?resize=2")
                        .dropRate(0.008)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("폐광:죽은 나무의 숲 1")
                        .itemName("전신 갑옷 행운 주문서 100%")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2040515/icon?resize=2")
                        .dropRate(0.007)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("폐광:죽은 나무의 숲 1")
                        .itemName("엘릭서")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2000004/icon?resize=2")
                        .dropRate(0.1)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("폐광:죽은 나무의 숲 1")
                        .itemName("적일")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1040094/icon?resize=2")
                        .dropRate(0.007)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("폐광:죽은 나무의 숲 1")
                        .itemName("젝커")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1322016/icon?resize=2")
                        .dropRate(0.01)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("폐광:죽은 나무의 숲 1")
                        .itemName("그린 세라피스")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1002244/icon?resize=2")
                        .dropRate(0.006)
                        .build(),
                MonsterDropItem.builder()
                        .mapName("폐광:죽은 나무의 숲 1")
                        .itemName("레드 루이마리")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1051039/icon?resize=2")
                        .dropRate(0.007)
                        .build()));

        monsterDropItemRepository.saveAll(List.of(
                MonsterDropItem.builder()
                        .mapName("폐광:죽은 나무의 숲 2")
                        .itemName("벅")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1312008/icon?resize=2")
                        .dropRate(0.007)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("폐광:죽은 나무의 숲 2")
                        .itemName("크리스탈 플라워링")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1032019/icon?resize=2")
                        .dropRate(0.008)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("폐광:죽은 나무의 숲 2")
                        .itemName("전신 갑옷 행운 주문서 100%")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2040515/icon?resize=2")
                        .dropRate(0.007)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("폐광:죽은 나무의 숲 2")
                        .itemName("엘릭서")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2000004/icon?resize=2")
                        .dropRate(0.1)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("폐광:죽은 나무의 숲 2")
                        .itemName("적일")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1040094/icon?resize=2")
                        .dropRate(0.007)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("폐광:죽은 나무의 숲 2")
                        .itemName("젝커")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1322016/icon?resize=2")
                        .dropRate(0.01)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("폐광:죽은 나무의 숲 2")
                        .itemName("그린 세라피스")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1002244/icon?resize=2")
                        .dropRate(0.006)
                        .build(),
                MonsterDropItem.builder()
                        .mapName("폐광:죽은 나무의 숲 2")
                        .itemName("레드 루이마리")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1051039/icon?resize=2")
                        .dropRate(0.007)
                        .build()));

        monsterDropItemRepository.saveAll(List.of(
                MonsterDropItem.builder()
                        .mapName("폐광:죽은 나무의 숲 3")
                        .itemName("벅")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1312008/icon?resize=2")
                        .dropRate(0.007)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("폐광:죽은 나무의 숲 3")
                        .itemName("크리스탈 플라워링")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1032019/icon?resize=2")
                        .dropRate(0.008)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("폐광:죽은 나무의 숲 3")
                        .itemName("전신 갑옷 행운 주문서 100%")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2040515/icon?resize=2")
                        .dropRate(0.007)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("폐광:죽은 나무의 숲 3")
                        .itemName("엘릭서")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2000004/icon?resize=2")
                        .dropRate(0.1)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("폐광:죽은 나무의 숲 3")
                        .itemName("적일")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1040094/icon?resize=2")
                        .dropRate(0.007)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("폐광:죽은 나무의 숲 3")
                        .itemName("젝커")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1322016/icon?resize=2")
                        .dropRate(0.01)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("폐광:죽은 나무의 숲 3")
                        .itemName("그린 세라피스")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1002244/icon?resize=2")
                        .dropRate(0.006)
                        .build(),
                MonsterDropItem.builder()
                        .mapName("폐광:죽은 나무의 숲 3")
                        .itemName("레드 루이마리")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1051039/icon?resize=2")
                        .dropRate(0.007)
                        .build()));




        monsterDropItemRepository.saveAll(List.of(
                MonsterDropItem.builder()
                        .mapName("폐광:죽은 나무의 숲 4")
                        .itemName("벅")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1312008/icon?resize=2")
                        .dropRate(0.007)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("폐광:죽은 나무의 숲 4")
                        .itemName("크리스탈 플라워링")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1032019/icon?resize=2")
                        .dropRate(0.008)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("폐광:죽은 나무의 숲 4")
                        .itemName("전신 갑옷 행운 주문서 100%")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2040515/icon?resize=2")
                        .dropRate(0.007)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("폐광:죽은 나무의 숲 4")
                        .itemName("엘릭서")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2000004/icon?resize=2")
                        .dropRate(0.1)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("폐광:죽은 나무의 숲 4")
                        .itemName("적일")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1040094/icon?resize=2")
                        .dropRate(0.007)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("폐광:죽은 나무의 숲 4")
                        .itemName("젝커")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1322016/icon?resize=2")
                        .dropRate(0.01)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("폐광:죽은 나무의 숲 4")
                        .itemName("그린 세라피스")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1002244/icon?resize=2")
                        .dropRate(0.006)
                        .build(),
                MonsterDropItem.builder()
                        .mapName("폐광:죽은 나무의 숲 4")
                        .itemName("레드 루이마리")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1051039/icon?resize=2")
                        .dropRate(0.007)
                        .build()));



        monsterDropItemRepository.saveAll(List.of(
                MonsterDropItem.builder()
                        .mapName("엘나스산맥:차디찬 벌판")
                        .itemName("토비 표창")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2070004/icon?resize=2")
                        .dropRate(0.01)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("엘나스산맥:차디찬 벌판")
                        .itemName("분홍꽃 귀걸이")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1032014/icon?resize=2")
                        .dropRate(0.01)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("엘나스산맥:차디찬 벌판")
                        .itemName("망토 민첩 주문서 60%")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2041019/icon?resize=2")
                        .dropRate(0.006)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("엘나스산맥:차디찬 벌판")
                        .itemName("금비 표창")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2070003/icon?resize=2")
                        .dropRate(0.01)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("엘나스산맥:차디찬 벌판")
                        .itemName("샤이닝")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1412007/icon?resize=2")
                        .dropRate(0.007)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("엘나스산맥:차디찬 벌판")
                        .itemName("스틸 보닌")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1472014/icon?resize=2")
                        .dropRate(0.01)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("엘나스산맥:차디찬 벌판")
                        .itemName("적선백궁")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1050051/icon?resize=2")
                        .dropRate(0.01)
                        .build(),
                MonsterDropItem.builder()
                        .mapName("엘나스산맥:차디찬 벌판")
                        .itemName("황월 장갑")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1082066/icon?resize=2")
                        .dropRate(0.01)
                        .build()));


        monsterDropItemRepository.saveAll(List.of(
                MonsterDropItem.builder()
                        .mapName("폐광: 늑대의영역1")
                        .itemName("일비 표창")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2070006/icon?resize=2")
                        .dropRate(0.008)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("폐광: 늑대의영역1")
                        .itemName("청갑충")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1472028/icon?resize=2")
                        .dropRate(0.008)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("폐광: 늑대의영역1")
                        .itemName("청운검")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1402004/icon?resize=2")
                        .dropRate(0.007)
                        .build(),


                MonsterDropItem.builder()
                        .mapName("폐광: 늑대의영역1")
                        .itemName("흑갑충")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1472029/icon?resize=2")
                        .dropRate(0.006)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("폐광: 늑대의영역1")
                        .itemName("귀 장식 지력 주문서 10%")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2040302/icon?resize=2")
                        .dropRate(0.002)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("폐광: 늑대의영역1")
                        .itemName("다크로린")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1082100/icon?resize=2")
                        .dropRate(0.008)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("폐광: 늑대의영역1")
                        .itemName("아대 공격력 주문서 60%")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2044701/icon?resize=2")
                        .dropRate(0.006)
                        .build(),
                MonsterDropItem.builder()
                        .mapName("폐광: 늑대의영역1")
                        .itemName("완드 마력 주문서 60%")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2044701/icon?resize=2")
                        .dropRate(0.006)
                        .build()));

        monsterDropItemRepository.saveAll(List.of(
                MonsterDropItem.builder()
                        .mapName("폐광: 늑대의영역2")
                        .itemName("일비 표창")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2070006/icon?resize=2")
                        .dropRate(0.008)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("폐광: 늑대의영역2")
                        .itemName("청갑충")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1472028/icon?resize=2")
                        .dropRate(0.008)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("폐광: 늑대의영역2")
                        .itemName("청운검")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1402004/icon?resize=2")
                        .dropRate(0.007)
                        .build(),


                MonsterDropItem.builder()
                        .mapName("폐광: 늑대의영역2")
                        .itemName("흑갑충")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1472029/icon?resize=2")
                        .dropRate(0.006)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("폐광: 늑대의영역2")
                        .itemName("귀 장식 지력 주문서 10%")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2040302/icon?resize=2")
                        .dropRate(0.002)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("폐광: 늑대의영역2")
                        .itemName("다크로린")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1082100/icon?resize=2")
                        .dropRate(0.008)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("폐광: 늑대의영역2")
                        .itemName("아대 공격력 주문서 60%")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2044701/icon?resize=2")
                        .dropRate(0.006)
                        .build(),
                MonsterDropItem.builder()
                        .mapName("폐광: 늑대의영역2")
                        .itemName("완드 마력 주문서 60%")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2044701/icon?resize=2")
                        .dropRate(0.006)
                        .build()));

        monsterDropItemRepository.saveAll(List.of(
                MonsterDropItem.builder()
                        .mapName("폐광: 늑대의영역3")
                        .itemName("일비 표창")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2070006/icon?resize=2")
                        .dropRate(0.008)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("폐광: 늑대의영역3")
                        .itemName("청갑충")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1472028/icon?resize=2")
                        .dropRate(0.008)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("폐광: 늑대의영역3")
                        .itemName("청운검")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1402004/icon?resize=2")
                        .dropRate(0.007)
                        .build(),


                MonsterDropItem.builder()
                        .mapName("폐광: 늑대의영역3")
                        .itemName("흑갑충")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1472029/icon?resize=2")
                        .dropRate(0.006)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("폐광: 늑대의영역3")
                        .itemName("귀 장식 지력 주문서 10%")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2040302/icon?resize=2")
                        .dropRate(0.002)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("폐광: 늑대의영역3")
                        .itemName("다크로린")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1082100/icon?resize=2")
                        .dropRate(0.008)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("폐광: 늑대의영역3")
                        .itemName("아대 공격력 주문서 60%")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2044701/icon?resize=2")
                        .dropRate(0.006)
                        .build(),
                MonsterDropItem.builder()
                        .mapName("폐광: 늑대의영역3")
                        .itemName("완드 마력 주문서 60%")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2044701/icon?resize=2")
                        .dropRate(0.006)
                        .build()));

        monsterDropItemRepository.saveAll(List.of(
                MonsterDropItem.builder()
                        .mapName("폐광: 늑대의영역4")
                        .itemName("일비 표창")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2070006/icon?resize=2")
                        .dropRate(0.008)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("폐광: 늑대의영역4")
                        .itemName("청갑충")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1472028/icon?resize=2")
                        .dropRate(0.008)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("폐광: 늑대의영역4")
                        .itemName("청운검")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1402004/icon?resize=2")
                        .dropRate(0.007)
                        .build(),


                MonsterDropItem.builder()
                        .mapName("폐광: 늑대의영역4")
                        .itemName("흑갑충")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1472029/icon?resize=2")
                        .dropRate(0.006)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("폐광: 늑대의영역4")
                        .itemName("귀 장식 지력 주문서 10%")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2040302/icon?resize=2")
                        .dropRate(0.002)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("폐광: 늑대의영역4")
                        .itemName("다크로린")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1082100/icon?resize=2")
                        .dropRate(0.008)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("폐광: 늑대의영역4")
                        .itemName("아대 공격력 주문서 60%")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2044701/icon?resize=2")
                        .dropRate(0.006)
                        .build(),
                MonsterDropItem.builder()
                        .mapName("폐광: 늑대의영역4")
                        .itemName("완드 마력 주문서 60%")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2044701/icon?resize=2")
                        .dropRate(0.006)
                        .build()));


    }
}
