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

    private Integer userId; //신고 한 유저

    private Integer jariId; // 신고 게시글
}
