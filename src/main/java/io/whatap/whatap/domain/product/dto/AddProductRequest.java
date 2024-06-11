package io.whatap.whatap.domain.product.dto;

import io.whatap.whatap.domain.product.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AddProductRequest {
    @NotEmpty(message = "상품 이름(name)을 작성해주세요.")
    private String name;

    @NotNull(message = "상품 설명(description)이 null입니다.")
    private String description;

    @NotNull(message = "상품 가격(price)이 비어있습니다.")
    @Min(value = 0, message = "가격(price)은 0 이상으로 작성해주시길 바랍니다.")
    private Integer price;

    public Product toEntity() {
        return Product.builder()
                .name(name)
                .description(description)
                .price(price)
                .build();
    }
}
