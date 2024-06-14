package io.whatap.product.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateInventoryProductRequest {
    @NotNull(message = "상품 재고량(inventory)이 null입니다.")
    @Min(value = 0, message = "재고량(inventory)은 0 이상으로 작성해주시길 바랍니다.")
    private Long inventory;
}
