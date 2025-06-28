package org.mapleLand.maplelanbackserver.Table;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer reportId;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private MapleJariUser mapleJariUser;
    private int reportCount;
    @Column(length = 60)
    private String comment;
}
