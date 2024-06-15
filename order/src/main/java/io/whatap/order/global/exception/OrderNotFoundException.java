package io.whatap.order.global.exception;

import io.whatap.order.global.exception.error.BusinessException;
import io.whatap.order.global.exception.error.ErrorCode;

public class OrderNotFoundException extends BusinessException {
    public static final BusinessException EXCEPTION = new OrderNotFoundException();
    private OrderNotFoundException() { super(ErrorCode.ORDER_NOT_FOUND); }
}