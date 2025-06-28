package org.mapleLand.maplelanbackserver.Table;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.mapleLand.maplelanbackserver.enumType.MapArea;
import org.mapleLand.maplelanbackserver.enumType.TradeType;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pianus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pianusId;
    @ManyToOne
    @JoinColumn(name ="user_id")
    private MapleJariUser mapleJariUser;

    private Boolean isOccupied;

    @Column(length = 60)
    private String comment;

    private int price;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private MapArea area;

    @CreationTimestamp
    @Column(updatable = false , columnDefinition = "DATETIME(0)")
    private LocalDateTime createTime;

    @Enumerated(EnumType.STRING)
    @Column(length = 10)
    private TradeType tradeType;

    private String image;

}
