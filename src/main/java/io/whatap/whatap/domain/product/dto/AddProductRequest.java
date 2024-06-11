package io.whatap.whatap.domain.product.dto;

import io.whatap.whatap.domain.product.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AddProductRequest {
    @NotEmpty(message = "상품 이름이 비어있습니다.")
    private String name;

    private String description;

    @NotNull(message = "상품 가격이 비어있습니다.")
    private Integer price;

    public Product toEntity() {
        return Product.builder()
                .name(name)
                .description(description)
                .price(price)
                .build();
    }
}
