package io.whatap.whatap.domain.order;

import io.whatap.whatap.domain.product.Product;
import io.whatap.whatap.global.common.BaseTimeEntity;
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

    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Builder
    public Order(String address, Integer quantity, Product product) {
        this.address = address;
        this.quantity = quantity;
        this.product = product;
    }

    public void update(Integer quantity) {
        this.quantity = quantity;
    }
}
