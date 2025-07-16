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
    private Integer mapleLandMapListId;
    private String mapName;
    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private Region region;
    private String subRegion;
    private String monsterImageUrl;
    private String miniMapImageUrl;
    private String miniMapImageLogoUrl;

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
