package org.mapleland.maplelanbackserver.table;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
public class MonsterDropItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String mapName; // 지역명

    private String itemName; // 드랍 아이템명

    private String itemImageUrl; // 아이템 이미지
    private double dropRate; // 드랍 확률


    public MonsterDropItem() {

    }
}
