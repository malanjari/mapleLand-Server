package org.mapleland.maplelanbackserver.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ReportRequest {

    private String reason;

    private Integer userId;

    private Integer jariId;

    private String imagesUrl;

    private String videoUrl;
}
