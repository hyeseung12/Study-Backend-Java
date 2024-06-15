package io.whatap.product.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import io.whatap.product.domain.Product;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ProductResponse {
    @Schema(description = "id")
    private final Long id;

    @Schema(description = "상품명")
    private final String name;

    @Schema(description = "상품 설명")
    private final String description;

    @Schema(description = "상품 가격")
    private final Integer price;

    @Schema(description = "상품 재고량")
    private final Long inventory;

    @Schema(description = "상품 정보 등록 날짜")
    private final LocalDateTime createdDate;

    @Schema(description = "상품 정보 수정 날짜")
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
