package io.whatap.whatap.domain.product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.whatap.whatap.domain.order.Order;
import io.whatap.whatap.global.common.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Product extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private Integer price;

    @JsonIgnore
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Order> orderList;

    @Builder
    public Product(String name, String description, Integer price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public void update(String name, String description, Integer price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }
}
