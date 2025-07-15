package org.mapleland.maplelanbackserver.init.monster;

import lombok.RequiredArgsConstructor;
import org.mapleland.maplelanbackserver.repository.MonsterDropItemRepository;
import org.mapleland.maplelanbackserver.table.MonsterDropItem;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class AquariumMonsterDataInitializer {

    private final MonsterDropItemRepository monsterDropItemRepository;

    public void initAquariumMonsterData() {
        monsterDropItemRepository.saveAll(List.of(
                MonsterDropItem.builder()
                        .mapName("아쿠아로드: 난파선의 무덤")
                        .itemName("[마스터리북] 샤프 아이즈 20")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2290052/icon?resize=2")
                        .dropRate(0.004)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("아쿠아로드: 난파선의 무덤")
                        .itemName("[마스터리북] 아이스 데몬 20")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2290042/icon?resize=2")
                        .dropRate(0.001)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("아쿠아로드: 난파선의 무덤")
                        .itemName("귀 장식 지력 주문서 60%")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2040301/icon?resize=2")
                        .dropRate(0.004)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("아쿠아로드: 난파선의 무덤")
                        .itemName("망토 행운 주문서 60%")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2041022/icon?resize=2")
                        .dropRate(0.006)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("아쿠아로드: 난파선의 무덤")
                        .itemName("한손검 공격력 주문서 60%")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2043001/icon?resize=2")
                        .dropRate(0.006)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("아쿠아로드: 난파선의 무덤")
                        .itemName("망토 힘 주문서 60%")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2041013/icon?resize=2")
                        .dropRate(0.006)
                        .build(),
                MonsterDropItem.builder()
                        .mapName("아쿠아로드: 난파선의 무덤")
                        .itemName("아츠")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1302018/icon?resize=2")
                        .dropRate(0.01)
                        .build()));

        monsterDropItemRepository.saveAll(List.of(
                MonsterDropItem.builder()
                        .mapName("아쿠아로드:깊은 바다 협곡 1")
                        .itemName("전신 갑옷 민첩 주문서 60%")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2040501/icon?resize=2")
                        .dropRate(0.006)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("아쿠아로드:깊은 바다 협곡 1")
                        .itemName("청갑충")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1472028/icon?resize=2")
                        .dropRate(0.006)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("아쿠아로드:깊은 바다 협곡 1")
                        .itemName("전신 갑옷 지력 주문서 60%")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2040301/icon?resize=2")
                        .dropRate(0.006)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("아쿠아로드:깊은 바다 협곡 1")
                        .itemName("아대 공격력 주문서 60%")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2044701/icon?resize=2")
                        .dropRate(0.006)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("아쿠아로드:깊은 바다 협곡 1")
                        .itemName("검은색 세라프의 망토")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1102030/icon?resize=2")
                        .dropRate(0.006)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("아쿠아로드:깊은 바다 협곡 1")
                        .itemName("파이어 아룬드")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1452013/icon?resize=2")
                        .dropRate(0.006)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("아쿠아로드:깊은 바다 협곡 1")
                        .itemName("다크 엠페러")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1082117/icon?resize=2")
                        .dropRate(0.007)
                        .build(),
                MonsterDropItem.builder()
                        .mapName("아쿠아로드:깊은 바다 협곡 1")
                        .itemName("레드 배틀엠프리스")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1051078/icon?resize=2")
                        .dropRate(0.006)
                        .build()));


        monsterDropItemRepository.saveAll(List.of(
                MonsterDropItem.builder()
                        .mapName("아쿠아로드:깊은 바다 협곡 2")
                        .itemName("전신 갑옷 민첩 주문서 60%")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2040501/icon?resize=2")
                        .dropRate(0.006)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("아쿠아로드:깊은 바다 협곡 2")
                        .itemName("청갑충")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1472028/icon?resize=2")
                        .dropRate(0.006)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("아쿠아로드:깊은 바다 협곡 2")
                        .itemName("전신 갑옷 지력 주문서 60%")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2040301/icon?resize=2")
                        .dropRate(0.006)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("아쿠아로드:깊은 바다 협곡 2")
                        .itemName("아대 공격력 주문서 60%")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2044701/icon?resize=2")
                        .dropRate(0.006)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("아쿠아로드:깊은 바다 협곡 2")
                        .itemName("검은색 세라프의 망토")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1102030/icon?resize=2")
                        .dropRate(0.006)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("아쿠아로드:깊은 바다 협곡 2")
                        .itemName("파이어 아룬드")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1452013/icon?resize=2")
                        .dropRate(0.006)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("아쿠아로드:깊은 바다 협곡 2")
                        .itemName("다크 엠페러")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1082117/icon?resize=2")
                        .dropRate(0.007)
                        .build(),
                MonsterDropItem.builder()
                        .mapName("아쿠아로드:깊은 바다 협곡 2")
                        .itemName("레드 배틀엠프리스")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1051078/icon?resize=2")
                        .dropRate(0.006)
                        .build()));

        monsterDropItemRepository.saveAll(List.of(
                MonsterDropItem.builder()
                        .mapName("아쿠아로드:위험한 바다 협곡 1")
                        .itemName("[마스터리북]체인 라이트닝 20")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2290032/icon?resize=2")
                        .dropRate(0.06)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("아쿠아로드:위험한 바다 협곡 1")
                        .itemName("흑견랑포")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1051097/icon?resize=2")
                        .dropRate(0.008)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("아쿠아로드:위험한 바다 협곡 1")
                        .itemName("[마스터리북]닌자 앰부쉬 20")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2290082/icon?resize=2")
                        .dropRate(0.001)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("아쿠아로드:위험한 바다 협곡 1")
                        .itemName("장미꽃 귀걸이")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1032017/icon?resize=2")
                        .dropRate(0.006)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("아쿠아로드:위험한 바다 협곡 1")
                        .itemName("그린 아네스")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1051084/icon?resize=2")
                        .dropRate(0.006)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("아쿠아로드:위험한 바다 협곡 1")
                        .itemName("헬리오스")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1412009/icon?resize=2")
                        .dropRate(0.01)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("아쿠아로드:위험한 바다 협곡 1")
                        .itemName("장갑 공격력 주문서 60%")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2040804/icon?resize=2")
                        .dropRate(0.006)
                        .build(),
                MonsterDropItem.builder()
                        .mapName("아쿠아로드:위험한 바다 협곡 1")
                        .itemName("아대 공격력 주문서 60%")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2044701/icon?resize=2")
                        .dropRate(0.006)
                        .build()));


        monsterDropItemRepository.saveAll(List.of(
                MonsterDropItem.builder()
                        .mapName("아쿠아로드:위험한 바다 협곡 2")
                        .itemName("[마스터리북]체인 라이트닝 20")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2290032/icon?resize=2")
                        .dropRate(0.06)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("아쿠아로드:위험한 바다 협곡 2")
                        .itemName("흑견랑포")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1051097/icon?resize=2")
                        .dropRate(0.008)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("아쿠아로드:위험한 바다 협곡 2")
                        .itemName("장미꽃 귀걸이")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1032017/icon?resize=2")
                        .dropRate(0.006)
                        .build(),


                MonsterDropItem.builder()
                        .mapName("아쿠아로드:위험한 바다 협곡 2")
                        .itemName("호프만")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1422010/icon?resize=2")
                        .dropRate(0.01)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("아쿠아로드:위험한 바다 협곡 2")
                        .itemName("그린 아네스")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1051084/icon?resize=2")
                        .dropRate(0.006)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("아쿠아로드:위험한 바다 협곡 2")
                        .itemName("헬리오스")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1412009/icon?resize=2")
                        .dropRate(0.01)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("아쿠아로드:위험한 바다 협곡 2")
                        .itemName("장갑 공격력 주문서 60%")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2040804/icon?resize=2")
                        .dropRate(0.006)
                        .build(),
                MonsterDropItem.builder()
                        .mapName("아쿠아로드:위험한 바다 협곡 2")
                        .itemName("아대 공격력 주문서 60%")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2044701/icon?resize=2")
                        .dropRate(0.006)
                        .build()));


        monsterDropItemRepository.saveAll(List.of(
                MonsterDropItem.builder()
                        .mapName("아쿠아로드:피아누스의 동굴")
                        .itemName("[마스터리북]샤프 아이즈 20")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2290032/icon?resize=2")
                        .dropRate(20)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("아쿠아로드:피아누스의 동굴")
                        .itemName("[마스터리북]페이크 20")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2290032/icon?resize=2")
                        .dropRate(20)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("아쿠아로드:피아누스의 동굴")
                        .itemName("[마스터리북]돌진 30")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2290032/icon?resize=2")
                        .dropRate(20)
                        .build(),


                MonsterDropItem.builder()
                        .mapName("아쿠아로드:피아누스의 동굴")
                        .itemName("[마스터리북]샤프 아이즈 30")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2290032/icon?resize=2")
                        .dropRate(2)
                        .build(),


                MonsterDropItem.builder()
                        .mapName("아쿠아로드:피아누스의 동굴")
                        .itemName("[마스터리북]돌진 30")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2290032/icon?resize=2")
                        .dropRate(1)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("아쿠아로드:피아누스의 동굴")
                        .itemName("[마스터리북]피아누스의 미니어쳐")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/4000175/icon?resize=2")
                        .dropRate(60)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("아쿠아로드:피아누스의 동굴")
                        .itemName("[마스터리북]드래곤 펄스 20")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2290032/icon?resize=2")
                        .dropRate(4)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("아쿠아로드:피아누스의 동굴")
                        .itemName("[마스터리북]빅뱅 20")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2290032/icon?resize=2")
                        .dropRate(20)
                        .build()
        ));


    }
}
