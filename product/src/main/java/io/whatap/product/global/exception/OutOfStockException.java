package io.whatap.product.global.exception;

import io.whatap.product.global.exception.error.BusinessException;
import io.whatap.product.global.exception.error.ErrorCode;

public class OutOfStockException extends BusinessException {
    public static final BusinessException EXCEPTION = new OutOfStockException();
    private OutOfStockException() { super(ErrorCode.OUT_OF_STOCK); }
}