package io.whatap.order.global.client;

import io.whatap.order.dto.ProductResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "product", url = "http://localhost:8082/api/product")
public interface ProductClient {
    @GetMapping("/{id}")
    ProductResponse findByProductId(@PathVariable("id") Long id);
}
