package org.mapleland.maplelanbackserver.service;

import lombok.RequiredArgsConstructor;
import org.mapleland.maplelanbackserver.dto.request.ReportRequest;
import org.mapleland.maplelanbackserver.dto.response.ReportDetailResponse;
import org.mapleland.maplelanbackserver.dto.response.ReportDetailsListResponse;
import org.mapleland.maplelanbackserver.dto.response.UserListResponse;
import org.mapleland.maplelanbackserver.dto.user.UserResponse;
import org.mapleland.maplelanbackserver.repository.ReportRepository;
import org.mapleland.maplelanbackserver.repository.jariRepository;
import org.mapleland.maplelanbackserver.repository.userRepository;
import org.mapleland.maplelanbackserver.table.Report;
import org.mapleland.maplelanbackserver.table.User;
import org.mapleland.maplelanbackserver.table.jari;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class ReportService {
    private final ReportRepository reportRepository;
    private final userRepository userRepository;
    private final jariRepository jariRepository;

    @Transactional
    public void report(User user, ReportRequest request) {
        Integer reporterId = user.getUserId();

        if (reportRepository.existsByReporterUserIdAndJariUserMapId(reporterId, request.getJariId())) {
            throw new RuntimeException("중복 신고를 할 수 없습니다."); // DuplicatedReportException
        }

        // UserNotFoundException, RegistrationNotFoundException
        User reporterUser = userRepository.findByUserId(reporterId).orElseThrow(RuntimeException::new);
        User reportedUser = userRepository.findByUserId(request.getUserId()).orElseThrow(RuntimeException::new);
        jari jari = jariRepository.findByUserMapId(request.getJariId());

        Report report = Report.builder()
                .reporter(reporterUser)
                .reported(reportedUser)
                .jari(jari)
                .reason(request.getReason())
                .imageUrl(request.getImagesUrl())
                .videoUrl(request.getVideoUrl())
                .build();

        reportedUser.increaseReportCount();

        reportRepository.save(report);
    }

    public UserListResponse findAllUsersOrderByReportCount() {
        List<UserResponse> userList = userRepository.findAllByOrderByReportCountDesc().stream().map(UserResponse::from).toList();

        return new UserListResponse(userList);
    }

    public ReportDetailsListResponse findReportsByUserId(Integer userId) {
        List<ReportDetailResponse> reportDetailsList = reportRepository.findByReportedId(userId).stream()
                .map(ReportDetailResponse::from).toList();

        return new ReportDetailsListResponse(reportDetailsList);
    }
}
