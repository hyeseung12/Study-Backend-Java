package io.whatap.product.global.exception.error;

import io.whatap.product.global.annotation.SwaggerAPIError;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    PRODUCT_NOT_FOUND(HttpStatus.NOT_FOUND, "상품 정보를 찾을 수 없습니다."),
    OUT_OF_STOCK(HttpStatus.NOT_FOUND, "상품의 재고가 없습니다.");


    private final HttpStatus status;
    private final String message;
}
