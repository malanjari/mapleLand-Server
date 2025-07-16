package org.mapleland.maplelanbackserver.table;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.mapleland.maplelanbackserver.enumType.Region;
import org.mapleland.maplelanbackserver.enumType.TradeType;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Deprecated
public class Pianus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pianusId;
    @ManyToOne
    @JoinColumn(name ="user_id")
    private User user;

    private Boolean isOccupied;

    @Column(length = 60)
    private String comment;

    private int price;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private Region area;

    @CreationTimestamp
    @Column(updatable = false , columnDefinition = "DATETIME(0)")
    private LocalDateTime createTime;

    @Enumerated(EnumType.STRING)
    @Column(length = 10)
    private TradeType tradeType;

    private String image;

}
