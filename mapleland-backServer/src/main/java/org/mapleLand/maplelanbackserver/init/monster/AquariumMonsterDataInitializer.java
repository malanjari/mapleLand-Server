package org.mapleLand.maplelanbackserver.init.monster;

import lombok.RequiredArgsConstructor;
import org.mapleLand.maplelanbackserver.repository.MapDropItemRepository;
import org.mapleLand.maplelanbackserver.table.MapDropItemEntity;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@RequiredArgsConstructor
public class AquariumMonsterDataInitializer {

    private final MapDropItemRepository mapDropItemRepository;

    public void initAquariumMonsterData(){
        mapDropItemRepository.saveAll(List.of(
                MapDropItemEntity.builder()
                        .mapName("아쿠아로드: 난파선의 무덤")
                        .itemName("[마스터리북] 샤프 아이즈 20")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2290052/icon?resize=2")
                        .dropRate(0.004)
                        .build(),

                MapDropItemEntity.builder()
                        .mapName("아쿠아로드: 난파선의 무덤")
                        .itemName("[마스터리북] 아이스 데몬 20")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2290042/icon?resize=2")
                        .dropRate(0.001)
                        .build(),

                MapDropItemEntity.builder()
                        .mapName("아쿠아로드: 난파선의 무덤")
                        .itemName("귀 장식 지력 주문서 60%")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2040301/icon?resize=2")
                        .dropRate(0.004)
                        .build(),

                MapDropItemEntity.builder()
                        .mapName("아쿠아로드: 난파선의 무덤")
                        .itemName("망토 행운 주문서 60%")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2041022/icon?resize=2")
                        .dropRate(0.006)
                        .build(),
                MapDropItemEntity.builder()
                        .mapName("아쿠아로드: 난파선의 무덤")
                        .itemName("망토 힘 주문서 60%")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2041013/icon?resize=2")
                        .dropRate(0.006)
                        .build()));



        mapDropItemRepository.saveAll(List.of(
                MapDropItemEntity.builder()
                        .mapName("아쿠아로드:깊은 바다 협곡 1")
                        .itemName("전신 갑옷 민첩 주문서 60%")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2040501/icon?resize=2")
                        .dropRate(0.006)
                        .build(),

                MapDropItemEntity.builder()
                        .mapName("아쿠아로드:깊은 바다 협곡 1")
                        .itemName("청갑충")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1472028/icon?resize=2")
                        .dropRate(0.006)
                        .build(),

                MapDropItemEntity.builder()
                        .mapName("아쿠아로드:깊은 바다 협곡 1")
                        .itemName("전신 갑옷 지력 주문서 60%")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2040301/icon?resize=2")
                        .dropRate(0.006)
                        .build(),

                MapDropItemEntity.builder()
                        .mapName("아쿠아로드:깊은 바다 협곡 1")
                        .itemName("아대 공격력 주문서 60%")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2044701/icon?resize=2")
                        .dropRate(0.006)
                        .build(),
                MapDropItemEntity.builder()
                        .mapName("아쿠아로드:깊은 바다 협곡 1")
                        .itemName("레드 배틀엠프리스")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1051078/icon?resize=2")
                        .dropRate(0.006)
                        .build()));


        mapDropItemRepository.saveAll(List.of(
                MapDropItemEntity.builder()
                        .mapName("아쿠아로드:깊은 바다 협곡 2")
                        .itemName("전신 갑옷 민첩 주문서 60%")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2040501/icon?resize=2")
                        .dropRate(0.006)
                        .build(),

                MapDropItemEntity.builder()
                        .mapName("아쿠아로드:깊은 바다 협곡 2")
                        .itemName("청갑충")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1472028/icon?resize=2")
                        .dropRate(0.006)
                        .build(),

                MapDropItemEntity.builder()
                        .mapName("아쿠아로드:깊은 바다 협곡 2")
                        .itemName("전신 갑옷 지력 주문서 60%")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2040301/icon?resize=2")
                        .dropRate(0.006)
                        .build(),

                MapDropItemEntity.builder()
                        .mapName("아쿠아로드:깊은 바다 협곡 2")
                        .itemName("아대 공격력 주문서 60%")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2044701/icon?resize=2")
                        .dropRate(0.006)
                        .build(),
                MapDropItemEntity.builder()
                        .mapName("아쿠아로드:깊은 바다 협곡 2")
                        .itemName("레드 배틀엠프리스")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1051078/icon?resize=2")
                        .dropRate(0.006)
                        .build()));


        mapDropItemRepository.saveAll(List.of(
                MapDropItemEntity.builder()
                        .mapName("아쿠아로드:위험한 바다 협곡 1")
                        .itemName("[마스터리북]체인 라이트닝 20")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2290032/icon?resize=2")
                        .dropRate(0.06)
                        .build(),

                MapDropItemEntity.builder()
                        .mapName("아쿠아로드:위험한 바다 협곡 1")
                        .itemName("흑견랑포")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1051097/icon?resize=2")
                        .dropRate(0.008)
                        .build(),

                MapDropItemEntity.builder()
                        .mapName("아쿠아로드:위험한 바다 협곡 1")
                        .itemName("[마스터리북]닌자 앰부쉬 20")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2290082/icon?resize=2")
                        .dropRate(0.001)
                        .build(),

                MapDropItemEntity.builder()
                        .mapName("아쿠아로드:위험한 바다 협곡 1")
                        .itemName("장갑 공격력 주문서 60%")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2040804/icon?resize=2")
                        .dropRate(0.006)
                        .build(),
                MapDropItemEntity.builder()
                        .mapName("아쿠아로드:위험한 바다 협곡 1")
                        .itemName("아대 공격력 주문서 60%")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2044701/icon?resize=2")
                        .dropRate(0.006)
                        .build()));



        mapDropItemRepository.saveAll(List.of(
                MapDropItemEntity.builder()
                        .mapName("아쿠아로드:위험한 바다 협곡 2")
                        .itemName("[마스터리북]체인 라이트닝 20")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2290032/icon?resize=2")
                        .dropRate(0.06)
                        .build(),

                MapDropItemEntity.builder()
                        .mapName("아쿠아로드:위험한 바다 협곡 2")
                        .itemName("흑견랑포")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1051097/icon?resize=2")
                        .dropRate(0.008)
                        .build(),

                MapDropItemEntity.builder()
                        .mapName("아쿠아로드:위험한 바다 협곡 2")
                        .itemName("장미꽃 귀걸이")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1032017/icon?resize=2")
                        .dropRate(0.006)
                        .build(),

                MapDropItemEntity.builder()
                        .mapName("아쿠아로드:위험한 바다 협곡 2")
                        .itemName("장갑 공격력 주문서 60%")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2040804/icon?resize=2")
                        .dropRate(0.006)
                        .build(),
                MapDropItemEntity.builder()
                        .mapName("아쿠아로드:위험한 바다 협곡 2")
                        .itemName("아대 공격력 주문서 60%")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2044701/icon?resize=2")
                        .dropRate(0.006)
                        .build()));

    }
}
