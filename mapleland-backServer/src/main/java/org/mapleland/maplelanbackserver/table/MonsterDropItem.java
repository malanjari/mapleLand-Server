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

    private String mapName;

    private String itemName;

    private String itemImageUrl; // optional
    private double dropRate;


    public MonsterDropItem() {

    }
}
