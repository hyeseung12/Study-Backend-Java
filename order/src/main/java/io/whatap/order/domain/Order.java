package io.whatap.order.domain;

import io.whatap.order.global.common.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "orders")
public class Order extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String address;

    private Long quantity;

    private Long productId;

    @Builder
    public Order(String address, Long quantity, Long productId) {
        this.address = address;
        this.quantity = quantity;
        this.productId = productId;
    }

    public void updateAddress(String address) {
        this.address = address;
    }

    public void updateQuantity(Long quantity) {
        this.quantity = quantity;
    }
}
