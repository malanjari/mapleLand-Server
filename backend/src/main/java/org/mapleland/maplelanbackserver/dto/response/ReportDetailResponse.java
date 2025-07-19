package org.mapleland.maplelanbackserver.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.mapleland.maplelanbackserver.table.Report;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ReportDetailResponse {
    private Integer reporterId;

    private String reporterName;

    private String reporterImage;

    private Integer reportedId;

    private String reportedName;

    private String reportedImage;

    private Integer jariId;

    private String jariName;

    private String jariImage;

    private String reason;

    private String imageUrl;

    private String videoUrl;

    private LocalDateTime createTime;

    public static ReportDetailResponse from(Report report) {
        return new ReportDetailResponse(
                report.getReporter().getUserId(),
                report.getReporter().getUserName(),
                report.getReporter().getImage(),
                report.getReported().getUserId(),
                report.getReported().getUserName(),
                report.getReported().getImage(),
                report.getJari().getUserMapId(),
                report.getJari().getMapName(),
                report.getJari().getMonsterImageUrl(),
                report.getReason(),
                report.getImageUrl(),
                report.getVideoUrl(),
                report.getCreateTime()
        );
    }
}
