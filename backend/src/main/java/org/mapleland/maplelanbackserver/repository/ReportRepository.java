package org.mapleland.maplelanbackserver.repository;

import org.mapleland.maplelanbackserver.table.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReportRepository extends JpaRepository<Report, Long> {
    // 중복 신고 검사를 위한 메서드
    boolean existsByReporterUserIdAndJariUserMapId(Integer reporterId, Integer jariId);

    // 특정 사용자가 신고당한 목록 조회
    @Query("SELECT r FROM Report r " +
           "JOIN FETCH r.reporter " +    // 신고자(reporter) 엔티티를 함께 Fetch
           "JOIN FETCH r.reported " +    // 신고당한 사용자(reported) 엔티티를 함께 Fetch
           "JOIN FETCH r.jari " +        // 자리(jari) 엔티티를 함께 Fetch
           "WHERE r.reported.userId = :reportedId")
    List<Report> findByReportedId(Integer reportedId);
}

