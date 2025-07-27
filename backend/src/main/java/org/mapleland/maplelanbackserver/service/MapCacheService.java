package org.mapleland.maplelanbackserver.service;

import lombok.RequiredArgsConstructor;
import org.mapleland.maplelanbackserver.dto.Map.MapInfoListResponse;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MapCacheService {

    private final MapService mapService;

    @Cacheable(value = "all_maps", cacheManager = "localCacheManger")
    public MapInfoListResponse findAllMapsCache() {
        return mapService.findAllMaps();
    }

    @CachePut(value = "all_maps", cacheManager = "localCacheManger")
    public MapInfoListResponse putAllMapsCache() {
        return mapService.findAllMaps();
    }
}
