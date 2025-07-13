package org.mapleLand.maplelanbackserver.table;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class UserBanEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int UserBanId;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private MapleJariUserEntity mapleJariUserEntity;


}
