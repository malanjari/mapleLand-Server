package org.mapleland.maplelanbackserver.controller.location;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.mapleland.maplelanbackserver.cache.MapPriceStatCacheService;
import org.mapleland.maplelanbackserver.dto.Map.*;
import org.mapleland.maplelanbackserver.dto.response.DropItemResponse;
import org.mapleland.maplelanbackserver.dto.response.PriceStatDto;
import org.mapleland.maplelanbackserver.dto.request.JariUpdateRequest;
import org.mapleland.maplelanbackserver.dto.request.JariIsCompletedRequest;
import org.mapleland.maplelanbackserver.dto.update.PriceUpdateRequest;
import org.mapleland.maplelanbackserver.dto.update.ServerColorRequest;
import org.mapleland.maplelanbackserver.enumType.alert.AlertStatus;
import org.mapleland.maplelanbackserver.service.MapService;
import org.mapleland.maplelanbackserver.service.UserInformationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Tag(name = "MAP API" ,
        description = "맵 등록 조회 , 수정 , 삭제 및 IQR을 이용하여 가격 측정하는 컨트롤러")

@RequiredArgsConstructor
@RestController
@Valid
public class MapController {

    private final MapService mapService;
    private final MapPriceStatCacheService service;

    @PreAuthorize("hasAnyRole('ADMIN', 'MANAGER', 'USER')")
    @PostMapping("/api/create/mapRegister")
    @Operation(summary = "맵 등록 api" , description = "사용자 맵 등록 api")
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<Map<String, String>>
    MapRegister(@RequestBody @Valid JariCreatedRequest dto, @RequestHeader("Authorization")String token) {


        mapService.mapRegisterServiceMethod(dto,token);

        Map<String, String> map = Map.of(
                "상태", "200 OK",
                "message", "맵 등록이 완료 되었습니다."
        );

        return ResponseEntity.status(HttpStatus.OK).body(map);
    }

    @GetMapping("/api/maps")
    @Operation(summary = "목록 리스트 불러오는 api" ,
            description = "사용자 검색 -> 미나르숲:마뇽의 숲 -> 목록 리스트")
    public ResponseEntity<List<JariResponse>> searchMaps(@RequestParam String keyword) {
        List<JariResponse> results = mapService.searchMapsByKeyword(keyword);
        return ResponseEntity.ok(results);
    }

    @Operation(summary = "목록 리스트 불러오는 api",
            description = "IQR 평균 리스트 , MapList, 몬스터 Drop테이블 총 2개 묶어서 불러옴")
    @GetMapping("/api/mapList")
    public ResponseEntity<MapResponse> searchMapList(@RequestParam String keyword) {
        MapResponse mapResponse = mapService.searchMapsListKeyword(keyword);
        return ResponseEntity.ok(mapResponse);
    }

