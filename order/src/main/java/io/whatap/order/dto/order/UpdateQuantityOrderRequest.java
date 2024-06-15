package io.whatap.order.dto.order;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UpdateQuantityOrderRequest {
    @Schema(description = "주문 수량")
    @Min(value = 0, message = "수량(quantity)은 0 이상으로 선택해주시길 바랍니다.")
    @NotNull(message = "수량(quantity)이 null입니다.")
    private Long quantity;
}
