package io.whatap.order.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ProductResponse {
    @Schema(description = "id")
    private Long id;

    @Schema(description = "상품명")
    private String name;

    @Schema(description = "상품 설명")
    private String description;

    @Schema(description = "상품 가격")
    private Integer price;

    @Schema(description = "상품 재고량")
    private Long inventory;

    @Schema(description = "상품 정보 등록 날짜")
    private LocalDateTime createdDate;

    @Schema(description = "상품 정보 수정 날짜")
    private LocalDateTime modifiedDate;
}
