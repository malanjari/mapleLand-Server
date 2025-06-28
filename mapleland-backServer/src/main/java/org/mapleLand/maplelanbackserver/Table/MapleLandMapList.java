package org.mapleLand.maplelanbackserver.Table;

import jakarta.persistence.*;
import lombok.*;
import org.mapleLand.maplelanbackserver.enumType.MapArea;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MapleLandMapList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer mapleLandMapListId;
    private String mapName;
    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private MapArea mapArea;
}
