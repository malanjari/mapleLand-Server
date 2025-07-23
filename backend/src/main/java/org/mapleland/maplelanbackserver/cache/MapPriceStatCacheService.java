package org.mapleland.maplelanbackserver.cache;

import lombok.extern.slf4j.Slf4j;
import org.mapleland.maplelanbackserver.dto.response.PriceStatDto;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@Service
public class MapPriceStatCacheService {

    // 메모리 캐시 (맵 이름 기준)
    private final Map<String, CachedEntry> cache = new ConcurrentHashMap<>();

    // 공백 제거 함수 (키 정규화)
    private String normalize(String input) {
        return input.replaceAll(" ", ""); // 공백 제거
    }

    // 캐시에서 시세 가져오기 (1시간 TTL 만료 검사 포함)
    public List<PriceStatDto> getStat(String mapName) {
        CachedEntry entry = cache.get(mapName);
        log.info("캐쉬 진입");
        if (entry == null || entry.isExpired()) {
            cache.remove(mapName);
            log.info("캐쉬 삭제");// 만료 시 삭제
            return Collections.emptyList();
        }
        log.info("캐쉬 아님 삭제 아님");
        return entry.getData();
    }

    // 계산된 시세 캐시에 저장
    public void saveStat(String mapName, List<PriceStatDto> stats) {
//        String key = normalize(mapName);
        cache.put(mapName, new CachedEntry(stats));
    }

    // 모든 캐시 초기화
    public void clear() {
        cache.clear();
    }
}
