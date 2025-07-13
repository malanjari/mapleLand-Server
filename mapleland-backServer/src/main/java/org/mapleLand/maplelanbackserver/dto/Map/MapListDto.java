package org.mapleLand.maplelanbackserver.dto.Map;

import io.swagger.v3.oas.annotations.media.Schema;
import org.mapleLand.maplelanbackserver.dto.PriceStatDto;
import org.mapleLand.maplelanbackserver.dto.item.DropItemDto;

import java.util.List;

public record MapListDto(

        @Schema(description = "몬스터 정보가 들어있는 Dto")
        List<DropItemDto> dropItemDto,
        @Schema(description = "IQR 정보가 들어있는 Dto")
        List<PriceStatDto> priceStatDtoList) {
}

