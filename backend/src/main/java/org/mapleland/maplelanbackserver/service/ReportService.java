package org.mapleland.maplelanbackserver.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mapleland.maplelanbackserver.dto.request.ReportRequest;
import org.mapleland.maplelanbackserver.dto.response.ReportDetailResponse;
import org.mapleland.maplelanbackserver.dto.response.ReportDetailsListResponse;
import org.mapleland.maplelanbackserver.dto.response.UserListResponse;
import org.mapleland.maplelanbackserver.exception.NotFoundMapException;
import org.mapleland.maplelanbackserver.exception.NotFoundUserException;
import org.mapleland.maplelanbackserver.exception.report.DuplicateReportException;
import org.mapleland.maplelanbackserver.repository.ReportRepository;
import org.mapleland.maplelanbackserver.repository.JariRepository;
import org.mapleland.maplelanbackserver.repository.UserRepository;
import org.mapleland.maplelanbackserver.table.Report;
import org.mapleland.maplelanbackserver.table.User;
import org.mapleland.maplelanbackserver.table.Jari;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;


import java.util.List;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
@Slf4j
public class ReportService {
    private final ReportRepository reportRepository;
    private final UserRepository userRepository;
    private final JariRepository jariRepository;
    private final ImageService imageService;

    @Transactional
    public void report(UserInformationService user, ReportRequest request, MultipartFile reportImage) {

        int reporterId = user.getUserId(); // 신고자

        log.info("컨텍스트 값 = {}",user.getUserId());
        log.info("유저 값 = {}",request.getUserId());

        if(request.getUserId() != user.getUserId()) throw new NotFoundUserException("사용자가 아닙니다.");


        if (reportRepository.existsByReporterUserIdAndJariUserMapId(reporterId, request.getJariId())) {
            throw new DuplicateReportException("중복 신고를 할 수 없습니다."); // DuplicatedReportException
        }
        Jari jari = jariRepository.OPTIONALFindByUserMapId(request.getJariId())
                .orElseThrow(() -> new NotFoundMapException("등록된 게시글을 찾을 수 없습니다."));

        String s3ImageUrl = null;


        if(reportImage != null) {
             s3ImageUrl = imageService.getS3ImageUrl(user,reportImage);

        }

        // 신고자
        User reporterUser = userRepository.findByUserId(reporterId).
                orElseThrow(() -> new UsernameNotFoundException("신고 유저를 찾을 수 없습니다."));

        //신고된 유저
        Jari reportedjari = jariRepository.OPTIONALFindByUserMapId(jari.getUserMapId()).orElseThrow(()
                -> new NotFoundMapException("게시글을 찾을 수 없습니다."));

        User reportedUser = userRepository.findByUserId(reportedjari.getUser().getUserId()).orElseThrow(() -> new NotFoundUserException("사용자를 찾을 수 없습니다."));


        Report report = Report.builder()
                .reporter(reporterUser)
                .reported(reportedUser)
                .jari(jari)
                .reason(request.getReason())
                .imageUrl(s3ImageUrl)
                .videoUrl("현재 사용 X")
                .build();

        reportedUser.increaseReportCount(); //

        reportRepository.save(report);
        userRepository.save(reportedUser); // 내 가추가한거
    }

    public List<UserListResponse> findAllUsersOrderByReportCount(int page) {
        Pageable fixedPage = PageRequest.of(page, 20);


        return userRepository.findAllByOrderByReportCountDesc(fixedPage).stream()
                .map(e-> new UserListResponse(
                        e.getUserId(),
                        e.getUserName(),
                        e.getDiscordId(),
                        e.getRole(),
                        e.getReportCount(),
                        e.getImage(),
                        e.getGlobalName(),
                        e.getCreateTime()
                )).toList();
    }

    public ReportDetailsListResponse findReportsByUserId(Integer userId) {
        List<ReportDetailResponse> reportDetailsList = reportRepository.findByReportedId(userId).stream()
                .map(ReportDetailResponse::from).toList();

        return new ReportDetailsListResponse(reportDetailsList);
    }
}
