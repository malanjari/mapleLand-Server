package org.mapleland.maplelanbackserver.init.monster;

import lombok.RequiredArgsConstructor;
import org.mapleland.maplelanbackserver.repository.MonsterDropItemRepository;
import org.mapleland.maplelanbackserver.table.MonsterDropItem;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@RequiredArgsConstructor
public class LudibriumMonsterDataInitializer {

    private final MonsterDropItemRepository monsterDropItemRepository;

        public void initLudibriumMonsterData() {

            monsterDropItemRepository.saveAll(List.of(
                    MonsterDropItem.builder()
                            .mapName("루디브리엄성:시간의길<1>")
                            .itemName("에스터 실드")
                            .itemImageUrl("https://maplestory.io/api/gms/62/item/1092029/icon?resize=2")
                            .dropRate(0.008)
                            .build(),
                    MonsterDropItem.builder()
                            .mapName("루디브리엄성:시간의길<1>")
                            .itemName("장갑 공격력 주문서 60%")
                            .itemImageUrl("https://maplestory.io/api/gms/62/item/2040804/icon?resize=2")
                            .dropRate(0.004)
                            .build(),
                    MonsterDropItem.builder()
                            .mapName("루디브리엄성:시간의길<1>")
                            .itemName("장팔사모")
                            .itemImageUrl("https://maplestory.io/api/gms/62/item/1432004/icon?resize=2")
                            .dropRate(0.005)
                            .build(),

                    MonsterDropItem.builder()
                            .mapName("루디브리엄성:시간의길<1>")
                            .itemName("벅")
                            .itemImageUrl("https://maplestory.io/api/gms/62/item/1312008/icon?resize=2")
                            .dropRate(0.005)
                            .build(),
                    MonsterDropItem.builder()
                            .mapName("루디브리엄성:시간의길<1>")
                            .itemName("쟈드")
                            .itemImageUrl("https://maplestory.io/api/gms/62/item/1402007/icon?resize=2")
                            .dropRate(0.01)
                            .build(),
                    MonsterDropItem.builder()
                            .mapName("루디브리엄성:시간의길<1>")
                            .itemName("다크 클리브")
                            .itemImageUrl("https://maplestory.io/api/gms/62/item/1082074/icon?resize=2")
                            .dropRate(0.008)
                            .build(),
                    MonsterDropItem.builder()
                            .mapName("루디브리엄성:시간의길<1>")
                            .itemName("그린 매티")
                            .itemImageUrl("https://maplestory.io/api/gms/62/item/1002143/icon?resize=2")
                            .dropRate(0.01)
                            .build(),
                    MonsterDropItem.builder()
                            .mapName("루디브리엄성:시간의길<1>")
                            .itemName("레드 스타라이트")
                            .itemImageUrl("https://maplestory.io/api/gms/62/item/1050036/icon?resize=2")
                            .dropRate(0.01)
                            .build()

            ));



            monsterDropItemRepository.saveAll(List.of(
                    MonsterDropItem.builder()
                            .mapName("루디브리엄성:시간의길<2>")
                            .itemName("미스틱 실드")
                            .itemImageUrl("https://maplestory.io/api/gms/62/item/1092021/icon?resize=2")
                            .dropRate(0.008)
                            .build(),
                    MonsterDropItem.builder()
                            .mapName("루디브리엄성:시간의길<2>")
                            .itemName("완드 마력 주문서 10%")
                            .itemImageUrl("https://maplestory.io/api/gms/62/item/2043702/icon?resize=2")
                            .dropRate(0.004)
                            .build(),
                    MonsterDropItem.builder()
                            .mapName("루디브리엄성:시간의길<2>")
                            .itemName("다크 후르츠")
                            .itemImageUrl("https://maplestory.io/api/gms/62/item/1051006/icon?resize=2")
                            .dropRate(0.01)
                            .build(),

                    MonsterDropItem.builder()
                            .mapName("루디브리엄성:시간의길<2>")
                            .itemName("투구 민첩 주문서 60%")
                            .itemImageUrl("https://maplestory.io/api/gms/62/item/2044201/icon?resize=2")
                            .dropRate(0.006)
                            .build(),
                    MonsterDropItem.builder()
                            .mapName("루디브리엄성:시간의길<2>")
                            .itemName("블루 필퍼")
                            .itemImageUrl("https://maplestory.io/api/gms/62/item/1002182/icon?resize=2")
                            .dropRate(0.007)
                            .build(),
                    MonsterDropItem.builder()
                            .mapName("루디브리엄성:시간의길<2>")
                            .itemName("자진일갑주")
                            .itemImageUrl("https://maplestory.io/api/gms/62/item/1040085/icon?resize=2")
                            .dropRate(0.008)
                            .build(),
                    MonsterDropItem.builder()
                            .mapName("루디브리엄성:시간의길<2>")
                            .itemName("화이트 길티언")
                            .itemImageUrl("https://maplestory.io/api/gms/62/item/1002155/icon?resize=2")
                            .dropRate(0.007)
                            .build(),
                    MonsterDropItem.builder()
                            .mapName("루디브리엄성:시간의길<2>")
                            .itemName("백진일갑주 바지")
                            .itemImageUrl("https://maplestory.io/api/gms/62/item/1060074/icon?resize=2")
                            .dropRate(0.007)
                            .build()


            ));


            monsterDropItemRepository.saveAll(List.of(
                    MonsterDropItem.builder()
                            .mapName("루디브리엄성:시간의길<3>")
                            .itemName("미스틱 실드")
                            .itemImageUrl("https://maplestory.io/api/gms/62/item/1092021/icon?resize=2")
                            .dropRate(0.008)
                            .build(),
                    MonsterDropItem.builder()
                            .mapName("루디브리엄성:시간의길<3>")
                            .itemName("완드 마력 주문서 10%")
                            .itemImageUrl("https://maplestory.io/api/gms/62/item/2043702/icon?resize=2")
                            .dropRate(0.004)
                            .build(),
                    MonsterDropItem.builder()
                            .mapName("루디브리엄성:시간의길<3>")
                            .itemName("다크 후르츠")
                            .itemImageUrl("https://maplestory.io/api/gms/62/item/1051006/icon?resize=2")
                            .dropRate(0.01)
                            .build(),

                    MonsterDropItem.builder()
                            .mapName("루디브리엄성:시간의길<3>")
                            .itemName("두손 도끼 공격력 주문서 60%")
                            .itemImageUrl("https://maplestory.io/api/gms/62/item/2044201/icon?resize=2")
                            .dropRate(0.004)
                            .build(),
                    MonsterDropItem.builder()
                            .mapName("루디브리엄성:시간의길<3>")
                            .itemName("블루 필퍼")
                            .itemImageUrl("https://maplestory.io/api/gms/62/item/1002182/icon?resize=2")
                            .dropRate(0.007)
                            .build(),
                    MonsterDropItem.builder()
                            .mapName("루디브리엄성:시간의길<3>")
                            .itemName("자진일갑주")
                            .itemImageUrl("https://maplestory.io/api/gms/62/item/1040085/icon?resize=2")
                            .dropRate(0.008)
                            .build(),
                    MonsterDropItem.builder()
                            .mapName("루디브리엄성:시간의길<3>")
                            .itemName("화이트 길티언")
                            .itemImageUrl("https://maplestory.io/api/gms/62/item/1002155/icon?resize=2")
                            .dropRate(0.007)
                            .build(),
                    MonsterDropItem.builder()
                            .mapName("루디브리엄성:시간의길<3>")
                            .itemName("백진일갑주 바지")
                            .itemImageUrl("https://maplestory.io/api/gms/62/item/1060074/icon?resize=2")
                            .dropRate(0.007)
                            .build()


            ));


            monsterDropItemRepository.saveAll(List.of(
                    MonsterDropItem.builder()
                            .mapName("루디브리엄성:시간의길<4>")
                            .itemName("스태프 마력 주문서 10%")
                            .itemImageUrl("https://maplestory.io/api/gms/62/item/2043802/icon?resize=2")
                            .dropRate(0.004)
                            .build(),
                    MonsterDropItem.builder()
                            .mapName("루디브리엄성:시간의길<4>")
                            .itemName("두손 도끼 공격력 주문서 10%")
                            .itemImageUrl("https://maplestory.io/api/gms/62/item/2043802/icon?resize=2")
                            .dropRate(0.004)
                            .build(),
                    MonsterDropItem.builder()
                            .mapName("루디브리엄성:시간의길<4>")
                            .itemName("다크 슬레인")
                            .itemImageUrl("https://maplestory.io/api/gms/62/item/1472021/icon?resize=2")
                            .dropRate(0.006)
                            .build(),

                    MonsterDropItem.builder()
                            .mapName("루디브리엄성:시간의길<4>")
                            .itemName("토비 표창")
                            .itemImageUrl("https://maplestory.io/api/gms/62/item/2070004/icon?resize=2")
                            .dropRate(0.007)
                            .build(),
                    MonsterDropItem.builder()
                            .mapName("루디브리엄성:시간의길<4>")
                            .itemName("엘릭서")
                            .itemImageUrl("https://maplestory.io/api/gms/62/item/2000004/icon?resize=2")
                            .dropRate(1)
                            .build(),
                    MonsterDropItem.builder()
                            .mapName("루디브리엄성:시간의길<4>")
                            .itemName("다크 칼라스")
                            .itemImageUrl("https://maplestory.io/api/gms/62/item/1050049/icon?resize=2")
                            .dropRate(0.007)
                            .build(),
                    MonsterDropItem.builder()
                            .mapName("루디브리엄성:시간의길<4>")
                            .itemName("아이보리 숄더메일")
                            .itemImageUrl("https://maplestory.io/api/gms/62/item/1041088/icon?resize=2")
                            .dropRate(0.007)
                            .build(),
                    MonsterDropItem.builder()
                            .mapName("루디브리엄성:시간의길<4>")
                            .itemName("골든 모울")
                            .itemImageUrl("https://maplestory.io/api/gms/62/item/1422005/icon?resize=2")
                            .dropRate(0.006)
                            .build()

            ));

            monsterDropItemRepository.saveAll(List.of(
                    MonsterDropItem.builder()
                            .mapName("시계탑최하층:뒤틀린 시간의 길<1>")
                            .itemName("스태프 마력 주문서 60%")
                            .itemImageUrl("https://maplestory.io/api/gms/62/item/2043801/icon?resize=2")
                            .dropRate(0.004)
                            .build(),
                    MonsterDropItem.builder()
                            .mapName("시계탑최하층:뒤틀린 시간의 길<1>")
                            .itemName("완드 마력 주문서 60%")
                            .itemImageUrl("https://maplestory.io/api/gms/62/item/2043802/icon?resize=2")
                            .dropRate(0.004)
                            .build(),
                    MonsterDropItem.builder()
                            .mapName("시계탑최하층:뒤틀린 시간의 길<1>")
                            .itemName("레드 힌켈")
                            .itemImageUrl("https://maplestory.io/api/gms/62/item/1452009/icon?resize=2")
                            .dropRate(0.005)
                            .build(),

                    MonsterDropItem.builder()
                            .mapName("시계탑최하층:뒤틀린 시간의 길<1>")
                            .itemName("골드 마누트")
                            .itemImageUrl("https://maplestory.io/api/gms/62/item/1082087/icon?resize=2")
                            .dropRate(0.007)
                            .build(),
                    MonsterDropItem.builder()
                            .mapName("시계탑최하층:뒤틀린 시간의 길<1>")
                            .itemName("귀 장식 지력 주문서 60%")
                            .itemImageUrl("https://maplestory.io/api/gms/62/item/2040301/icon?resize=2")
                            .dropRate(0.004)
                            .build(),
                    MonsterDropItem.builder()
                            .mapName("시계탑최하층:뒤틀린 시간의 길<1>")
                            .itemName("네오코라")
                            .itemImageUrl("https://maplestory.io/api/gms/62/item/1302011/icon?resize=2")
                            .dropRate(0.006)
                            .build(),
                    MonsterDropItem.builder()
                            .mapName("시계탑최하층:뒤틀린 시간의 길<1>")
                            .itemName("미하일")
                            .itemImageUrl("https://maplestory.io/api/gms/62/item/1312010/icon?resize=2")
                            .dropRate(0.005)
                            .build(),
                    MonsterDropItem.builder()
                            .mapName("시계탑최하층:뒤틀린 시간의 길<1>")
                            .itemName("완드 마력 주문서 60%")
                            .itemImageUrl("https://maplestory.io/api/gms/62/item/2040301/icon?resize=2")
                            .dropRate(0.004)
                            .build()

            ));


            monsterDropItemRepository.saveAll(List.of(
                    MonsterDropItem.builder()
                            .mapName("시계탑최하층:뒤틀린 시간의 길<2>")
                            .itemName("전신 갑옷 힘 주문서 10%")
                            .itemImageUrl("https://maplestory.io/api/gms/62/item/2040534/icon?resize=2")
                            .dropRate(0.006)
                            .build(),
                    MonsterDropItem.builder()
                            .mapName("시계탑최하층:뒤틀린 시간의 길<2>")
                            .itemName("망토 힘 주문서 60%")
                            .itemImageUrl("https://maplestory.io/api/gms/62/item/2041013/icon?resize=2")
                            .dropRate(0.004)
                            .build(),
                    MonsterDropItem.builder()
                            .mapName("시계탑최하층:뒤틀린 시간의 길<2>")
                            .itemName("녹갑충")
                            .itemImageUrl("https://maplestory.io/api/gms/62/item/1472027/icon?resize=2")
                            .dropRate(0.006)
                            .build(),

                    MonsterDropItem.builder()
                            .mapName("시계탑최하층:뒤틀린 시간의 길<2>")
                            .itemName("흑갑충")
                            .itemImageUrl("https://maplestory.io/api/gms/62/item/1472029/icon?resize=2")
                            .dropRate(0.007)
                            .build(),
                    MonsterDropItem.builder()
                            .mapName("시계탑최하층:뒤틀린 시간의 길<2>")
                            .itemName("망토 힘 주문서 60%")
                            .itemImageUrl("https://maplestory.io/api/gms/62/item/2041013/icon?resize=2")
                            .dropRate(0.004)
                            .build(),
                    MonsterDropItem.builder()
                            .mapName("시계탑최하층:뒤틀린 시간의 길<2>")
                            .itemName("블루 힌켈")
                            .itemImageUrl("https://maplestory.io/api/gms/62/item/1452010/icon?resize=2")
                            .dropRate(0.006)
                            .build(),
                    MonsterDropItem.builder()
                            .mapName("시계탑최하층:뒤틀린 시간의 길<2>")
                            .itemName("황룡도")
                            .itemImageUrl("https://maplestory.io/api/gms/62/item/1442008/icon?resize=2")
                            .dropRate(0.006)
                            .build(),

                    MonsterDropItem.builder()
                            .mapName("시계탑최하층:뒤틀린 시간의 길<2>")
                            .itemName("망토 행운 주문서 60%")
                            .itemImageUrl("https://maplestory.io/api/gms/62/item/2041013/icon?resize=2")
                            .dropRate(0.004)
                            .build()

            ));

            monsterDropItemRepository.saveAll(List.of(
                    MonsterDropItem.builder()
                            .mapName("시계탑최하층:뒤틀린 시간의 길<3>")
                            .itemName("호진공창")
                            .itemImageUrl("https://maplestory.io/api/gms/62/item/1432010/icon?resize=2")
                            .dropRate(0.007)
                            .build(),
                    MonsterDropItem.builder()
                            .mapName("시계탑최하층:뒤틀린 시간의 길<3>")
                            .itemName("전신 갑옷 민첩 주문서 10%")
                            .itemImageUrl("https://maplestory.io/api/gms/62/item/2040502/icon?resize=2")
                            .dropRate(0.006)
                            .build(),
                    MonsterDropItem.builder()
                            .mapName("시계탑최하층:뒤틀린 시간의 길<3>")
                            .itemName("망토 행운 주문서 60%")
                            .itemImageUrl("https://maplestory.io/api/gms/62/item/2041022/icon?resize=2")
                            .dropRate(0.004)
                            .build(),

                    MonsterDropItem.builder()
                            .mapName("시계탑최하층:뒤틀린 시간의 길<3>")
                            .itemName("블루 배틀로드")
                            .itemImageUrl("https://maplestory.io/api/gms/62/item/1050082/icon?resize=2")
                            .dropRate(0.006)
                            .build(),
                    MonsterDropItem.builder()
                            .mapName("시계탑최하층:뒤틀린 시간의 길<3>")
                            .itemName("녹갑충")
                            .itemImageUrl("https://maplestory.io/api/gms/62/item/1472027/icon?resize=2")
                            .dropRate(0.004)
                            .build(),

                    MonsterDropItem.builder()
                            .mapName("시계탑최하층:뒤틀린 시간의 길<3>")
                            .itemName("골드 와이어스")
                            .itemImageUrl("https://maplestory.io/api/gms/62/item/1082097/icon?resize=2")
                            .dropRate(0.007)
                            .build(),
                    MonsterDropItem.builder()
                            .mapName("시계탑최하층:뒤틀린 시간의 길<3>")
                            .itemName("블루 힌켈")
                            .itemImageUrl("https://maplestory.io/api/gms/62/item/1452010/icon?resize=2")
                            .dropRate(0.006)
                            .build(),

                    MonsterDropItem.builder()
                            .mapName("시계탑최하층:뒤틀린 시간의 길<3>")
                            .itemName("파이어 살리트")
                            .itemImageUrl("https://maplestory.io/api/gms/62/item/1462011/icon?resize=2")
                            .dropRate(0.007)
                            .build()

            ));

            monsterDropItemRepository.saveAll(List.of(
                    MonsterDropItem.builder()
                            .mapName("시계탑최하층:뒤틀린 시간의 길<4>")
                            .itemName("일비 표창")
                            .itemImageUrl("https://maplestory.io/api/gms/62/item/2070006/icon?resize=2")
                            .dropRate(0.006)
                            .build(),
                    MonsterDropItem.builder()
                            .mapName("시계탑최하층:뒤틀린 시간의 길<4>")
                            .itemName("[마스터리북]닌자 앰부쉬 20")
                            .itemImageUrl("https://maplestory.io/api/gms/62/item/2290082/icon?resize=2")
                            .dropRate(0.006)
                            .build(),
                    MonsterDropItem.builder()
                            .mapName("시계탑최하층:뒤틀린 시간의 길<4>")
                            .itemName("석궁 공격력 주문서 10%")
                            .itemImageUrl("https://maplestory.io/api/gms/62/item/2044602/icon?resize=2")
                            .dropRate(0.004)
                            .build(),

                    MonsterDropItem.builder()
                            .mapName("시계탑최하층:뒤틀린 시간의 길<4>")
                            .itemName("다크 배틀로드")
                            .itemImageUrl("https://maplestory.io/api/gms/62/item/1050083/icon?resize=2")
                            .dropRate(0.008)
                            .build(),
                    MonsterDropItem.builder()
                            .mapName("시계탑최하층:뒤틀린 시간의 길<4>")
                            .itemName("블루 배틀엠프리스")
                            .itemImageUrl("https://maplestory.io/api/gms/62/item/1051079/icon?resize=2")
                            .dropRate(0.008)
                            .build(),

                    MonsterDropItem.builder()
                            .mapName("시계탑최하층:뒤틀린 시간의 길<4>")
                            .itemName("다크 크리시스")
                            .itemImageUrl("https://maplestory.io/api/gms/62/item/1050074/icon?resize=2")
                            .dropRate(0.008)
                            .build(),

                    MonsterDropItem.builder()
                            .mapName("시계탑최하층:뒤틀린 시간의 길<4>")
                            .itemName("그린 파쵸네")
                            .itemImageUrl("https://maplestory.io/api/gms/62/item/1082132/icon?resize=2")
                            .dropRate(0.007)
                            .build(),

                    MonsterDropItem.builder()
                            .mapName("시계탑최하층:뒤틀린 시간의 길<4>")
                            .itemName("호프만")
                            .itemImageUrl("https://maplestory.io/api/gms/62/item/1422010/icon?resize=2")
                            .dropRate(0.01)
                            .build()

            ));




            monsterDropItemRepository.saveAll(List.of(
                    MonsterDropItem.builder()
                            .mapName("시계탑최하층:금지된 시간")
                            .itemName("아대 공격력 주문서 10%")
                            .itemImageUrl("https://maplestory.io/api/gms/62/item/2044702/icon?resize=2")
                            .dropRate(0.006)
                            .build(),
                    MonsterDropItem.builder()
                            .mapName("시계탑최하층:금지된 시간")
                            .itemName("블러드 로버")
                            .itemImageUrl("https://maplestory.io/api/gms/62/item/1082120/icon?resize=2")
                            .dropRate(0.008)
                            .build(),
                    MonsterDropItem.builder()
                            .mapName("시계탑최하층:금지된 시간")
                            .itemName("다크 크리시아 슈즈")
                            .itemImageUrl("https://maplestory.io/api/gms/62/item/1072179/icon?resize=2")
                            .dropRate(0.008)
                            .build(),

                    MonsterDropItem.builder()
                            .mapName("시계탑최하층:금지된 시간")
                            .itemName("실버 에이전트 실드")
                            .itemImageUrl("https://maplestory.io/api/gms/62/item/1092016/icon?resize=2")
                            .dropRate(0.01)
                            .build(),
                    MonsterDropItem.builder()
                            .mapName("시계탑최하층:금지된 시간")
                            .itemName("퍼플 루크")
                            .itemImageUrl("https://maplestory.io/api/gms/62/item/1002283/icon?resize=2")
                            .dropRate(0.01)
                            .build(),

                    MonsterDropItem.builder()
                            .mapName("시계탑최하층:금지된 시간")
                            .itemName("크롬")
                            .itemImageUrl("https://maplestory.io/api/gms/62/item/1422012/icon?resize=2")
                            .dropRate(0.008)
                            .build(),

                    MonsterDropItem.builder()
                            .mapName("시계탑최하층:금지된 시간")
                            .itemName("마린 샬리트")
                            .itemImageUrl("https://maplestory.io/api/gms/62/item/1462010/icon?resize=2")
                            .dropRate(0.008)
                            .build(),

                    MonsterDropItem.builder()
                            .mapName("시계탑최하층:금지된 시간")
                            .itemName("블루 와이즈")
                            .itemImageUrl("https://maplestory.io/api/gms/62/item/1082122/icon?resize=2")
                            .dropRate(0.008)
                            .build()

            ));



            monsterDropItemRepository.saveAll(List.of(
                    MonsterDropItem.builder()
                            .mapName("시계탑최하층:사라진 시간")
                            .itemName("다크 크리시스")
                            .itemImageUrl("https://maplestory.io/api/gms/62/item/1050074/icon?resize=2")
                            .dropRate(0.008)
                            .build(),
                    MonsterDropItem.builder()
                            .mapName("시계탑최하층:사라진 시간")
                            .itemName("그린 배틀로드")
                            .itemImageUrl("https://maplestory.io/api/gms/62/item/1050080/icon?resize=2")
                            .dropRate(0.008)
                            .build(),
                    MonsterDropItem.builder()
                            .mapName("시계탑최하층:사라진 시간")
                            .itemName("다크 리버스 부츠")
                            .itemImageUrl("https://maplestory.io/api/gms/62/item/1072212/icon?resize=2")
                            .dropRate(0.008)
                            .build(),

                    MonsterDropItem.builder()
                            .mapName("시계탑최하층:사라진 시간")
                            .itemName("블루 키튼 서클렛")
                            .itemImageUrl("https://maplestory.io/api/gms/62/item/1002253/icon?resize=2")
                            .dropRate(0.01)
                            .build(),
                    MonsterDropItem.builder()
                            .mapName("시계탑최하층:사라진 시간")
                            .itemName("속박의 굴레")
                            .itemImageUrl("https://maplestory.io/api/gms/62/item/4000148/icon?resize=2")
                            .dropRate(40)
                            .build(),

                    MonsterDropItem.builder()
                            .mapName("시계탑최하층:사라진 시간")
                            .itemName("다크 크로스 햇")
                            .itemImageUrl("https://maplestory.io/api/gms/62/item/1002274/icon?resize=2")
                            .dropRate(0.008)
                            .build(),

                    MonsterDropItem.builder()
                            .mapName("시계탑최하층:사라진 시간")
                            .itemName("아츠")
                            .itemImageUrl("https://maplestory.io/api/gms/62/item/1302018/icon?resize=2")
                            .dropRate(0.008)
                            .build(),

                    MonsterDropItem.builder()
                            .mapName("시계탑최하층:사라진 시간")
                            .itemName("퍼플 카젠부츠")
                            .itemImageUrl("https://maplestory.io/api/gms/62/item/1072155/icon?resize=2")
                            .dropRate(0.01)
                            .build()

            ));


            monsterDropItemRepository.saveAll(List.of(
                    MonsterDropItem.builder()
                            .mapName("시계탑최하층:삐뚤어진 시간")
                            .itemName("뇌전 수리검")
                            .itemImageUrl("https://maplestory.io/api/gms/62/item/2070005/icon?resize=2")
                            .dropRate(0.008)
                            .build(),
                    MonsterDropItem.builder()
                            .mapName("시계탑최하층:삐뚤어진 시간")
                            .itemName("오리할콘 워 그루브")
                            .itemImageUrl("https://maplestory.io/api/gms/62/item/1072197/icon?resize=2")
                            .dropRate(0.007)
                            .build(),
                    MonsterDropItem.builder()
                            .mapName("시계탑최하층:삐뚤어진 시간")
                            .itemName("다크 레퀴엠")
                            .itemImageUrl("https://maplestory.io/api/gms/62/item/1050070/icon?resize=2")
                            .dropRate(0.01)
                            .build(),

                    MonsterDropItem.builder()
                            .mapName("시계탑최하층:삐뚤어진 시간")
                            .itemName("골든 힌켈")
                            .itemImageUrl("https://maplestory.io/api/gms/62/item/1452011/icon?resize=2")
                            .dropRate(0.01)
                            .build(),
                    MonsterDropItem.builder()
                            .mapName("시계탑최하층:삐뚤어진 시간")
                            .itemName("듀얼 파이렛의 추진기")
                            .itemImageUrl("https://maplestory.io/api/gms/62/item/4000133/icon?resize=2")
                            .dropRate(60)
                            .build(),

                    MonsterDropItem.builder()
                            .mapName("시계탑최하층:삐뚤어진 시간")
                            .itemName("다크 피레타 햇")
                            .itemImageUrl("https://maplestory.io/api/gms/62/item/1002330/icon?resize=2")
                            .dropRate(0.008)
                            .build(),

                    MonsterDropItem.builder()
                            .mapName("시계탑최하층:삐뚤어진 시간")
                            .itemName("그린 와이즈")
                            .itemImageUrl("https://maplestory.io/api/gms/62/item/1082121/icon?resize=2")
                            .dropRate(0.008)
                            .build(),


                    MonsterDropItem.builder()
                            .mapName("시계탑최하층:삐뚤어진 시간")
                            .itemName("메탈 하트 이어링")
                            .itemImageUrl("https://maplestory.io/api/gms/62/item/1032016/icon?resize=2")
                            .dropRate(0.008)
                            .build()

            ));



            monsterDropItemRepository.saveAll(List.of(
                    MonsterDropItem.builder()
                            .mapName("시계탑최하층:꼬여버린 시간")
                            .itemName("기간틱 바이킹의 모자")
                            .itemImageUrl("https://maplestory.io/api/gms/62/item/4000135/icon?resize=2")
                            .dropRate(60)
                            .build(),
                    MonsterDropItem.builder()
                            .mapName("시계탑최하층:꼬여버린 시간")
                            .itemName("차원의 균열 조각 A")
                            .itemImageUrl("https://maplestory.io/api/gms/62/item/4031176/icon?resize=2")
                            .dropRate(7)
                            .build(),
                    MonsterDropItem.builder()
                            .mapName("시계탑최하층:꼬여버린 시간")
                            .itemName("차원의 균열 조각 B")
                            .itemImageUrl("https://maplestory.io/api/gms/62/item/4031177/icon?resize=2")
                            .dropRate(1)
                            .build(),

                    MonsterDropItem.builder()
                            .mapName("시계탑최하층:꼬여버린 시간")
                            .itemName("차원의 균열 조각 B")
                            .itemImageUrl("https://maplestory.io/api/gms/62/item/4031178/icon?resize=2")
                            .dropRate(1)
                            .build(),
                    MonsterDropItem.builder()
                            .mapName("시계탑최하층:꼬여버린 시간")
                            .itemName("다크 크리시아")
                            .itemImageUrl("https://maplestory.io/api/gms/62/item/1051058/icon?resize=2")
                            .dropRate(0.01)
                            .build(),

                    MonsterDropItem.builder()
                            .mapName("시계탑최하층:꼬여버린 시간")
                            .itemName("다크 배틀엠프레스")
                            .itemImageUrl("https://maplestory.io/api/gms/62/item/1051080/icon?resize=2")
                            .dropRate(0.008)
                            .build(),

                    MonsterDropItem.builder()
                            .mapName("시계탑최하층:꼬여버린 시간")
                            .itemName("블루 아네스")
                            .itemImageUrl("https://maplestory.io/api/gms/62/item/1051083/icon?resize=2")
                            .dropRate(0.007)
                            .build(),

                    MonsterDropItem.builder()
                            .mapName("시계탑최하층:꼬여버린 시간")
                            .itemName("그레이트 로헨")
                            .itemImageUrl("https://maplestory.io/api/gms/62/item/1402015/icon?resize=2")
                            .dropRate(0.008)
                            .build()
            ));

            monsterDropItemRepository.saveAll(List.of(
                    MonsterDropItem.builder()
                            .mapName("루디브리엄성: 잃어버린시간<1>")
                            .itemName("에스터 실드")
                            .itemImageUrl("https://maplestory.io/api/gms/62/item/1092029/icon?resize=2")
                            .dropRate(0.008)
                            .build(),
                    MonsterDropItem.builder()
                            .mapName("루디브리엄성: 잃어버린시간<1>")
                            .itemName("장갑 공격력 주문서 60%")
                            .itemImageUrl("https://maplestory.io/api/gms/62/item/2040804/icon?resize=2")
                            .dropRate(0.004)
                            .build(),
                    MonsterDropItem.builder()
                            .mapName("루디브리엄성: 잃어버린시간<1>")
                            .itemName("장팔사모")
                            .itemImageUrl("https://maplestory.io/api/gms/62/item/1432004/icon?resize=2")
                            .dropRate(0.005)
                            .build(),

                    MonsterDropItem.builder()
                            .mapName("루디브리엄성: 잃어버린시간<1>")
                            .itemName("벅")
                            .itemImageUrl("https://maplestory.io/api/gms/62/item/1312008/icon?resize=2")
                            .dropRate(0.005)
                            .build(),
                    MonsterDropItem.builder()
                            .mapName("루디브리엄성: 잃어버린시간<1>")
                            .itemName("쟈드")
                            .itemImageUrl("https://maplestory.io/api/gms/62/item/1402007/icon?resize=2")
                            .dropRate(0.01)
                            .build(),
                    MonsterDropItem.builder()
                            .mapName("루디브리엄성: 잃어버린시간<1>")
                            .itemName("다크 클리브")
                            .itemImageUrl("https://maplestory.io/api/gms/62/item/1082074/icon?resize=2")
                            .dropRate(0.008)
                            .build(),
                    MonsterDropItem.builder()
                            .mapName("루디브리엄성: 잃어버린시간<1>")
                            .itemName("그린 매티")
                            .itemImageUrl("https://maplestory.io/api/gms/62/item/1002143/icon?resize=2")
                            .dropRate(0.01)
                            .build(),
                    MonsterDropItem.builder()
                            .mapName("루디브리엄성: 잃어버린시간<1>")
                            .itemName("레드 스타라이트")
                            .itemImageUrl("https://maplestory.io/api/gms/62/item/1050036/icon?resize=2")
                            .dropRate(0.01)
                            .build()
            ));


            monsterDropItemRepository.saveAll(List.of(
                    MonsterDropItem.builder()
                            .mapName("루디브리엄성: 잃어버린시간<2>")
                            .itemName("미스틱 실드")
                            .itemImageUrl("https://maplestory.io/api/gms/62/item/1092021/icon?resize=2")
                            .dropRate(0.008)
                            .build(),
                    MonsterDropItem.builder()
                            .mapName("루디브리엄성: 잃어버린시간<2>")
                            .itemName("완드 마력 주문서 10%")
                            .itemImageUrl("https://maplestory.io/api/gms/62/item/2043702/icon?resize=2")
                            .dropRate(0.004)
                            .build(),
                    MonsterDropItem.builder()
                            .mapName("루디브리엄성: 잃어버린시간<2>")
                            .itemName("다크 후르츠")
                            .itemImageUrl("https://maplestory.io/api/gms/62/item/1051006/icon?resize=2")
                            .dropRate(0.01)
                            .build(),

                    MonsterDropItem.builder()
                            .mapName("루디브리엄성: 잃어버린시간<2>")
                            .itemName("투구 민첩 주문서 60%")
                            .itemImageUrl("https://maplestory.io/api/gms/62/item/2044201/icon?resize=2")
                            .dropRate(0.006)
                            .build(),
                    MonsterDropItem.builder()
                            .mapName("루디브리엄성: 잃어버린시간<2>")
                            .itemName("블루 필퍼")
                            .itemImageUrl("https://maplestory.io/api/gms/62/item/1002182/icon?resize=2")
                            .dropRate(0.007)
                            .build(),
                    MonsterDropItem.builder()
                            .mapName("루디브리엄성: 잃어버린시간<2>")
                            .itemName("자진일갑주")
                            .itemImageUrl("https://maplestory.io/api/gms/62/item/1040085/icon?resize=2")
                            .dropRate(0.008)
                            .build(),
                    MonsterDropItem.builder()
                            .mapName("루디브리엄성: 잃어버린시간<2>")
                            .itemName("화이트 길티언")
                            .itemImageUrl("https://maplestory.io/api/gms/62/item/1002155/icon?resize=2")
                            .dropRate(0.007)
                            .build(),
                    MonsterDropItem.builder()
                            .mapName("루디브리엄성: 잃어버린시간<2>")
                            .itemName("백진일갑주 바지")
                            .itemImageUrl("https://maplestory.io/api/gms/62/item/1060074/icon?resize=2")
                            .dropRate(0.007)
                            .build()

            ));


            monsterDropItemRepository.saveAll(List.of(
                    MonsterDropItem.builder()
                            .mapName("루더스호수: 까막산 입구")
                            .itemName("투구 민첩 주문서 60%")
                            .itemImageUrl("https://maplestory.io/api/gms/62/item/2040029/icon?resize=2")
                            .dropRate(0.006)
                            .build(),

                    MonsterDropItem.builder()
                            .mapName("루더스호수: 까막산 입구")
                            .itemName("신발 점프력 주문서 10%")
                            .itemImageUrl("https://maplestory.io/api/gms/62/item/2040705/icon?resize=2")
                            .dropRate(0.006)
                            .build(),

                    MonsterDropItem.builder()
                            .mapName("루더스호수: 까막산 입구")
                            .itemName("노란색 우산")
                            .itemImageUrl("https://maplestory.io/api/gms/62/item/1302016/icon?resize=2")
                            .dropRate(0.008)
                            .build(),

                    MonsterDropItem.builder()
                            .mapName("루더스호수: 까막산 입구")
                            .itemName("목비 표창")
                            .itemImageUrl("https://maplestory.io/api/gms/62/item/2070002/icon?resize=2")
                            .dropRate(0.01)
                            .build(),

                    MonsterDropItem.builder()
                            .mapName("루더스호수: 까막산 입구")
                            .itemName("블루문")
                            .itemImageUrl("https://maplestory.io/api/gms/62/item/1032011/icon?resize=2")
                            .dropRate(0.01)
                            .build(),

                    MonsterDropItem.builder()
                            .mapName("루더스호수: 까막산 입구")
                            .itemName("골드 브레이스")
                            .itemImageUrl("https://maplestory.io/api/gms/62/item/1082072/icon?resize=2")
                            .dropRate(0.01)
                            .build(),

                    MonsterDropItem.builder()
                            .mapName("루더스호수: 까막산 입구")
                            .itemName("미스릴 티거")
                            .itemImageUrl("https://maplestory.io/api/gms/62/item/1072112/icon?resize=2")
                            .dropRate(0.01)
                            .build(),

                    MonsterDropItem.builder()
                            .mapName("루더스호수: 까막산 입구")
                            .itemName("파란색 모험가의 망토")
                            .itemImageUrl("https://maplestory.io/api/gms/62/item/1102001/icon?resize=2")
                            .dropRate(0.006)
                            .build()
            ));

            monsterDropItemRepository.saveAll(List.of(
                    MonsterDropItem.builder()
                            .mapName("루더스호수: 까막산 기슭")
                            .itemName("투구 민첩 주문서 60%")
                            .itemImageUrl("https://maplestory.io/api/gms/62/item/2040029/icon?resize=2")
                            .dropRate(0.006)
                            .build(),

                    MonsterDropItem.builder()
                            .mapName("루더스호수: 까막산 기슭")
                            .itemName("신발 점프력 주문서 10%")
                            .itemImageUrl("https://maplestory.io/api/gms/62/item/2040705/icon?resize=2")
                            .dropRate(0.006)
                            .build(),

                    MonsterDropItem.builder()
                            .mapName("루더스호수: 까막산 기슭")
                            .itemName("노란색 우산")
                            .itemImageUrl("https://maplestory.io/api/gms/62/item/1302016/icon?resize=2")
                            .dropRate(0.008)
                            .build(),

                    MonsterDropItem.builder()
                            .mapName("루더스호수: 까막산 기슭")
                            .itemName("장갑 공격력 주문서 60%")
                            .itemImageUrl("https://maplestory.io/api/gms/62/item/2040029/icon?resize=2")
                            .dropRate(0.006)
                            .build(),

                    MonsterDropItem.builder()
                            .mapName("루더스호수: 까막산 기슭")
                            .itemName("석궁 공격력 주문서 10%")
                            .itemImageUrl("https://maplestory.io/api/gms/62/item/2040705/icon?resize=2")
                            .dropRate(0.006)
                            .build(),

                    MonsterDropItem.builder()
                            .mapName("루더스호수: 까막산 기슭")
                            .itemName("너클메이스")
                            .itemImageUrl("https://maplestory.io/api/gms/62/item/1322017/icon?resize=2")
                            .dropRate(0.005)
                            .build(),

                    MonsterDropItem.builder()
                            .mapName("루더스호수: 까막산 기슭")
                            .itemName("미스릴 티거")
                            .itemImageUrl("https://maplestory.io/api/gms/62/item/1072112/icon?resize=2")
                            .dropRate(0.01)
                            .build(),

                    MonsterDropItem.builder()
                            .mapName("루더스호수: 까막산 기슭")
                            .itemName("파란색 모험가의 망토")
                            .itemImageUrl("https://maplestory.io/api/gms/62/item/1102001/icon?resize=2")
                            .dropRate(0.006)
                            .build()
            ));

            monsterDropItemRepository.saveAll(List.of(
                    MonsterDropItem.builder()
                            .mapName("루더스호수: 까막산 골짜기")
                            .itemName("망토 행운 주문서 10%")
                            .itemImageUrl("https://maplestory.io/api/gms/62/item/2041023/icon?resize=2")
                            .dropRate(0.006)
                            .build(),

                    MonsterDropItem.builder()
                            .mapName("루더스호수: 까막산 골짜기")
                            .itemName("토비 표창")
                            .itemImageUrl("https://maplestory.io/api/gms/62/item/2070004/icon?resize=2")
                            .dropRate(0.01)
                            .build(),

                    MonsterDropItem.builder()
                            .mapName("루더스호수: 까막산 골짜기")
                            .itemName("두손도끼 공격력 주문서 60%")
                            .itemImageUrl("https://maplestory.io/api/gms/62/item/2044201/icon?resize=2")
                            .dropRate(0.005)
                            .build(),

                    MonsterDropItem.builder()
                            .mapName("루더스호수: 까막산 골짜기")
                            .itemName("레드 아나카룬")
                            .itemImageUrl("https://maplestory.io/api/gms/62/item/1051045/icon?resize=2")
                            .dropRate(0.006)
                            .build(),

                    MonsterDropItem.builder()
                            .mapName("루더스호수: 까막산 골짜기")
                            .itemName("하이랜더")
                            .itemImageUrl("https://maplestory.io/api/gms/62/item/1402006/icon?resize=2")
                            .dropRate(0.01)
                            .build(),

                    MonsterDropItem.builder()
                            .mapName("루더스호수: 까막산 골짜기")
                            .itemName("타이탄")
                            .itemImageUrl("https://maplestory.io/api/gms/62/item/1422007/icon?resize=2")
                            .dropRate(0.01)
                            .build(),

                    MonsterDropItem.builder()
                            .mapName("루더스호수: 까막산 골짜기")
                            .itemName("청일 바지")
                            .itemImageUrl("https://maplestory.io/api/gms/62/item/1060084/icon?resize=2")
                            .dropRate(0.008)
                            .build(),

                    MonsterDropItem.builder()
                            .mapName("루더스호수: 까막산 골짜기")
                            .itemName("청일")
                            .itemImageUrl("https://maplestory.io/api/gms/62/item/1040095/icon?resize=2")
                            .dropRate(0.008)
                            .build()
            ));


            monsterDropItemRepository.saveAll(List.of(
                    MonsterDropItem.builder()
                            .mapName("시계탑최하층: 시간의 근원")
                            .itemName("귀 장식 민첩 주문서 10%")
                            .itemImageUrl("https://maplestory.io/api/gms/62/item/2040318/icon?resize=2")
                            .dropRate(0.2)
                            .build(),

                    MonsterDropItem.builder()
                            .mapName("시계탑최하층: 시간의 근원")
                            .itemName("귀 장식 행운 주문서 60%")
                            .itemImageUrl("https://maplestory.io/api/gms/62/item/2040321/icon?resize=2")
                            .dropRate(0.2)
                            .build(),

                    MonsterDropItem.builder()
                            .mapName("시계탑최하층: 시간의 근원")
                            .itemName("[마스터리 북] 브랜디쉬 30")
                            .itemImageUrl("https://maplestory.io/api/gms/62/item/2290011/icon?resize=2")
                            .dropRate(0.2)
                            .build(),

                    MonsterDropItem.builder()
                            .mapName("시계탑최하층: 시간의 근원")
                            .itemName("[마스터리 북] 스피릿 자벨린 30")
                            .itemImageUrl("https://maplestory.io/api/gms/62/item/2290011/icon?resize=2")
                            .dropRate(0.4)
                            .build(),

                    MonsterDropItem.builder()
                            .mapName("시계탑최하층: 시간의 근원")
                            .itemName("[마스터리 북] 부메랑 스텝 30")
                            .itemImageUrl("https://maplestory.io/api/gms/62/item/2290011/icon?resize=2")
                            .dropRate(0.4)
                            .build(),

                    MonsterDropItem.builder()
                            .mapName("시계탑최하층: 시간의 근원")
                            .itemName("[마스터리 북] 폭풍의 시 30")
                            .itemImageUrl("https://maplestory.io/api/gms/62/item/2290011/icon?resize=2")
                            .dropRate(0.5)
                            .build(),

                    MonsterDropItem.builder()
                            .mapName("시계탑최하층: 시간의 근원")
                            .itemName("[마스터리 북] 스탠스 20")
                            .itemImageUrl("https://maplestory.io/api/gms/62/item/2290011/icon?resize=2")
                            .dropRate(0.6)
                            .build(),

                    MonsterDropItem.builder()
                            .mapName("시계탑최하층: 시간의 근원")
                            .itemName("마기 코라스")
                            .itemImageUrl("https://maplestory.io/api/gms/62/item/1372009/icon?resize=2")
                            .dropRate(0.9)
                            .build()
            ));





        }
}
