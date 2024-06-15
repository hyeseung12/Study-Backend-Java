package io.whatap.product.controller;

import io.whatap.product.dto.AddProductRequest;
import io.whatap.product.dto.ProductResponse;
import io.whatap.product.dto.UpdateInventoryProductRequest;
import io.whatap.product.dto.UpdateProductRequest;
import io.whatap.product.global.annotation.SwaggerAPIError;
import io.whatap.product.global.exception.error.ErrorCode;
import io.whatap.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/product")
public class ProductController {
    private final ProductService productService;

    @SwaggerAPIError(ErrorCode.PRODUCT_NOT_FOUND)
    @PostMapping
    public ResponseEntity<ProductResponse> addProduct(@RequestBody @Valid AddProductRequest request) {
        ProductResponse product = productService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(product);
    }

    @GetMapping
    public ResponseEntity<List<ProductResponse>> getProductsByPagination(Pageable pageable) {
        List<ProductResponse> products = productService.findAll(pageable).getContent();
        return ResponseEntity.ok()
                .body(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProduct(@PathVariable Long id) {
        ProductResponse product = productService.findById(id);
        return ResponseEntity.ok()
                .body(product);
    }

    @GetMapping("/count")
    public ResponseEntity<Long> getProductCount() {
        Long count = productService.countAll();
        return ResponseEntity.ok()
                .body(count);
    }

    @PutMapping("/info/{id}")
    public ResponseEntity<ProductResponse> updateInfoProduct(
            @PathVariable Long id,
            @RequestBody @Valid UpdateProductRequest request
    ) {
        ProductResponse product = productService.update(id, request);
        return ResponseEntity.ok()
                .body(product);
    }

    @PutMapping("/stock/{id}")
    public ResponseEntity<ProductResponse> updateStockProduct(
            @PathVariable Long id,
            @RequestBody @Valid UpdateInventoryProductRequest request
    ) {
        ProductResponse product = productService.updateInventory(id, request);

        return ResponseEntity.ok()
                .body(product);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.delete(id);
        return ResponseEntity.ok()
                .build();
    }
}
