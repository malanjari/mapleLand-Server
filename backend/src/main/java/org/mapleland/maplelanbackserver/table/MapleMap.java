package org.mapleland.maplelanbackserver.table;

import jakarta.persistence.*;
import lombok.*;
import org.mapleland.maplelanbackserver.enumType.Region;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Builder
@ToString
public class MapleMap {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer mapleLandMapListId; // MapleMap PK
    private String mapName; // 맵 이름
    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private Region region; // 지역명 Leafre Elnath LudusLake Victoria 등
    private String subRegion; //지역 세분화 엘나스 -> 폐광/오르비스 루디브리엄 -> 시계탑 최하층 / 루디브리엄 성
    private String monsterImageUrl; // 몬스터 이미지 url
    private String miniMapImageUrl; // 미니맵 url
    private String miniMapImageLogoUrl; // 미니맵 이지미 로고 url

    public MapleMap() {

    }

    public void updateFrom(MapleMap other) {
        this.region = other.getRegion();
        this.subRegion = other.getSubRegion();
        this.monsterImageUrl = other.getMonsterImageUrl();
        this.miniMapImageUrl = other.getMiniMapImageUrl();
        this.miniMapImageLogoUrl = other.getMiniMapImageLogoUrl();
    }
}
