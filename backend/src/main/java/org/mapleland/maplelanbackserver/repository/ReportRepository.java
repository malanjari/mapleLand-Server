package org.mapleland.maplelanbackserver.repository;

import org.mapleland.maplelanbackserver.dto.report.ReportReasonDto;
import org.mapleland.maplelanbackserver.table.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ReportRepository extends JpaRepository<Report, Long> {
    // 중복 신고 검사를 위한 메서드
    boolean existsByReporterUserIdAndJariUserMapId(Integer reporterId, Integer jariId);

    // 특정 사용자가 신고당한 목록 조회
    @Query("SELECT r FROM Report r " +
           "JOIN FETCH r.reporter " +    // 신고자(reporter) 엔티티를 함께 Fetch
           "JOIN FETCH r.reported " +    // 신고당한 사용자(reported) 엔티티를 함께 Fetch
           "JOIN FETCH r.jari " +        // 자리(jari) 엔티티를 함께 Fetch
           "WHERE r.reported.userId = :reportedId " +
           "AND r.jari.deleted = false")
    List<Report> findByReportedId(Integer reportedId);


    @Query("""
SELECT new org.mapleland.maplelanbackserver.dto.report.ReportReasonDto(
    r.reason, r.imageUrl, r.createTime
)
FROM Report r
WHERE r.jari.userMapId = :jariId
AND r.jari.deleted = false
ORDER BY r.createTime DESC
""")
    List<ReportReasonDto> findReportReasonsByJariId(@Param("jariId") Integer jariId);

    Report findByJari_UserMapId(Integer jariUserMapId);

}

