package io.whatap.product.global.exception;

import io.whatap.product.global.exception.error.BusinessException;
import io.whatap.product.global.exception.error.ErrorCode;

public class ProductNotFoundException extends BusinessException {
    public static final BusinessException EXCEPTION = new ProductNotFoundException();
    private ProductNotFoundException() { super(ErrorCode.PRODUCT_NOT_FOUND); }
}