package io.whatap.product.global.annotation;

import io.whatap.product.global.exception.error.ErrorCode;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SwaggerAPIErrors {
    ErrorCode[] value();
}
