package io.whatap.whatap.domain.order.dto;

import io.whatap.whatap.domain.order.Order;
import io.whatap.whatap.domain.product.Product;
import lombok.Getter;

@Getter
public class OrderResponse {
    private final Long id;
    private final String address;
    private final Integer quantity;
    private final Product product;

    public OrderResponse(Order order) {
        this.id = order.getId();
        this.address = order.getAddress();
        this.quantity = order.getQuantity();
        this.product = order.getProduct();
    }
}
