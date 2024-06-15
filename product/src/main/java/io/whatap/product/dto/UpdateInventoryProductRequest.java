package io.whatap.product.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateInventoryProductRequest {
    @NotNull(message = "상품 재고량(inventory)이 null입니다.")
    private Long inventory;
}
