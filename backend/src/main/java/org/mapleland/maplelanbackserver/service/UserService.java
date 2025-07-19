package org.mapleland.maplelanbackserver.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mapleland.maplelanbackserver.dto.BanUserRequest;
import org.mapleland.maplelanbackserver.dto.report.ReportReasonDto;
import org.mapleland.maplelanbackserver.dto.report.ReportedPostWithReasonsDto;
import org.mapleland.maplelanbackserver.dto.response.ResponseAllUserDto;
import org.mapleland.maplelanbackserver.dto.response.ResponseBannedUserDto;
import org.mapleland.maplelanbackserver.exception.NotFoundMapException;
import org.mapleland.maplelanbackserver.exception.NotFoundUserException;
import org.mapleland.maplelanbackserver.dto.response.AlterDto;
import org.mapleland.maplelanbackserver.dto.user.*;
import org.mapleland.maplelanbackserver.enumType.alert.AlertStatus;
import org.mapleland.maplelanbackserver.repository.MapInterRestRepository;
import org.mapleland.maplelanbackserver.repository.ReportRepository;
import org.mapleland.maplelanbackserver.repository.UserRepository;
import org.mapleland.maplelanbackserver.repository.JariRepository;
import org.mapleland.maplelanbackserver.table.Jari;
import org.mapleland.maplelanbackserver.table.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {


    private final UserRepository userRepository;
    private final JariRepository jariRepository;
    private final MapInterRestRepository mapInterRestRepository;
    private final ReportRepository reportRepository;
    private final JwtDecoder jwtDecoder;


    public void userBan(BanUserRequest request) {
        LocalDateTime permanentBan = LocalDateTime.of(9999, 12, 31, 23, 59, 59);
        User banuser = userRepository.findByUserId(request.userId())
                .orElseThrow(() -> new NotFoundUserException("사용자를 찾을 수 없습니다."));
        if (request.bannedHours() == 999) {
            banuser.setBannedHours(permanentBan);
        } else {
            banuser.setBannedHours(LocalDateTime.now().plusHours(request.bannedHours()));
        }

        banuser.setActive(false);
        banuser.setBannedHours(banuser.getBannedHours());
        banuser.setBanedReason(request.reason());

        userRepository.save(banuser);

    }

    public void userUnban(int userId) {
        User user = userRepository.findByUserId(userId).orElseThrow(() -> new NotFoundMapException("사용자를 찾을 수 없음"));

        user.setActive(true);
        user.setBannedHours(null);
        user.setBanedReason("차단 해제");

        userRepository.save(user);

    }

    public ResponseUserDetailDto getUserDetailServiceMethod(Integer userId) {
        // 사용자 정보 조회
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundUserException("사용자를 찾을 수 없습니다."));


        // 사용자 정보 DTO 생성
        UserInfoDto userInfo = new UserInfoDto(
                user.getUserId(),
                user.getDiscordId(),
                user.getImage(),
                user.getCreateTime(),
                user.getGlobalName(),
                user.getMapTicket(),
                user.getUserName(),
                user.getEmail(),
                user.isActive());

        // 사용자가 등록한 맵 목록 조회
        List<Jari> mapRegistrations = jariRepository.findByMapleJariUserEntity_UserId(userId);

        // 맵 등록 정보 DTO 리스트 생성
        List<UserMapRegistrationDto> mapRegistrationDtos = mapRegistrations.stream()
                .map(e -> {
                    var userResult = e.getUser();
                    return new UserMapRegistrationDto(
                            e.getUserMapId(),
                            e.getMapName(),
                            e.getServerColor(),
                            e.getPrice(),
                            e.getTradeType(),
                            e.getNegotiationOption(),
                            e.getArea(),
                            e.getCreateTime(),
                            e.getComment(),
                            e.getMonsterImageUrl(),
                            e.getIsCompleted(),
                            userResult.getImage(),
                            userResult.getUserId(),
                            userResult.getDiscordId(),
                            userResult.getGlobalName()

                    );
                })
                .toList();


        return new ResponseUserDetailDto(userInfo, mapRegistrationDtos);
    }

    public LoginStatusResponse checkLoginStatus(String authHeader) {
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return new LoginStatusResponse(false, null, null);
        }

        String token = authHeader.substring(7).trim();

        try {
            Jwt jwt = jwtDecoder.decode(token);
            Map<String, Object> claims = jwt.getClaims();

            Object idObj = claims.get("userId");
            if (!(idObj instanceof Number number)) {
                throw new IllegalStateException("userId가 숫자가 아닙니다: " + idObj);
            }
            int userId = number.intValue();

            List<AlterDto> alertList = mapInterRestRepository
                    .findByUser_UserId(userId)
                    .stream()
                    .map(e -> new AlterDto(
                            e.getMapleMap().getMapleLandMapListId(),
                            AlertStatus.ALERT_ON))
                    .toList();

            ResponseApiUserDto userDto = new ResponseApiUserDto(claims);

            return new LoginStatusResponse(true, userDto, alertList);

        } catch (Exception e) {
            log.info("❌ JWT 검증 실패: {}", e.getMessage());
            return new LoginStatusResponse(false, null, null);
        }
    }

    public int userAllCount() {
        long count = userRepository.count();
        return (int) count;
    }

    public List<ResponseAllUserDto> getSignupCountPerDay(int year, int month) {
        // 1. LocalDate 먼저 정의
        LocalDate startDate = LocalDate.of(year, month, 1);
        LocalDate endDate = startDate.withDayOfMonth(startDate.lengthOfMonth());

        // 2. LocalDateTime으로 변환
        LocalDateTime start = startDate.atStartOfDay();          // 00:00:00
        LocalDateTime end = endDate.atTime(23, 59, 59);          // 23:59:59

        // 3. DB 조회
        List<Object[]> result = userRepository.countBySignupDateBetweenGroupByDay(start, end);

        // 4. 결과 맵 초기화
        Map<LocalDate, Long> map = new LinkedHashMap<>();
        for (int i = 0; i < startDate.lengthOfMonth(); i++) {
            map.put(startDate.plusDays(i), 0L);
        }

        // 5. DB 결과로 덮어쓰기
        for (Object[] row : result) {
            java.sql.Date sqlDate = (java.sql.Date) row[0];
            LocalDate date = sqlDate.toLocalDate();
            Long count = (Long) row[1];
            map.put(date, count);
        }

        return map.entrySet().stream()
                .map(entry -> new ResponseAllUserDto(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());
    }

    public List<ResponseBannedUserDto> callLockedUser() {
        return userRepository.findBannedUsersDto();
    }

    public Page<ReportedPostWithReasonsDto> AllReportPosts(int page) {

        int pageSize = 20;
        Pageable pageable = PageRequest.of(Math.max(page - 1, 0), pageSize);

        //신고 된 적이 있는 테이블 조회
        List<Jari> reportedJariList = jariRepository.findReportedPosts(pageable);

        //해당 테이블이 몇회 신고 했는지 알려줌
        long total = jariRepository.countReportedJari();

        List<ReportedPostWithReasonsDto> content = reportedJariList.stream().map(j -> {
            User u = j.getUser();
            List<ReportReasonDto> reasons = reportRepository.findReportReasonsByJariId(j.getUserMapId());


            return new ReportedPostWithReasonsDto(
                    j.getUserMapId(),
                    j.getMapName(),
                    j.getPrice(),
                    j.getServerColor(),
                    j.getArea().name(),
                    j.getComment(),
                    j.getIsCompleted(),
                    j.getCreateTime(),
                    u.getUserId(),
                    u.getUserName(),
                    u.getGlobalName(),
                    u.getImage(),
                    u.getDiscordId(),
                    reasons
            );
        }).toList();

        return new PageImpl<>(content, pageable, total);
    }


}
