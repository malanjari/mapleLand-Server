package org.mapleland.maplelanbackserver.table;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class UserBan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int UserBanId; //유저벤 PK
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user; //유저테이블


}
