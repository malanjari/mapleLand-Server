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
        return mapleLandMapListRepository.findByMapName(cleanedKeyword);
    }
}