        //  --------- 현재 사용 X ----------------------------------
    @Deprecated
    @GetMapping("/api/monsterInfo")
    @Operation(summary = "목록 리스트에서 몬스터 드랍 테이블 가져오는 api" ,
            description = "현재 사용 안함")
    public ResponseEntity<List<DropItemResponse>> monsterInfo(@RequestParam String keyword) {
        List<DropItemResponse> result = mapService.monsterInfo(keyword);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/api/region")
    @Operation(summary = "지역 태그별로 가져오는 api",
    description = "[리프레 , 엘나스 , 루디브리엄] 태그 글릭시 해당 태그 목록 모두 조회")
    public ResponseEntity<List<JariResponse>> region(@RequestParam String keyword) {
        List<JariResponse> byRegionTag = mapService.findByRegionTag(keyword);
        return ResponseEntity.ok(byRegionTag);
    }

    @GetMapping("/api/maps/price-stat")
    @Operation(summary = "-6시간 IQR을 통해 평균 거래가 가져오는 API",
    description = "미나르 숲 : 마뇽의 숲 검색시 IsCompleted(체결 된) 평균 거래가 -6시간 까지 가져옴")
    public ResponseEntity<List<PriceStatDto>> priceStat(@RequestParam String keyword) {
        System.out.println("📌 요청된 맵: " + keyword);

        // 1. 캐시 먼저 확인
        List<PriceStatDto> cached = service.getStat(keyword);
      // ✅ 캐시 존재 시 바로 응답

        if (!cached.isEmpty()) {
            return ResponseEntity.ok(cached);
        }

        // 2. 캐시에 없으면 계산 + 저장
        List<PriceStatDto> calculated = mapService.iqrPriceAvgLast6Hours(keyword);
        service.saveStat(keyword, calculated);
        return ResponseEntity.ok(calculated);
    }

    // -----------Update -----------------------------------------

    @PreAuthorize("hasAnyRole('ADMIN', 'MANAGER', 'USER')")
    @PostMapping("/api/maps/update/filed")
    @Operation(summary = "사용자가 수정을 누를때 수정하는 api",
    description = "색상 = 초채 , 가격 : 5000만원 , 사용자 코멘트 : 수정완료")
    public ResponseEntity<?> updateFiled(@RequestBody JariUpdateRequest updateDto) {
        mapService.mapUpdateAll(updateDto);
        return ResponseEntity.ok(Map.of("message", "게시글이 수정 되었습니다."));
    }

    @PostMapping("/api/maps/update/isCompleted")
    @Operation(summary = "사용자가 자리 거래 완료 누르는 api",
            description = "isCompleted = false 자리 판매중 -> true 자리 판매 완료")
    public ResponseEntity<?> updateIsCompleted(@RequestBody JariIsCompletedRequest dto,
                                               @RequestHeader("Authorization")String token) {
        mapService.updateIsCompleted(dto,token);

        return ResponseEntity.ok(Map.of("message","거래가 완료 되었습니다."));
    }

    @DeleteMapping("/api/maps/{mapId}/delete")
    public ResponseEntity<?> updateServerColor(@PathVariable int mapId,@RequestHeader("Authorization")String token) {
        mapService.mapDelete(mapId,token);
        return ResponseEntity.ok(Map.of("message", "게시글이 삭제 되었습니다."));
    }


    @PreAuthorize("hasAnyRole('ADMIN', 'MANAGER', 'USER')")
    @PostMapping("/api/alert/interest")
    public ResponseEntity<Map<String,Serializable>>
    createInterRest(@RequestBody AlertRequest dto, @RequestHeader("Authorization")String token) {
        AlertStatus alertStatus = mapService.MapInterRestServiceMethod(dto,token);

        if(alertStatus == AlertStatus.ALERT_ON) {
            return ResponseEntity.ok(Map.of(
                    "success", alertStatus,
                    "message", "알람이 설정 되었습니다."
            ));
        }
        if(alertStatus == AlertStatus.INVALID_REQUEST) {
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of(
                    "Fail", alertStatus,
                    "message","잘못된 요청입니다."
            ));
        }

        return ResponseEntity.ok(Map.of(
                "success", alertStatus,
                "message", "알람이 제거 되었습니다."
        ));
    }

    @Operation(summary = "끌올 API")
    @PostMapping("/api/maps/{jariId}/bump")
    public ResponseEntity<Void> bumpJari(@AuthenticationPrincipal UserInformationService userInformationService, @PathVariable int jariId) {
        mapService.bumpJari(userInformationService, jariId);
        return ResponseEntity.ok().build();
    }

        // ------------현재 사용 안함 -------------------

    @PostMapping("/api/maps/update/price")
    public ResponseEntity<?> updatePrice(@RequestBody PriceUpdateRequest dto) {
        mapService.mapUpdatePrice(dto);
        return ResponseEntity.status(HttpStatus.OK).body("가격이 수정 되었습니다.");
    }


    // ------------현재 사용 안함 -------------------

    @PostMapping("/api/maps/update/server-color")
    @Deprecated
    public ResponseEntity<?> updateServerColor(@RequestBody ServerColorRequest dto) {
        mapService.mapUpdateServerColor(dto);
        return ResponseEntity.status(HttpStatus.OK).body("서버 색깔이 수정 되었습니다.");
    }


    @Operation(summary = "모든 맵 이름을 조회하는 API")
    @GetMapping("/api/maps/all")
    @Deprecated
    public ResponseEntity<?> findAllMaps() {
        MapNameListResponse response = mapService.findAllMaps();

        return ResponseEntity.ok(response);
    }
}
