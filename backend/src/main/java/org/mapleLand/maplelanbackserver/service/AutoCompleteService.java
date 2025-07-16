package org.mapleland.maplelanbackserver.service;

import lombok.RequiredArgsConstructor;
import org.mapleland.maplelanbackserver.repository.MapleMapRepository;
import org.mapleland.maplelanbackserver.table.MapleMap;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
@Deprecated
public class AutoCompleteService {

    private final MapleMapRepository mapleMapRepository;
    private final MapPopularityService popularityService;


    public List<MapleMap> getSuggestedMapNames(String keyword) {
        String cleanedKeyword = keyword.replaceAll("\\s+", "");
        List<MapleMap> byMapName = mapleMapRepository.findByMapName(cleanedKeyword);
        byMapName.forEach(e -> System.out.println(e.toString()));
        return byMapName;
    }
}
