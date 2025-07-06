package org.mapleLand.maplelanbackserver.init.monster;

import lombok.RequiredArgsConstructor;
import org.mapleLand.maplelanbackserver.repository.MapDropItemRepository;
import org.mapleLand.maplelanbackserver.table.MapDropItemEntity;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@RequiredArgsConstructor
public class OrbisMonsterDataInitializer {

    private final MapDropItemRepository mapDropItemRepository;


    public void initOrbisMonsterData() {
        mapDropItemRepository.saveAll(List.of(
                MapDropItemEntity.builder()
                        .mapName("스카이로드: 구름공원1")
                        .itemName("망토 힘 주문서 100%")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2041012/icon?resize=2")
                        .dropRate(0.006)
                        .build(),
                MapDropItemEntity.builder()
                        .mapName("스카이로드: 구름공원1")
                        .itemName("마법의 돌")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/4006000/icon?resize=2")
                        .dropRate(0.08)
                        .build(),
                MapDropItemEntity.builder()
                        .mapName("스카이로드: 구름공원1")
                        .itemName("냄비 뚜껑")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1092008/icon?resize=2")
                        .dropRate(0.008)
                        .build(),

                MapDropItemEntity.builder()
                        .mapName("스카이로드: 구름공원1")
                        .itemName("하늘색 우산")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1302017/icon?resize=2")
                        .dropRate(0.008)
                        .build(),
                MapDropItemEntity.builder()
                        .mapName("스카이로드: 구름공원1")
                        .itemName("물고기 작살")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1432008/icon?resize=2")
                        .dropRate(0.01)
                        .build(),
                MapDropItemEntity.builder()
                        .mapName("스카이로드: 구름공원1")
                        .itemName("방패 방어력 주문서 10%")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2040902/icon?resize=2")
                        .dropRate(0.006)
                        .build()

        ));

        mapDropItemRepository.saveAll(List.of(
                MapDropItemEntity.builder()
                        .mapName("스카이로드: 구름공원2")
                        .itemName("신발 점프력 주문서 10%")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2040705/icon?resize=2")
                        .dropRate(0.006)
                        .build(),
                MapDropItemEntity.builder()
                        .mapName("스카이로드: 구름공원2")
                        .itemName("마법의 돌")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/4006000/icon?resize=2")
                        .dropRate(0.08)
                        .build(),
                MapDropItemEntity.builder()
                        .mapName("스카이로드: 구름공원2")
                        .itemName("냄비 뚜껑")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1092008/icon?resize=2")
                        .dropRate(0.008)
                        .build(),
                MapDropItemEntity.builder()
                        .mapName("스카이로드: 구름공원2")
                        .itemName("망토 힘 주문서 100%")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2041012/icon?resize=2")
                        .dropRate(0.006)
                        .build(),
                MapDropItemEntity.builder()
                        .mapName("스카이로드: 구름공원2")
                        .itemName("하늘색 우산")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1302017/icon?resize=2")
                        .dropRate(0.008)
                        .build(),
                MapDropItemEntity.builder()
                        .mapName("스카이로드: 구름공원2")
                        .itemName("목비 표창")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2070002/icon?resize=2")
                        .dropRate(0.01)
                        .build()));


        mapDropItemRepository.saveAll(List.of(
                MapDropItemEntity.builder()
                        .mapName("스카이로드: 구름공원3")
                        .itemName("신발 점프력 주문서 10%")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2040705/icon?resize=2")
                        .dropRate(0.006)
                        .build(),
                MapDropItemEntity.builder()
                        .mapName("스카이로드: 구름공원3")
                        .itemName("마법의 돌")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/4006000/icon?resize=2")
                        .dropRate(0.08)
                        .build(),
                MapDropItemEntity.builder()
                        .mapName("스카이로드: 구름공원3")
                        .itemName("냄비 뚜껑")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1092008/icon?resize=2")
                        .dropRate(0.008)
                        .build(),
                MapDropItemEntity.builder()
                        .mapName("스카이로드: 구름공원3")
                        .itemName("망토 힘 주문서 100%")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2041012/icon?resize=2")
                        .dropRate(0.006)
                        .build(),
                MapDropItemEntity.builder()
                        .mapName("스카이로드: 구름공원3")
                        .itemName("하늘색 우산")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1302017/icon?resize=2")
                        .dropRate(0.008)
                        .build(),
                MapDropItemEntity.builder()
                        .mapName("스카이로드: 구름공원3")
                        .itemName("목비 표창")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2070002/icon?resize=2")
                        .dropRate(0.01)
                        .build()));

        mapDropItemRepository.saveAll(List.of(
                MapDropItemEntity.builder()
                        .mapName("스카이로드: 구름공원4")
                        .itemName("신발 점프력 주문서 10%")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2040705/icon?resize=2")
                        .dropRate(0.006)
                        .build(),
                MapDropItemEntity.builder()
                        .mapName("스카이로드: 구름공원4")
                        .itemName("마법의 돌")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/4006000/icon?resize=2")
                        .dropRate(0.08)
                        .build(),
                MapDropItemEntity.builder()
                        .mapName("스카이로드: 구름공원4")
                        .itemName("냄비 뚜껑")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1092008/icon?resize=2")
                        .dropRate(0.008)
                        .build(),
                MapDropItemEntity.builder()
                        .mapName("스카이로드: 구름공원4")
                        .itemName("망토 힘 주문서 100%")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2041012/icon?resize=2")
                        .dropRate(0.006)
                        .build(),
                MapDropItemEntity.builder()
                        .mapName("스카이로드: 구름공원4")
                        .itemName("하늘색 우산")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1302017/icon?resize=2")
                        .dropRate(0.008)
                        .build(),
                MapDropItemEntity.builder()
                        .mapName("스카이로드: 구름공원4")
                        .itemName("목비 표창")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2070002/icon?resize=2")
                        .dropRate(0.01)
                        .build()));


        mapDropItemRepository.saveAll(List.of(
                MapDropItemEntity.builder()
                        .mapName("스카이로드: 구름공원5")
                        .itemName("신발 점프력 주문서 10%")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2040705/icon?resize=2")
                        .dropRate(0.006)
                        .build(),
                MapDropItemEntity.builder()
                        .mapName("스카이로드: 구름공원5")
                        .itemName("마법의 돌")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/4006000/icon?resize=2")
                        .dropRate(0.08)
                        .build(),
                MapDropItemEntity.builder()
                        .mapName("스카이로드: 구름공원5")
                        .itemName("노란색 우산")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1302016/icon?resize=2")
                        .dropRate(0.008)
                        .build(),
                MapDropItemEntity.builder()
                        .mapName("스카이로드: 구름공원5")
                        .itemName("망토 지력 주문서 10%")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2041017/icon?resize=2")
                        .dropRate(0.006)
                        .build(),
                MapDropItemEntity.builder()
                        .mapName("스카이로드: 구름공원5")
                        .itemName("목비 표창")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2070002/icon?resize=2")
                        .dropRate(0.01)
                        .build(),
                MapDropItemEntity.builder()
                        .mapName("스카이로드: 구름공원5")
                        .itemName("배틀 실드")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1092007/icon?resize=2")
                        .dropRate(0.01)
                        .build()));

        mapDropItemRepository.saveAll(List.of(
                MapDropItemEntity.builder()
                        .mapName("스카이로드: 구름공원6")
                        .itemName("신발 점프력 주문서 10%")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2040705/icon?resize=2")
                        .dropRate(0.006)
                        .build(),
                MapDropItemEntity.builder()
                        .mapName("스카이로드: 구름공원6")
                        .itemName("마법의 돌")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/4006000/icon?resize=2")
                        .dropRate(0.08)
                        .build(),
                MapDropItemEntity.builder()
                        .mapName("스카이로드: 구름공원6")
                        .itemName("노란색 우산")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1302016/icon?resize=2")
                        .dropRate(0.008)
                        .build(),
                MapDropItemEntity.builder()
                        .mapName("스카이로드: 구름공원6")
                        .itemName("망토 지력 주문서 10%")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2041017/icon?resize=2")
                        .dropRate(0.006)
                        .build(),
                MapDropItemEntity.builder()
                        .mapName("스카이로드: 구름공원6")
                        .itemName("목비 표창")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2070002/icon?resize=2")
                        .dropRate(0.01)
                        .build(),
                MapDropItemEntity.builder()
                        .mapName("스카이로드: 구름공원6")
                        .itemName("배틀 실드")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1092007/icon?resize=2")
                        .dropRate(0.01)
                        .build()));


    }
}
