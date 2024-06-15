package io.whatap.order.dto.order;

import io.whatap.order.domain.Order;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class OrderResponse {
    private final Long id;
    private final String address;
    private final Long quantity;
    private final Long productId;
    private final LocalDateTime createdDate;
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
