package org.mapleLand.maplelanbackserver.controller.location;

import lombok.RequiredArgsConstructor;
import org.mapleLand.maplelanbackserver.dto.MapPopularityDto;
import org.mapleLand.maplelanbackserver.service.MapPopularityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequiredArgsConstructor
public class MapPopularityController {

    private final MapPopularityService mapPopularityService;

    @GetMapping("/api/popular")
    public ResponseEntity<List<MapPopularityDto>> getTopPopularMaps(
            @RequestParam(defaultValue = "10") int limit) {
        return ResponseEntity.ok(mapPopularityService.getTopPopularMaps(limit));
    }
}
