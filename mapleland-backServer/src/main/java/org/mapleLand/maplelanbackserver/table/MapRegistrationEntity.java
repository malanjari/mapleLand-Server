package org.mapleLand.maplelanbackserver.table;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.mapleLand.maplelanbackserver.enumType.Region;
import org.mapleLand.maplelanbackserver.enumType.TradeType;

import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@Builder
@AllArgsConstructor
public class MapRegistrationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userMapId;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private MapleJariUserEntity mapleJariUserEntity;
    @Column(length = 30)
    private String mapName;
    private String serverColor;
    private int price;
    @Enumerated(EnumType.STRING)
    private TradeType tradeType;
    private Boolean negotiationOption;
    @Enumerated(EnumType.STRING)
    @Column(length = 30)  // 최소 20 이상이면 안전
    private Region area;
    @CreationTimestamp
    @Column(updatable = false , columnDefinition = "DATETIME(0)")
    private LocalDateTime createTime;
    @Column(length = 60)
    private String comment;
    private String monsterImageUrl;
    private Boolean isCompleted;

    public MapRegistrationEntity() {

    }
}
