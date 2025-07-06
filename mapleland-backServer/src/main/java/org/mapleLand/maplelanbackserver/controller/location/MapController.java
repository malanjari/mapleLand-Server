package org.mapleLand.maplelanbackserver.controller.location;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.mapleLand.maplelanbackserver.dto.DropItemDto;
import org.mapleLand.maplelanbackserver.dto.MapDto;
import org.mapleLand.maplelanbackserver.dto.MapRegistrationDto;
import org.mapleLand.maplelanbackserver.enumType.Region;
import org.mapleLand.maplelanbackserver.service.MapService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@Valid
public class MapController {

    private final MapService mapService;

    @PostMapping("/api/create/mapRegister")
    public ResponseEntity<Map<String,String>> MapRegister(@RequestBody @Valid MapRegistrationDto dto) {


        mapService.mapRegisterServiceMethod(dto);

        Map<String,String> map = Map.of(
                "상태","200 OK",
                "message","맵 등록이 완료 되었습니다."
        );

        return ResponseEntity.status(HttpStatus.OK).body(map);
    }
    @GetMapping("/api/maps")
    public ResponseEntity<List<MapDto>> searchMaps(@RequestParam String keyword) {
        List<MapDto> results = mapService.searchMapsByKeyword(keyword);
        return ResponseEntity.ok(results);
    }
    @GetMapping("/api/monsterInfo")
    public ResponseEntity<List<DropItemDto>> monsterInfo(@RequestParam String keyword) {
        List<DropItemDto> result = mapService.monsterInfo(keyword);
        return ResponseEntity.ok(result);
    }
    @GetMapping("/api/region")
    public ResponseEntity<List<MapDto>> region(@RequestParam String keyword) {
        List<MapDto> byRegionTag = mapService.findByRegionTag(keyword);
        return ResponseEntity.ok(byRegionTag);
    }
}
