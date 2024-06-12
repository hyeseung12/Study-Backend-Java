package io.whatap.whatap.domain.order.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.whatap.whatap.domain.order.Order;
import io.whatap.whatap.domain.product.Product;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class OrderResponse {
    private final Long id;
    private final String address;
    private final Integer quantity;
    private final Product product;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private final LocalDateTime createdDate;
    private final LocalDateTime modifiedDate;

    public OrderResponse(Order order) {
        this.id = order.getId();
        this.address = order.getAddress();
        this.quantity = order.getQuantity();
        this.product = order.getProduct();
        this.createdDate = order.getCreatedDate();
        this.modifiedDate = order.getModifiedDate();
    }
}
