package org.mapleLand.maplelanbackserver.Table;


import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.mapleLand.maplelanbackserver.enumType.MapArea;
import org.mapleLand.maplelanbackserver.enumType.TradeType;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity
public class UserMap {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userMapId;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private MapleJariUser mapleJariUser;
    @Column(length = 30)
    private String mapName;
    private Boolean isOccupied;
    private int price;
    @Enumerated(EnumType.STRING)
    private TradeType tradeType;
    private Boolean negotiationOption;
    @Enumerated(EnumType.STRING)
    private MapArea area;
    @CreationTimestamp
    @Column(updatable = false , columnDefinition = "DATETIME(0)")
    private LocalDateTime createTime;
    @Column(length = 60)
    private String comment;

}
