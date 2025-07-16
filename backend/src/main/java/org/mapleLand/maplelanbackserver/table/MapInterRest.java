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
    private  int interestId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "maple_land_map_list_id")
    private MapleMap mapleMap;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
}
