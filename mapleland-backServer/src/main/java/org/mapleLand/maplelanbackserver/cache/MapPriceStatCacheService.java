package org.mapleLand.maplelanbackserver.cache;

import org.mapleLand.maplelanbackserver.dto.PriceStatDto;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

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
        String key = normalize(mapName); // 공백 제거
        CachedEntry entry = cache.get(key);

        if (entry == null || entry.isExpired()) {
            cache.remove(key); // 만료 시 삭제
            return Collections.emptyList();
        }

        return entry.getData();
    }

    // 계산된 시세 캐시에 저장
    public void saveStat(String mapName, List<PriceStatDto> stats) {
        String key = normalize(mapName);
        cache.put(key, new CachedEntry(stats));
    }

    // 모든 캐시 초기화
    public void clear() {
        cache.clear();
    }
}
