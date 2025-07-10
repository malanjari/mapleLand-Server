package org.mapleLand.maplelanbackserver.dto;
import jakarta.validation.constraints.*;
import lombok.*;
import org.mapleLand.maplelanbackserver.enumType.Region;
import org.mapleLand.maplelanbackserver.enumType.TradeType;
import org.springframework.web.multipart.MultipartFile;

@Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public class MapRegistrationDto {

        @NotBlank(message = "맵 이름은 필수입니다.")
        @Size(max = 20, message = "맵 이름은 최대 20자까지 가능합니다.")
        private String mapName;
        @NotNull(message = "유저 이름은 필수 입니다.")
        private int userId;

        @NotNull(message = "서버 색을 선택 해주세요.")
        private String serverColor;

        @Size(min = 5, max = 60, message = "코멘트는 최소 5자, 최대 60자까지 가능합니다.")
        @NotNull(message = "메세지를 입력하세요")
        private String comment;

        @NotNull(message = "가격을 입력하세요.")
        @Positive(message = "가격은 양수여야 합니다.")
        @Max(value = 2000000000, message = "가격은 최대 20억까지 입력 가능합니다.")
        private Integer price;

        @NotNull(message = "흥정 옵션을 선택하세요.")
        private Boolean negotiationOption;
        @NotNull(message = "거래 유형을 선택하세요.")
        private TradeType tradeType;  // enum {SELL, BUY}
}
