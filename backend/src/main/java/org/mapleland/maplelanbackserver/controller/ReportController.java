package org.mapleland.maplelanbackserver.controller;

import lombok.RequiredArgsConstructor;
import org.mapleland.maplelanbackserver.dto.request.ReportRequest;
import org.mapleland.maplelanbackserver.dto.response.ReportDetailsListResponse;
import org.mapleland.maplelanbackserver.dto.response.UserListResponse;
import org.mapleland.maplelanbackserver.dto.user.UserResponse;
import org.mapleland.maplelanbackserver.service.ReportService;
import org.mapleland.maplelanbackserver.table.User;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/api/reports")
@RestController
public class ReportController {

    private final ReportService reportService;

    @PostMapping
    public ResponseEntity<Void> report(@AuthenticationPrincipal User user, @RequestBody ReportRequest request) {
        reportService.report(user, request);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/users/top")
    public ResponseEntity<UserListResponse> findAllUsersOrderByReportCount() {
        UserListResponse response = reportService.findAllUsersOrderByReportCount();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<ReportDetailsListResponse> findReportsByUserId(@PathVariable Integer userId) {
        ReportDetailsListResponse response = reportService.findReportsByUserId(userId);
        return ResponseEntity.ok(response);
    }
}
