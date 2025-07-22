package org.mapleland.maplelanbackserver.dto.report;

import java.time.LocalDateTime;
import java.util.List;

public record ReportedPostWithReasonsDto(
        Integer userMapId,
        String mapName,
        Integer price,
        String serverColor,
        String area,
        String comment,
        Boolean isCompleted,
        LocalDateTime createTime,

        Integer userId,
        String userName,
        String globalName,
        String image,
        String discordId,

        List<ReportReasonDto> reasons
) {}
