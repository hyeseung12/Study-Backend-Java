package io.whatap.order.global.client;

import io.whatap.order.dto.product.ProductResponse;
import io.whatap.order.dto.product.UpdateInventoryProductRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@FeignClient(name = "product", url = "http://localhost:8082/api/product")
public interface ProductClient {
    @GetMapping("/{id}")
    ProductResponse findByProductId(@PathVariable("id") Long id);

    @PutMapping("/stock/{id}")
    ProductResponse updateStockByProductId(@PathVariable("id") Long id, @RequestBody @Valid UpdateInventoryProductRequest request);
}
