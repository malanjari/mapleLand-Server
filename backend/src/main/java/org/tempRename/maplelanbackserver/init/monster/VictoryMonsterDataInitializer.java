package org.mapleland.maplelanbackserver.init.monster;

import lombok.RequiredArgsConstructor;

import org.mapleland.maplelanbackserver.repository.MonsterDropItemRepository;
import org.mapleland.maplelanbackserver.table.MonsterDropItem;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class VictoryMonsterDataInitializer {

    private final MonsterDropItemRepository monsterDropItemRepository;

    public void victoriaMonsterInit() {


        monsterDropItemRepository.saveAll(List.of(
                MonsterDropItem.builder()
                        .mapName("히든스트리트:골렘의 숲")
                        .itemName("장갑 공격력 주문서 60%")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2040804/icon?resize=2")
                        .dropRate(0.006)
                        .build(),
                MonsterDropItem.builder()
                        .mapName("히든스트리트:골렘의 숲")
                        .itemName("이블윙즈")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1382007/icon?resize=2")
                        .dropRate(0.006)
                        .build(),
                MonsterDropItem.builder()
                        .mapName("히든스트리트:골렘의 숲")
                        .itemName("활 공격력 주문서 10%")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2044502/icon?resize=2")
                        .dropRate(0.006)
                        .build(),
                MonsterDropItem.builder()
                        .mapName("히든스트리트:골렘의 숲")
                        .itemName("금비 표창")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2070003/icon?resize=2")
                        .dropRate(0.005)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("히든스트리트:골렘의 숲")
                        .itemName("막대 사탕")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1322003/icon?resize=2")
                        .dropRate(0.008)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("히든스트리트:골렘의 숲")
                        .itemName("자월")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1041077/icon?resize=2")
                        .dropRate(0.01)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("히든스트리트:골렘의 숲")
                        .itemName("이블테일러")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1372014/icon?resize=2")
                        .dropRate(0.005)
                        .build(),
                MonsterDropItem.builder()
                        .mapName("히든스트리트:골렘의 숲")
                        .itemName("엘릭서")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2000004/icon?resize=2")
                        .dropRate(0.01)
                        .build()
                ));


    }
}
