package org.mapleland.maplelanbackserver.repository;

import org.mapleland.maplelanbackserver.dto.response.ResponseBannedUserDto;
import org.mapleland.maplelanbackserver.table.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {


    Optional<User> findByDiscordId(String discordId);


    Optional<User> findByUserId(int userId);

    Page<User> findAllByOrderByReportCountDesc(Pageable pageable); // 신고 횟수 역순 정렬

    @Query("""
    SELECT FUNCTION('DATE', u.createTime), COUNT(u)
    FROM User u
    WHERE u.createTime BETWEEN :start AND :end
    GROUP BY FUNCTION('DATE', u.createTime)
""")
    List<Object[]> countBySignupDateBetweenGroupByDay(
            @Param("start") LocalDateTime start,
            @Param("end") LocalDateTime end
    );

    @Query("""
    SELECT new org.mapleland.maplelanbackserver.dto.response.ResponseBannedUserDto(
        u.userId,
        u.userName,
        u.discordId,
        u.globalName,
        u.role,
        u.email,
        u.banedReason,
        u.image,
        u.createTime,
        u.reportCount,
        u.bannedHours
    )
    FROM User u
    WHERE u.bannedHours IS NOT NULL
    ORDER BY u.bannedHours DESC
""") List<ResponseBannedUserDto> findBannedUsersDto();

    List<User> findByGlobalNameContaining(String globalName);
}
