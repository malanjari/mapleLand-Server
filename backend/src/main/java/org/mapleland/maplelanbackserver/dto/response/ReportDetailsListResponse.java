package org.mapleland.maplelanbackserver.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ReportDetailsListResponse {
    private List<ReportDetailResponse> reportDetailsList;
}
