package org.mapleland.maplelanbackserver.controller.admincontroller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.mapleland.maplelanbackserver.dto.BanUserRequest;
import org.mapleland.maplelanbackserver.dto.Map.MapInfoListResponse;
import org.mapleland.maplelanbackserver.dto.report.ReportedPostWithReasonsDto;
import org.mapleland.maplelanbackserver.dto.response.*;
import org.mapleland.maplelanbackserver.dto.user.UserResponse;
import org.mapleland.maplelanbackserver.service.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class AdminController {

    private final ReportService reportService;
    private final UserService userService;
    private final MapService mapService;
    private final MapCacheService mapCacheService;

    @GetMapping("/api/admin/users")
    public ResponseEntity<List<UserListResponse>> findAllUsersOrderByReportCount(@RequestParam(defaultValue = "0") int page) {
        List<UserListResponse> allUsersOrderByReportCount = reportService.findAllUsersOrderByReportCount(page);
        return ResponseEntity.ok(allUsersOrderByReportCount);
    }

    @GetMapping("/api/admin/reports/users/{userId}")
    public ResponseEntity<ReportDetailsListResponse> findReportsByUserId(@PathVariable Integer userId) {
        ReportDetailsListResponse response = reportService.findReportsByUserId(userId);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/api/admin/userBan")
    public ResponseEntity<Map<String, String>> banUser(@RequestBody BanUserRequest request) {

        userService.userBan(request);
        return ResponseEntity.status(HttpStatus.OK).body(Map.of(
                "status", "200",
                "message", "유저가 정상적으로 차단 되었음"
        ));
    }

    @PostMapping("/api/admin/userUnBan/{userId}")
    public ResponseEntity<Map<String, String>> unBanUser(@PathVariable Integer userId) {
        userService.userUnban(userId);
        return ResponseEntity.status(HttpStatus.OK).body(Map.of(
                "status", "200",
                "message", "유저가 정상적으로 풀렸음"
        ));
    }

    @GetMapping("/api/admin/users/count")
    public ResponseEntity<?> countUsers() {
        int userCount = userService.userAllCount();
        return ResponseEntity.status(HttpStatus.OK).body(userCount);
    }

    @GetMapping("/api/admin/users/signup-count")
    public ResponseEntity<List<ResponseAllUserDto>> getSignupCountPerDay(@RequestParam int year, @RequestParam int month) {
        List<ResponseAllUserDto> signupCountPerDay = userService.getSignupCountPerDay(year, month);
        return ResponseEntity.status(HttpStatus.OK).body(signupCountPerDay);
    }

    @GetMapping("/api/admin/trade/completed-count")
    public ResponseEntity<List<CompletedTradeCountDto>> getCompletedTradeCountPerDay(@RequestParam int year, @RequestParam int month) {
        List<CompletedTradeCountDto> completedTradeCountPerDay = mapService.getCompletedTradeCountPerDay(year, month);
        return ResponseEntity.status(HttpStatus.OK).body(completedTradeCountPerDay);
    }

    @GetMapping("/api/admin/users/banned")
    public ResponseEntity<List<ResponseBannedUserDto>> lockedUsers() {
        List<ResponseBannedUserDto> responseBannedUserDtos = userService.callLockedUser();
        return ResponseEntity.status(HttpStatus.OK).body(responseBannedUserDtos);
    }

    @GetMapping("/api/admin/reports/posts")
    public ResponseEntity<Page<ReportedPostWithReasonsDto>> reportsPosts(@RequestParam(defaultValue = "0") int page) {
        Page<ReportedPostWithReasonsDto> reportedPostWithReasonsDtos = userService.AllReportPosts(page);
        return ResponseEntity.ok(reportedPostWithReasonsDtos);
    }

    @Operation(summary = "사용자 검색")
    @GetMapping("/api/admin/users/search")
    public ResponseEntity<List<UserResponse>> findUsers(@RequestParam String globalName) {
        List<UserResponse> response = userService.findUsersByGlobalName(globalName);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "모든 자리 조회")
    @GetMapping("/api/admin/jari")
    public ResponseEntity<JariListResponse> findAllJari(@PageableDefault(size = 10, sort = "createTime", direction = Sort.Direction.DESC) Pageable pageable) {
        JariListResponse response = mapService.findAllJari(pageable);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "맵 캐시 강제 갱신")
    @PostMapping("/api/admin/maps/all/refresh")
    public ResponseEntity<MapInfoListResponse> refreshMapsCache() {
        MapInfoListResponse response = mapCacheService.putAllMapsCache();
        return ResponseEntity.ok(response);
    }
}
