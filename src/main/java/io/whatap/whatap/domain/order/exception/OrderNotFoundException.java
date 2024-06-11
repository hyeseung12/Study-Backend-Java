package io.whatap.whatap.domain.order.exception;

import io.whatap.whatap.global.exception.error.BusinessException;
import io.whatap.whatap.global.exception.error.ErrorCode;

public class OrderNotFoundException extends BusinessException {
    public static final BusinessException EXCEPTION = new OrderNotFoundException();
    private OrderNotFoundException() { super(ErrorCode.PRODUCT_NOT_FOUND); }
}