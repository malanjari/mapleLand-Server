package org.mapleland.maplelanbackserver.table;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MapInterRest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int interestId; // 알람 테이블 PK
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "maple_land_map_list_id")
    private MapleMap mapleMap; // 메이플 사냥터 테이블
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user; // User 테이블
}
