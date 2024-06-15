package io.whatap.order.dto.order;

import io.whatap.order.domain.Order;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AddOrderRequest {
    @NotEmpty(message = "주문자 주소(address)를 작성해주세요.")
    private String address;

    @Min(value = 0, message = "수량(quantity)은 0 이상으로 선택해주시길 바랍니다.")
    @NotNull(message = "수량(quantity)이 null입니다.")
    private Long quantity;

    @NotNull(message = "주문 상품(product)의 id를 작성해주세요.")
    private Long productId;

    public Order toEntity() {
        return Order.builder()
                .address(address)
                .quantity(quantity)
                .productId(productId)
                .build();
    }
}
