package io.whatap.order.dto.product;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateInventoryProductRequest {
    @Schema(description = "상품 재고량")
    @NotNull(message = "상품 재고량(inventory)이 null입니다.")
    private Long inventory;
}
