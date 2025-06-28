package org.mapleLand.maplelanbackserver.Table;

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
public class MapleJariUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userId;
    private String userName;
    private String discordId;
    private String globalName;
    private String role;
    private String email;
    private Boolean mapTicket;
    private int pianusTicket;
    private int manonTicket;
    private int userReportCount;
    private String image;
    @CreationTimestamp
    @Column(updatable = false , columnDefinition = "DATETIME(0)")
    private LocalDateTime createTime;
}
