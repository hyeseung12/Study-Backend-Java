package io.whatap.whatap.domain.order;

import io.whatap.whatap.domain.product.Product;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private String address;

    private Integer quantity;

    @Builder
    public Order(Product product, String address, Integer quantity) {
        this.product = product;
        this.address = address;
        this.quantity = quantity;
    }

    public void update(Integer quantity) {
        this.quantity = quantity;
    }
}
