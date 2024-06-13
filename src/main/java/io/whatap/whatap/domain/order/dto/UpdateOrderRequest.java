package io.whatap.whatap.domain.order.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UpdateOrderRequest {
    @NotEmpty(message = "주문자 주소(address)를 작성해주세요.")
    private String address;

    @Min(value = 0, message = "수량(quantity)은 0 이상으로 선택해주시길 바랍니다.")
    @NotNull(message = "수량(quantity)이 null입니다.")
    private Integer quantity;
}
