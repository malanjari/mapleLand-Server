package org.mapleLand.maplelanbackserver.table;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MapInterestEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int interestId;
    private String mapName;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private MapleJariUserEntity mapleJariUserEntity;
}
