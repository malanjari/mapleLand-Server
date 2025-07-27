package org.mapleland.maplelanbackserver.init.monster;

import lombok.RequiredArgsConstructor;
import org.mapleland.maplelanbackserver.repository.MonsterDropItemRepository;
import org.mapleland.maplelanbackserver.table.MonsterDropItem;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class MuLungGardenMonsterDataInitializer {

    private final MonsterDropItemRepository monsterDropItemRepository;

    public void initMuLungGardMonsterData() {

        monsterDropItemRepository.saveAll(List.of(
                MonsterDropItem.builder()
                        .mapName("무릉도원: 하늘 숲 입구")
                        .itemName("주스팅")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1002023/icon?resize=2")
                        .dropRate(0.008)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("무릉도원: 하늘 숲 입구")
                        .itemName("핑크문 고깔모자")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1002103/icon?resize=2")
                        .dropRate(0.008)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("무릉도원: 하늘 숲 입구")
                        .itemName("실버메일")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1051016/icon?resize=2")
                        .dropRate(0.005)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("무릉도원: 하늘 숲 입구")
                        .itemName("블루 스타라이트")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1050038/icon?resize=2")
                        .dropRate(0.008)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("무릉도원: 하늘 숲 입구")
                        .itemName("블러디 멘티스")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1041095/icon?resize=2")
                        .dropRate(0.008)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("무릉도원: 하늘 숲 입구")
                        .itemName("펜지 이어링")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1032018/icon?resize=2")
                        .dropRate(0.005)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("무릉도원: 하늘 숲 입구")
                        .itemName("스틸 슬레인")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1472018/icon?resize=2")
                        .dropRate(0.005)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("무릉도원: 하늘 숲 입구")
                        .itemName("다크 문라이트")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1051026/icon?resize=2")
                        .dropRate(0.01)
                        .build()
                ));

        monsterDropItemRepository.saveAll(List.of(
                MonsterDropItem.builder()
                        .mapName("무릉도원: 하늘 숲 오솔길")
                        .itemName("주스팅")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1002023/icon?resize=2")
                        .dropRate(0.008)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("무릉도원: 하늘 숲 오솔길")
                        .itemName("핑크문 고깔모자")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1002103/icon?resize=2")
                        .dropRate(0.008)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("무릉도원: 하늘 숲 오솔길")
                        .itemName("실버메일")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1051016/icon?resize=2")
                        .dropRate(0.005)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("무릉도원: 하늘 숲 오솔길")
                        .itemName("블루 스타라이트")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1050038/icon?resize=2")
                        .dropRate(0.008)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("무릉도원: 하늘 숲 오솔길")
                        .itemName("블러디 멘티스")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1041095/icon?resize=2")
                        .dropRate(0.008)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("무릉도원: 하늘 숲 오솔길")
                        .itemName("펜지 이어링")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1032018/icon?resize=2")
                        .dropRate(0.005)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("무릉도원: 하늘 숲 오솔길")
                        .itemName("스틸 슬레인")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1472018/icon?resize=2")
                        .dropRate(0.005)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("무릉도원: 하늘 숲 오솔길")
                        .itemName("다크 문라이트")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1051026/icon?resize=2")
                        .dropRate(0.01)
                        .build()
        ));

        monsterDropItemRepository.saveAll(List.of(
                MonsterDropItem.builder()
                        .mapName("무릉도원: 하늘 숲 깊은 곳")
                        .itemName("활 공격력 주문서 60%")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2044501/icon?resize=2")
                        .dropRate(0.004)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("무릉도원: 하늘 숲 깊은 곳")
                        .itemName("에메랄드 돔")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1002024/icon?resize=2")
                        .dropRate(0.006)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("무릉도원: 하늘 숲 깊은 곳")
                        .itemName("올림푸스")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1452008/icon?resize=2")
                        .dropRate(0.008)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("무릉도원: 하늘 숲 깊은 곳")
                        .itemName("목비 표창")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2070002/icon?resize=2")
                        .dropRate(0.01)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("무릉도원: 하늘 숲 깊은 곳")
                        .itemName("블루 하프슈즈")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1072110/icon?resize=2")
                        .dropRate(0.01)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("무릉도원: 하늘 숲 깊은 곳")
                        .itemName("펜지 이어링")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1032018/icon?resize=2")
                        .dropRate(0.005)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("무릉도원: 하늘 숲 깊은 곳")
                        .itemName("스틸 슬레인")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1472018/icon?resize=2")
                        .dropRate(0.005)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("무릉도원: 하늘 숲 깊은 곳")
                        .itemName("다크 문라이트")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1051026/icon?resize=2")
                        .dropRate(0.01)
                        .build()
        ));

        monsterDropItemRepository.saveAll(List.of(
                MonsterDropItem.builder()
                        .mapName("무릉도원: 하늘 숲이 끝나는 곳")
                        .itemName("신발 점프력 주문서 10%")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2040705/icon?resize=2")
                        .dropRate(0.006)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("무릉도원: 하늘 숲이 끝나는 곳")
                        .itemName("캣츠 아이")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1032008/icon?resize=2")
                        .dropRate(0.007)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("무릉도원: 하늘 숲이 끝나는 곳")
                        .itemName("아크 스태프")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1382001/icon?resize=2")
                        .dropRate(0.007)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("무릉도원: 하늘 숲이 끝나는 곳")
                        .itemName("두손 검 공격력 주문서 10%")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2044002/icon?resize=2")
                        .dropRate(0.004)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("무릉도원: 하늘 숲이 끝나는 곳")
                        .itemName("자월")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1041077/icon?resize=2")
                        .dropRate(0.01)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("무릉도원: 하늘 숲이 끝나는 곳")
                        .itemName("펜지 이어링")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1032018/icon?resize=2")
                        .dropRate(0.005)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("무릉도원: 하늘 숲이 끝나는 곳")
                        .itemName("미스릴 크루세이더 헬름")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1002085/icon?resize=2")
                        .dropRate(0.01)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("무릉도원: 하늘 숲이 끝나는 곳")
                        .itemName("미스릴 브리스트")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1082010/icon?resize=2")
                        .dropRate(0.01)
                        .build()
        ));

        monsterDropItemRepository.saveAll(List.of(
                MonsterDropItem.builder()
                        .mapName("무릉도원: 야생곰의 영토1")
                        .itemName("스태프 마력 주문서 60%")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2043801/icon?resize=2")
                        .dropRate(0.008)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("무릉도원: 야생곰의 영토1")
                        .itemName("완드 마력 주문서 60%")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2043801/icon?resize=2")
                        .dropRate(0.006)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("무릉도원: 야생곰의 영토1")
                        .itemName("황월 장갑")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1082066/icon?resize=2")
                        .dropRate(0.01)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("무릉도원: 야생곰의 영토1")
                        .itemName("홀리 크로스링")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1032021/icon?resize=2")
                        .dropRate(0.07)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("무릉도원: 야생곰의 영토1")
                        .itemName("주자로")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1050058/icon?resize=2")
                        .dropRate(0.005)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("무릉도원: 야생곰의 영토1")
                        .itemName("십자창")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1432006/icon?resize=2")
                        .dropRate(0.008)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("무릉도원: 야생곰의 영토1")
                        .itemName("레드 페넌스")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1082081/icon?resize=2")
                        .dropRate(0.01)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("무릉도원: 야생곰의 영토1")
                        .itemName("오커 스콜피오")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1040099/icon?resize=2")
                        .dropRate(0.005)
                        .build()
                ));



        monsterDropItemRepository.saveAll(List.of(
                MonsterDropItem.builder()
                        .mapName("무릉도원: 야생곰의 영토2")
                        .itemName("뇌전 수리검")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2070005/icon?resize=2")
                        .dropRate(0.006)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("무릉도원: 야생곰의 영토2")
                        .itemName("다크 아나카룬")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1050056/icon?resize=2")
                        .dropRate(0.007)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("무릉도원: 야생곰의 영토2")
                        .itemName("황월 장갑")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1082066/icon?resize=2")
                        .dropRate(0.01)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("무릉도원: 야생곰의 영토2")
                        .itemName("홀리 크로스링")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1032021/icon?resize=2")
                        .dropRate(0.07)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("무릉도원: 야생곰의 영토2")
                        .itemName("주자로")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1050058/icon?resize=2")
                        .dropRate(0.005)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("무릉도원: 야생곰의 영토2")
                        .itemName("십자창")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1432006/icon?resize=2")
                        .dropRate(0.008)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("무릉도원: 야생곰의 영토2")
                        .itemName("레드 페넌스")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1082081/icon?resize=2")
                        .dropRate(0.01)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("무릉도원: 야생곰의 영토2")
                        .itemName("오커 스콜피오")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1040099/icon?resize=2")
                        .dropRate(0.005)
                        .build()
        ));


        monsterDropItemRepository.saveAll(List.of(
                MonsterDropItem.builder()
                        .mapName("무릉도원: 야생곰의 영토3")
                        .itemName("뇌전 수리검")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2070005/icon?resize=2")
                        .dropRate(0.006)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("무릉도원: 야생곰의 영토3")
                        .itemName("다크 아나카룬")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1050056/icon?resize=2")
                        .dropRate(0.007)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("무릉도원: 야생곰의 영토3")
                        .itemName("황월 장갑")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1082066/icon?resize=2")
                        .dropRate(0.01)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("무릉도원: 야생곰의 영토3")
                        .itemName("홀리 크로스링")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1032021/icon?resize=2")
                        .dropRate(0.07)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("무릉도원: 야생곰의 영토3")
                        .itemName("주자로")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1050058/icon?resize=2")
                        .dropRate(0.005)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("무릉도원: 야생곰의 영토3")
                        .itemName("십자창")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1432006/icon?resize=2")
                        .dropRate(0.008)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("무릉도원: 야생곰의 영토3")
                        .itemName("레드 페넌스")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1082081/icon?resize=2")
                        .dropRate(0.01)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("무릉도원: 야생곰의 영토3")
                        .itemName("오커 스콜피오")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1040099/icon?resize=2")
                        .dropRate(0.005)
                        .build()
        ));


        monsterDropItemRepository.saveAll(List.of(
                MonsterDropItem.builder()
                        .mapName("무릉도원: 떠돌이곰의 영토")
                        .itemName("스태프 마력 주문서 60%")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2043801/icon?resize=2")
                        .dropRate(0.008)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("무릉도원: 떠돌이곰의 영토")
                        .itemName("완드 마력 주문서 60%")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2043801/icon?resize=2")
                        .dropRate(0.006)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("무릉도원: 떠돌이곰의 영토")
                        .itemName("황월 장갑")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1082066/icon?resize=2")
                        .dropRate(0.01)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("무릉도원: 떠돌이곰의 영토")
                        .itemName("홀리 크로스링")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1032021/icon?resize=2")
                        .dropRate(0.07)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("무릉도원: 떠돌이곰의 영토")
                        .itemName("주자로")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1050058/icon?resize=2")
                        .dropRate(0.005)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("무릉도원: 떠돌이곰의 영토")
                        .itemName("십자창")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1432006/icon?resize=2")
                        .dropRate(0.008)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("무릉도원: 떠돌이곰의 영토")
                        .itemName("레드 페넌스")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1082081/icon?resize=2")
                        .dropRate(0.01)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("무릉도원: 떠돌이곰의 영토")
                        .itemName("오커 스콜피오")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1040099/icon?resize=2")
                        .dropRate(0.005)
                        .build()
        ));


        monsterDropItemRepository.saveAll(List.of(
                MonsterDropItem.builder()
                        .mapName("무릉도원: 안개 낀 숲")
                        .itemName("귀 장식 민첩 주문서 60%")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2044201/icon?resize=2")
                        .dropRate(0.006)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("무릉도원: 안개 낀 숲")
                        .itemName("두손 도끼 공격력 주문서 60%")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2044201/icon?resize=2")
                        .dropRate(0.006)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("무릉도원: 안개 낀 숲")
                        .itemName("청월")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1040095/icon?resize=2")
                        .dropRate(0.005)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("무릉도원: 안개 낀 숲")
                        .itemName("봉황위궁")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1452004/icon?resize=2")
                        .dropRate(0.006)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("무릉도원: 안개 낀 숲")
                        .itemName("방천극")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1442010/icon?resize=2")
                        .dropRate(0.008)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("무릉도원: 안개 낀 숲")
                        .itemName("하이랜더")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1402006/icon?resize=2")
                        .dropRate(0.01)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("무릉도원: 안개 낀 숲")
                        .itemName("장갑 공격력 주문서 60%")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2040804/icon?resize=2")
                        .dropRate(0.006)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("무릉도원: 안개 낀 숲")
                        .itemName("황월 장갑")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1082066/icon?resize=2")
                        .dropRate(0.01)
                        .build()
        ));


        monsterDropItemRepository.saveAll(List.of(
                MonsterDropItem.builder()
                        .mapName("무릉도원: 선인의 숲")
                        .itemName("귀 장식 지력 주문서 60%")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2044201/icon?resize=2")
                        .dropRate(0.006)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("무릉도원: 선인의 숲")
                        .itemName("금강저")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1332019/icon?resize=2")
                        .dropRate(0.006)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("무릉도원: 선인의 숲")
                        .itemName("스틸 에이션트 실드")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1092015/icon?resize=2")
                        .dropRate(0.006)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("무릉도원: 선인의 숲")
                        .itemName("분홍꽃 귀걸이")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1032014/icon?resize=2")
                        .dropRate(0.007)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("무릉도원: 선인의 숲")
                        .itemName("황일바지")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1060085/icon?resize=2")
                        .dropRate(0.01)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("무릉도원: 선인의 숲")
                        .itemName("황일")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1040096/icon?resize=2")
                        .dropRate(0.01)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("무릉도원: 선인의 숲")
                        .itemName("귀 장식 민첩 주문서 60%")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2044201/icon?resize=2")
                        .dropRate(0.006)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("무릉도원: 선인의 숲")
                        .itemName("황월 장갑")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1082066/icon?resize=2")
                        .dropRate(0.01)
                        .build()
        ));


        monsterDropItemRepository.saveAll(List.of(
                MonsterDropItem.builder()
                        .mapName("무릉도원: 요괴의 숲")
                        .itemName("귀 장식 지력 주문서 60%")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2044201/icon?resize=2")
                        .dropRate(0.006)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("무릉도원: 요괴의 숲")
                        .itemName("금강저")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1332019/icon?resize=2")
                        .dropRate(0.006)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("무릉도원: 요괴의 숲")
                        .itemName("스틸 에이션트 실드")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1092015/icon?resize=2")
                        .dropRate(0.006)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("무릉도원: 요괴의 숲")
                        .itemName("분홍꽃 귀걸이")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1032014/icon?resize=2")
                        .dropRate(0.007)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("무릉도원: 요괴의 숲")
                        .itemName("황일바지")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1060085/icon?resize=2")
                        .dropRate(0.01)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("무릉도원: 요괴의 숲")
                        .itemName("황일")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1040096/icon?resize=2")
                        .dropRate(0.01)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("무릉도원: 요괴의 숲")
                        .itemName("귀 장식 민첩 주문서 60%")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2044201/icon?resize=2")
                        .dropRate(0.006)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("무릉도원: 요괴의 숲")
                        .itemName("황월 장갑")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1082066/icon?resize=2")
                        .dropRate(0.01)
                        .build()
        ));

        monsterDropItemRepository.saveAll(List.of(
                MonsterDropItem.builder()
                        .mapName("히든스트리트: 요괴의 숲2")
                        .itemName("귀 장식 지력 주문서 60%")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2044201/icon?resize=2")
                        .dropRate(0.006)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("히든스트리트: 요괴의 숲2")
                        .itemName("금강저")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1332019/icon?resize=2")
                        .dropRate(0.006)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("히든스트리트: 요괴의 숲2")
                        .itemName("스틸 에이션트 실드")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1092015/icon?resize=2")
                        .dropRate(0.006)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("히든스트리트: 요괴의 숲2")
                        .itemName("분홍꽃 귀걸이")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1032014/icon?resize=2")
                        .dropRate(0.007)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("히든스트리트: 요괴의 숲2")
                        .itemName("황일바지")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1060085/icon?resize=2")
                        .dropRate(0.01)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("히든스트리트: 요괴의 숲2")
                        .itemName("황일")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1040096/icon?resize=2")
                        .dropRate(0.01)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("히든스트리트: 요괴의 숲2")
                        .itemName("고양이 인형")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/4000289/icon?resize=2")
                        .dropRate(50)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("히든스트리트: 요괴의 숲2")
                        .itemName("엘릭서")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2000004/icon?resize=2")
                        .dropRate(0.1)
                        .build()
        ));


        monsterDropItemRepository.saveAll(List.of(
                MonsterDropItem.builder()
                        .mapName("무릉도원: 천도 과수원1")
                        .itemName("완드 마력 주문서 60%")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2043701/icon?resize=2")
                        .dropRate(0.004)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("무릉도원: 천도 과수원1")
                        .itemName("레드 피라테")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1040109/icon?resize=2")
                        .dropRate(0.006)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("무릉도원: 천도 과수원1")
                        .itemName("올림푸스")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1452008/icon?resize=2")
                        .dropRate(0.008)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("무릉도원: 천도 과수원1")
                        .itemName("화이트 아나카룬")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1051046/icon?resize=2")
                        .dropRate(0.007)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("무릉도원: 천도 과수원1")
                        .itemName("장갑 공격력 주문서 60%")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2043701/icon?resize=2")
                        .dropRate(0.006)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("무릉도원: 천도 과수원1")
                        .itemName("백궁우")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1002269/icon?resize=2")
                        .dropRate(0.005)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("무릉도원: 천도 과수원1")
                        .itemName("자월")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1041077/icon?resize=2")
                        .dropRate(0.01)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("무릉도원: 천도 과수원1")
                        .itemName("블루 루이마리")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1051037/icon?resize=2")
                        .dropRate(0.01)
                        .build()
        ));

        monsterDropItemRepository.saveAll(List.of(
                MonsterDropItem.builder()
                        .mapName("무릉도원: 천도 과수원2")
                        .itemName("완드 마력 주문서 60%")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2043701/icon?resize=2")
                        .dropRate(0.004)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("무릉도원: 천도 과수원2")
                        .itemName("레드 피라테")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1040109/icon?resize=2")
                        .dropRate(0.006)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("무릉도원: 천도 과수원2")
                        .itemName("올림푸스")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1452008/icon?resize=2")
                        .dropRate(0.008)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("무릉도원: 천도 과수원2")
                        .itemName("화이트 아나카룬")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1051046/icon?resize=2")
                        .dropRate(0.007)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("무릉도원: 천도 과수원2")
                        .itemName("장갑 공격력 주문서 60%")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2043701/icon?resize=2")
                        .dropRate(0.006)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("무릉도원: 천도 과수원2")
                        .itemName("백궁우")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1002269/icon?resize=2")
                        .dropRate(0.005)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("무릉도원: 천도 과수원2")
                        .itemName("자월")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1041077/icon?resize=2")
                        .dropRate(0.01)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("무릉도원: 천도 과수원2")
                        .itemName("블루 루이마리")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1051037/icon?resize=2")
                        .dropRate(0.01)
                        .build()
        ));

        monsterDropItemRepository.saveAll(List.of(
                MonsterDropItem.builder()
                        .mapName("무릉도원: 천도 과수원3")
                        .itemName("완드 마력 주문서 60%")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2043701/icon?resize=2")
                        .dropRate(0.004)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("무릉도원: 천도 과수원3")
                        .itemName("레드 피라테")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1040109/icon?resize=2")
                        .dropRate(0.006)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("무릉도원: 천도 과수원3")
                        .itemName("올림푸스")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1452008/icon?resize=2")
                        .dropRate(0.008)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("무릉도원: 천도 과수원3")
                        .itemName("화이트 아나카룬")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1051046/icon?resize=2")
                        .dropRate(0.007)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("무릉도원: 천도 과수원3")
                        .itemName("장갑 공격력 주문서 60%")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2043701/icon?resize=2")
                        .dropRate(0.006)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("무릉도원: 천도 과수원3")
                        .itemName("백궁우")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1002269/icon?resize=2")
                        .dropRate(0.005)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("무릉도원: 천도 과수원3")
                        .itemName("자월")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1041077/icon?resize=2")
                        .dropRate(0.01)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("무릉도원: 천도 과수원3")
                        .itemName("블루 루이마리")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1051037/icon?resize=2")
                        .dropRate(0.01)
                        .build()
        ));


                     // ---------------------- 백초마을 --------------------------------

                    // -------------------------------------------------------------------

        monsterDropItemRepository.saveAll(List.of(
                MonsterDropItem.builder()
                        .mapName("무릉도원: 빨간코 해적단 소굴1")
                        .itemName("청갑충")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1472028/icon?resize=2")
                        .dropRate(0.008)
                        .build(),


                MonsterDropItem.builder()
                        .mapName("무릉도원: 빨간코 해적단 소굴1")
                        .itemName("신발 점프력 주문서 10%")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2040002/icon?resize=2")
                        .dropRate(0.004)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("무릉도원: 빨간코 해적단 소굴1")
                        .itemName("호프만")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1422010/icon?resize=2")
                        .dropRate(0.008)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("무릉도원: 빨간코 해적단 소굴1")
                        .itemName("녹갑충")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1472027/icon?resize=2")
                        .dropRate(0.006)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("무릉도원: 빨간코 해적단 소굴1")
                        .itemName("메탈 실버이어링")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1032015/icon?resize=2")
                        .dropRate(0.008)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("무릉도원: 빨간코 해적단 소굴1")
                        .itemName("골든 크로우")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1462008/icon?resize=2")
                        .dropRate(0.006)
                        .build(),


                MonsterDropItem.builder()
                        .mapName("무릉도원: 빨간코 해적단 소굴1")
                        .itemName("단검 공격력 주문서 10%")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2043302/icon?resize=2")
                        .dropRate(0.004)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("무릉도원: 빨간코 해적단 소굴1")
                        .itemName("귀 장식 지력 주문서 60%")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2040301/icon?resize=2")
                        .dropRate(0.004)
                        .build()

                ));

        monsterDropItemRepository.saveAll(List.of(
                MonsterDropItem.builder()
                        .mapName("무릉도원: 빨간코 해적단 소굴2")
                        .itemName("청갑충")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1472028/icon?resize=2")
                        .dropRate(0.008)
                        .build(),


                MonsterDropItem.builder()
                        .mapName("무릉도원: 빨간코 해적단 소굴2")
                        .itemName("신발 점프력 주문서 10%")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2040002/icon?resize=2")
                        .dropRate(0.004)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("무릉도원: 빨간코 해적단 소굴2")
                        .itemName("호프만")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1422010/icon?resize=2")
                        .dropRate(0.008)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("무릉도원: 빨간코 해적단 소굴2")
                        .itemName("녹갑충")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1472027/icon?resize=2")
                        .dropRate(0.006)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("무릉도원: 빨간코 해적단 소굴2")
                        .itemName("메탈 실버이어링")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1032015/icon?resize=2")
                        .dropRate(0.008)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("무릉도원: 빨간코 해적단 소굴2")
                        .itemName("골든 크로우")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1462008/icon?resize=2")
                        .dropRate(0.006)
                        .build(),


                MonsterDropItem.builder()
                        .mapName("무릉도원: 빨간코 해적단 소굴2")
                        .itemName("단검 공격력 주문서 10%")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2043302/icon?resize=2")
                        .dropRate(0.004)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("무릉도원: 빨간코 해적단 소굴2")
                        .itemName("레드 배틀로드")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1050081/icon?resize=2")
                        .dropRate(0.008)
                        .build()

        ));


        monsterDropItemRepository.saveAll(List.of(
                MonsterDropItem.builder()
                        .mapName("무릉도원: 빨간코 해적단 소굴3")
                        .itemName("청갑충")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1472028/icon?resize=2")
                        .dropRate(0.008)
                        .build(),


                MonsterDropItem.builder()
                        .mapName("무릉도원: 빨간코 해적단 소굴3")
                        .itemName("신발 점프력 주문서 10%")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2040002/icon?resize=2")
                        .dropRate(0.004)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("무릉도원: 빨간코 해적단 소굴3")
                        .itemName("호프만")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1422010/icon?resize=2")
                        .dropRate(0.008)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("무릉도원: 빨간코 해적단 소굴3")
                        .itemName("녹갑충")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1472027/icon?resize=2")
                        .dropRate(0.006)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("무릉도원: 빨간코 해적단 소굴3")
                        .itemName("메탈 실버이어링")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1032015/icon?resize=2")
                        .dropRate(0.008)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("무릉도원: 빨간코 해적단 소굴3")
                        .itemName("골든 크로우")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1462008/icon?resize=2")
                        .dropRate(0.006)
                        .build(),


                MonsterDropItem.builder()
                        .mapName("무릉도원: 빨간코 해적단 소굴3")
                        .itemName("단검 공격력 주문서 10%")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/2043302/icon?resize=2")
                        .dropRate(0.004)
                        .build(),

                MonsterDropItem.builder()
                        .mapName("무릉도원: 빨간코 해적단 소굴3")
                        .itemName("레드 배틀로드")
                        .itemImageUrl("https://maplestory.io/api/gms/62/item/1050081/icon?resize=2")
                        .dropRate(0.008)
                        .build()

        ));

    }
}
