package io.whatap.product.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateProductRequest {
    @Schema(description = "상품명")
    @NotEmpty(message = "상품 이름(name)을 작성해주세요.")
    private String name;

    @Schema(description = "상품 설명")
    @NotNull(message = "상품 설명(description)이 null입니다.")
    private String description;

    @Schema(description = "상품 가격")
    @NotNull(message = "상품 가격(price)이 null입니다.")
    @Min(value = 0, message = "가격(price)은 0 이상으로 작성해주시길 바랍니다.")
    private Integer price;
}
