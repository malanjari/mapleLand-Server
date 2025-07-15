package org.mapleland.maplelanbackserver.controller.location;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.RequiredArgsConstructor;
import org.mapleland.maplelanbackserver.service.AutoCompleteService;
import org.mapleland.maplelanbackserver.table.MapleMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@Schema(description = "사용자 검색시 자동검색 해주는 api",example = "망가진 : -> 미나르 숲 : 망가진 용의 둥지 호출")
public class MapAutoCompleteController {

    private final AutoCompleteService searchService;

    @GetMapping("/api/map/autocomplete")
    @Operation(summary = "사용자 검색시 자동검색 해주는 api")
    public List<MapleMap> autoComplete(@RequestParam(defaultValue = "") String keyword) {

        System.out.println("keyword = " + keyword);

        if (keyword == null || keyword.trim().isEmpty()) {
            return List.of(); // 또는 전체 목록 반환할 수도 있음
        }

        return searchService.getSuggestedMapNames(keyword);
    }
}
