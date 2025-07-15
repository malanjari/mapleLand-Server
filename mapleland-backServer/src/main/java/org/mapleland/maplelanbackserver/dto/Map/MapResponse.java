package org.mapleland.maplelanbackserver.dto.Map;

import io.swagger.v3.oas.annotations.media.Schema;
import org.mapleland.maplelanbackserver.dto.response.PriceStatDto;
import org.mapleland.maplelanbackserver.dto.response.DropItemResponse;

import java.util.List;

public record MapResponse(

        @Schema(description = "몬스터 정보가 들어있는 Dto")
        List<DropItemResponse> dropItemResponse,
        @Schema(description = "IQR 정보가 들어있는 Dto")
        List<PriceStatDto> priceStatDtoList){}


