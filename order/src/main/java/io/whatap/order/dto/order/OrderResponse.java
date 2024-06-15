package io.whatap.order.dto.order;

import io.swagger.v3.oas.annotations.media.Schema;
import io.whatap.order.domain.Order;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class OrderResponse {
    @Schema(description = "id")
    private final Long id;
    
    @Schema(description = "주문 주소")
    private final String address;
    
    @Schema(description = "주문 수량")
    private final Long quantity;
    
    @Schema(description = "주문 상품 번호")
    private final Long productId;
    
    @Schema(description = "주문 정보 등록 날짜")
    private final LocalDateTime createdDate;
    
    @Schema(description = "주문 정보 수정 날짜")
    private final LocalDateTime modifiedDate;

    public OrderResponse(Order order) {
        this.id = order.getId();
        this.address = order.getAddress();
        this.quantity = order.getQuantity();
        this.productId = order.getProductId();
        this.createdDate = order.getCreatedDate();
        this.modifiedDate = order.getModifiedDate();
    }
}
