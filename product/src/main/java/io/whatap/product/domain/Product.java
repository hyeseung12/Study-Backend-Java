package io.whatap.product.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private Integer price;

    private Long inventory;

    @Builder
    public Product(String name, String description, Integer price, Long inventory) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.inventory = inventory;
    }

    public void updateInfo(String name, String description, Integer price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public void updateInventory(Long inventory) {
        this.inventory = inventory;
    }
}
