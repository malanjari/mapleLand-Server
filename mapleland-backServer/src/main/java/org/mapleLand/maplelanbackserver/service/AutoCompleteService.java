package org.mapleLand.maplelanbackserver.service;

import lombok.RequiredArgsConstructor;
import org.mapleLand.maplelanbackserver.repository.MapleLandMapListRepository;
import org.mapleLand.maplelanbackserver.table.MapleLandMapListEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AutoCompleteService {

    private final MapleLandMapListRepository mapleLandMapListRepository;
    private final MapPopularityService popularityService;


    public List<MapleLandMapListEntity> getSuggestedMapNames(String keyword) {
        String cleanedKeyword = keyword.replaceAll("\\s+", "");
        System.out.println("메서드 진입 = " + cleanedKeyword);
        List<MapleLandMapListEntity> byMapName = mapleLandMapListRepository.findByMapName(cleanedKeyword);
        byMapName.forEach(e -> System.out.println(e.toString()));
        return byMapName;
    }
}
