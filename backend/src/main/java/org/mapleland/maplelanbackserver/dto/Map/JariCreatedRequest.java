package org.mapleland.maplelanbackserver.dto.Map;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.*;
import org.mapleland.maplelanbackserver.enumType.TradeType;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "맵등록시 쓰는 Dto입니다.")
 public class JariCreatedRequest {

      @NotBlank(message = "맵 이름은 필수입니다.")
      @Size(max = 30, message = "맵 이름은 최대 20자까지 가능합니다.")
      @Schema(description = "맵 이름", example = "미나르숲: 남겨진 용의 둥지")
      private String mapName;

      @NotNull(message = "서버 색을 선택해주세요.")
      @Schema(description = "서버 색상 (Red, Yellow, Green 중 하나)", example = "Red")
      private String serverColor;

      @Size(min = 5, max = 60, message = "코멘트는 최소 5자, 최대 60자까지 가능합니다.")
      @NotNull(message = "메시지를 입력하세요.")
      @Schema(description = "사용자 코멘트", example = "남둥 9시 30분 종료입니다. 타마로스 귓 <")
      private String comment;

      @NotNull(message = "가격을 입력하세요.")
      @Positive(message = "가격은 양수여야 합니다.")
      @Max(value = 2000000000, message = "가격은 최대 20억까지 입력 가능합니다.")
      @Schema(description = "등록 가격 (단위: 메소)", example = "50000000")
      private Long price;

      @NotNull(message = "흥정 옵션을 선택하세요.")
      @Schema(description = "흥정 가능 여부", example = "false")
      private Boolean negotiationOption;

      @NotNull(message = "거래 유형을 선택하세요.")
      @Schema(description = "거래 유형 (BUY = 삽니다, SELL = 팝니다)", example = "SELL")
      private TradeType tradeType;
     @NotNull(message = "맵Id")
     private int mapId;
   }

