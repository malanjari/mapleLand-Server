package org.mapleland.maplelanbackserver.table;

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
    private Integer reportId; // 신고 테이블 pk
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user; // 유저 테이블
    private int reportCount; // 신고 횟수(당한 횟수)
    @Column(length = 60)
    private String comment; // 사유
}
