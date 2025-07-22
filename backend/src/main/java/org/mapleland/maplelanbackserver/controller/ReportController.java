package org.mapleland.maplelanbackserver.controller;

import lombok.RequiredArgsConstructor;
import org.mapleland.maplelanbackserver.dto.request.ReportRequest;
import org.mapleland.maplelanbackserver.dto.response.ReportDetailsListResponse;
import org.mapleland.maplelanbackserver.dto.response.UserListResponse;
import org.mapleland.maplelanbackserver.dto.user.UserResponse;
import org.mapleland.maplelanbackserver.service.ImageService;
import org.mapleland.maplelanbackserver.service.ReportService;
import org.mapleland.maplelanbackserver.service.UserInformationService;
import org.mapleland.maplelanbackserver.table.User;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RequestMapping("/api/reports")
@RestController
public class ReportController {

    private final ReportService reportService;


    @PostMapping
    public ResponseEntity<?> report(@AuthenticationPrincipal UserInformationService user,
                                       @RequestPart("request") ReportRequest request,
                                       @RequestPart(value = "reportImage" ,required = false) MultipartFile reportImage) {
        reportService.report(user, request,reportImage);
        return ResponseEntity.ok(Map.of(
                "status" , "200",
                "message" , "신고가 정상적으로 접수 되었습니다."
        ));
    }
}
