package org.mapleLand.maplelanbackserver.table;

import jakarta.persistence.*;
import lombok.*;
import org.mapleLand.maplelanbackserver.enumType.Region;
import org.mapleLand.maplelanbackserver.enumType.victoria.VictoriaLoadRegion;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Builder
public class MapleLandMapListEntity {

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

    public MapleLandMapListEntity() {

    }

    public void updateFrom(MapleLandMapListEntity other) {
        this.region = other.getRegion();
        this.subRegion = other.getSubRegion();
        this.monsterImageUrl = other.getMonsterImageUrl();
        this.miniMapImageUrl = other.getMiniMapImageUrl();
        this.miniMapImageLogoUrl = other.getMiniMapImageLogoUrl();
    }
}
