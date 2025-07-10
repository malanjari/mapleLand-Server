package org.mapleLand.maplelanbackserver.controller.location;

import lombok.RequiredArgsConstructor;
import org.mapleLand.maplelanbackserver.service.AutoCompleteService;
import org.mapleLand.maplelanbackserver.table.MapleLandMapListEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class MapAutoCompleteController {

    private final AutoCompleteService searchService;

    @GetMapping("/api/map/autocomplete")
    public List<MapleLandMapListEntity> autoComplete(@RequestParam(defaultValue = "") String keyword) {

        System.out.println("keyword = " + keyword);

        if (keyword == null || keyword.trim().isEmpty()) {
            return List.of(); // 또는 전체 목록 반환할 수도 있음
        }
        return searchService.getSuggestedMapNames(keyword);
    }
}
