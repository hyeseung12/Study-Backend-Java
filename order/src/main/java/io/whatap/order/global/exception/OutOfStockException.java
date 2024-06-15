package io.whatap.order.global.exception;

import io.whatap.order.global.exception.error.BusinessException;
import io.whatap.order.global.exception.error.ErrorCode;

public class OutOfStockException extends BusinessException {
    public static final BusinessException EXCEPTION = new OutOfStockException();
    private OutOfStockException() { super(ErrorCode.OUT_OF_STOCK); }
}