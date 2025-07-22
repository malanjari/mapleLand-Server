package org.mapleland.maplelanbackserver.dto.report;

import java.time.LocalDateTime;

public record ReportReasonDto(
    String reason,
    String reportImageUrl,
    LocalDateTime createTime){}
