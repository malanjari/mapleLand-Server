package org.mapleLand.maplelanbackserver.controller.location;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.mapleLand.maplelanbackserver.dto.item.DropItemDto;
import org.mapleLand.maplelanbackserver.dto.Map.MapDto;
import org.mapleLand.maplelanbackserver.dto.Map.MapRegistrationDto;
import org.mapleLand.maplelanbackserver.dto.PriceStatDto;
import org.mapleLand.maplelanbackserver.dto.update.MapUpdateDto;
import org.mapleLand.maplelanbackserver.dto.update.MapUpdatePriceDto;
import org.mapleLand.maplelanbackserver.dto.update.MapUpdateServerColorDto;
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

    @GetMapping("/api/maps/price-stat")
    public ResponseEntity<List<PriceStatDto>>  priceStat(@RequestParam String keyword) {
        System.out.println("📌 들어온 키워드: [" + keyword + "]");
        List<PriceStatDto> iqrPrice = mapService.iqrPriceAvg(keyword);
        return ResponseEntity.ok(iqrPrice);
    }

    // -----------Update -----------------------------------------

    @PostMapping("/api/maps/update/filed")
    public ResponseEntity<?> updateFiled(@RequestBody MapUpdateDto updateDto) {
        mapService.mapUpdateAll(updateDto);
        return ResponseEntity.ok(Map.of("message","게시글이 수정 되었습니다."));
    }


    @PostMapping("/api/maps/update/price")
      public ResponseEntity<?>  updatePrice(@RequestBody MapUpdatePriceDto dto) {
        mapService.mapUpdatePrice(dto);
        return ResponseEntity.status(HttpStatus.OK).body("가격이 수정 되었습니다.");
        }


     @PostMapping("/api/maps/update/server-color")
       public ResponseEntity<?>  updateServerColor(@RequestBody MapUpdateServerColorDto dto) {
        mapService.mapUpdateServerColor(dto);
            return ResponseEntity.status(HttpStatus.OK).body("서버 색깔이 수정 되었습니다.");
        }

    @DeleteMapping("/api/maps/{mapId}/delete")
    public ResponseEntity<?>  updateServerColor(@PathVariable int mapId) {
        mapService.mapDelete(mapId);
        return ResponseEntity.ok(Map.of("message","게시글이 삭제 되었습니다."));
    }


}
