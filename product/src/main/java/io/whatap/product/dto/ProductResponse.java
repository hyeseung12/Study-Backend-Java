package io.whatap.product.dto;

import io.whatap.product.domain.Product;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ProductResponse {
    private final Long id;
    private final String name;
    private final String description;
    private final Integer price;
    private final Long inventory;
    private final LocalDateTime createdDate;
    private final LocalDateTime modifiedDate;

    public ProductResponse(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.description = product.getDescription();
        this.price = product.getPrice();
        this.inventory = product.getInventory();
        this.createdDate = product.getCreatedDate();
        this.modifiedDate = product.getModifiedDate();
    }
}
