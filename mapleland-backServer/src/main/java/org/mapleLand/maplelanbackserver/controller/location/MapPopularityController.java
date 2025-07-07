package org.mapleLand.maplelanbackserver.controller.location;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.RequiredArgsConstructor;
import org.mapleLand.maplelanbackserver.dto.Map.MapPopularityDto;
import org.mapleLand.maplelanbackserver.service.MapPopularityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequiredArgsConstructor
@Schema(description = "상위 10개 인기 값 가져오는 api" , example = "메인 화면시 거래 등록 수의 비례해 값 10개 가져옴")
public class MapPopularityController {

    private final MapPopularityService mapPopularityService;

    @GetMapping("/api/popular")
    @Operation(summary = "거래 순 상위 10개 가져오는 api")
    public ResponseEntity<List<MapPopularityDto>> getTopPopularMaps(
            @RequestParam(defaultValue = "10") int limit) {
        return ResponseEntity.ok(mapPopularityService.getTopPopularMaps(limit));
    }
}
