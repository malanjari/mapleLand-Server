package org.mapleland.maplelanbackserver.cache;

import lombok.Getter;
import lombok.Setter;
import org.mapleland.maplelanbackserver.dto.response.PriceStatDto;

import java.time.LocalDateTime;
import java.util.List;
@Getter
@Setter
public class CachedEntry {
    private final List<PriceStatDto> data;
    private final LocalDateTime createdAt;

    public CachedEntry(List<PriceStatDto> data) {
        this.data = data;
        this.createdAt = LocalDateTime.now();
    }

    public boolean isExpired() {
        return createdAt.plusHours(1).isBefore(LocalDateTime.now());
    }

}