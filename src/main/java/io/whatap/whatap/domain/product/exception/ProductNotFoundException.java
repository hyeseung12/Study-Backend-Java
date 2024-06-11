package io.whatap.whatap.domain.product.exception;

import io.whatap.whatap.global.exception.error.BusinessException;
import io.whatap.whatap.global.exception.error.ErrorCode;

public class ProductNotFoundException extends BusinessException {
    public static final BusinessException EXCEPTION = new ProductNotFoundException();
    private ProductNotFoundException() { super(ErrorCode.PRODUCT_NOT_FOUND); }
}