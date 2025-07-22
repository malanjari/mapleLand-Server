package org.mapleland.maplelanbackserver.table;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userId; //유저 테이블 pk
    private String userName; // 유저이름
    private String discordId; // discordId
    private String globalName; // 글로벌이름 예)미르
    private String role; // 권한
    private String email;//이메일
    private Boolean mapTicket;// 등록 여부 -> FALSE 등록불가 TRUE 등록가능
    private int pianusTicket;  // 사용 X
    private int manonTicket; // 사용 X
    private boolean isActive; // 계정 잠김 여부
    private String banedReason = ""; // 벤 사유
    private String image; // 유저 프로필 IMAGE
    @CreationTimestamp
    @Column(updatable = false , columnDefinition = "DATETIME(0)")
    private LocalDateTime createTime; // 만든날짜
    private int reportCount = 0;
    private LocalDateTime bannedHours;

    public void increaseReportCount() {
        this.reportCount++;
    }
}
