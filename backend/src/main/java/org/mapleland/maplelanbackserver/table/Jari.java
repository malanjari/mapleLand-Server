package org.mapleland.maplelanbackserver.table;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.mapleland.maplelanbackserver.enumType.Region;
import org.mapleland.maplelanbackserver.enumType.TradeType;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Builder
@Setter
@AllArgsConstructor
public class Jari {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userMapId; //PK userMapId 사용자가 등록한 자리 pk

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user; // user 테이블 FK

    @Column(length = 30)
    private String mapName; // 맵 네임 : 남겨진 용의 둥지 , 죽은 용의 둥지 등..

    private String serverColor; // 서버 색깔 : 초채 노채 빨채등

    private int price; // 가격

    @Enumerated(EnumType.STRING)
    private TradeType tradeType; // BUY SELL

    private Boolean negotiationOption; // 흥정 여부 : 가능 , 불가능

    @Enumerated(EnumType.STRING)
    @Column(length = 30)  //
    private Region area; // 지역명 Leafre Elnath Aquarium , LudusLake

    @CreationTimestamp
    @Column(columnDefinition = "DATETIME(0)")
    private LocalDateTime createTime; // 만든 날짜

    @Column(length = 60)
    private String comment; // 유저 코멘트

    private String monsterImageUrl; // 몬스터 이미지

    private Boolean isCompleted; // 거래 완료 여부

    @OneToMany(mappedBy = "jari", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Report> reports;

    public Jari() {

    }

    public void bump(LocalDateTime now) {
        this.createTime = now;
    }

    public boolean validateOwner(Integer userId) {
        return this.user.getUserId().equals(userId);
    }
}
