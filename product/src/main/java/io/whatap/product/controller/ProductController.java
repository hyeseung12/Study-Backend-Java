package io.whatap.product.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.whatap.product.dto.AddProductRequest;
import io.whatap.product.dto.ProductResponse;
import io.whatap.product.dto.UpdateInventoryProductRequest;
import io.whatap.product.dto.UpdateProductRequest;
import io.whatap.product.global.annotation.SwaggerAPIError;
import io.whatap.product.global.annotation.SwaggerAPIErrors;
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
@Tag(name = "product", description = "상품 API")
public class ProductController {
    private final ProductService productService;

    @Operation(summary = "상품 등록", description = "새 상품을 등록합니다.")
    @PostMapping
    public ResponseEntity<ProductResponse> addProduct(@RequestBody @Valid AddProductRequest request) {
        ProductResponse product = productService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(product);
    }

    @Operation(summary = "상품 리스트 조회", description = "페이지로 상품 리스트를 조회합니다.")
    @GetMapping
    public ResponseEntity<List<ProductResponse>> getProductsByPagination(Pageable pageable) {
        List<ProductResponse> products = productService.findAll(pageable).getContent();
        return ResponseEntity.ok()
                .body(products);
    }

    @Operation(summary = "상품 조회", description = "등록한 상품의 정보를 조회합니다.")
    @SwaggerAPIError(ErrorCode.PRODUCT_NOT_FOUND)
    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProduct(@PathVariable Long id) {
        ProductResponse product = productService.findById(id);
        return ResponseEntity.ok()
                .body(product);
    }

    @Operation(summary = "상품 개수 조회", description = "등록한 상품의 수를 구합니다.")
    @GetMapping("/count")
    public ResponseEntity<Long> getProductCount() {
        Long count = productService.countAll();
        return ResponseEntity.ok()
                .body(count);
    }

    @Operation(summary = "상품 정보 수정", description = "등록한 상품의 정보를 수정합니다.")
    @SwaggerAPIError(ErrorCode.PRODUCT_NOT_FOUND)
    @PutMapping("/info/{id}")
    public ResponseEntity<ProductResponse> updateInfoProduct(
            @PathVariable Long id,
            @RequestBody @Valid UpdateProductRequest request
    ) {
        ProductResponse product = productService.update(id, request);
        return ResponseEntity.ok()
                .body(product);
    }

    @Operation(summary = "상품 재고 수량 수정", description = "등록한 상품의 재고 수량을 수정합니다.")
    @SwaggerAPIErrors({ErrorCode.PRODUCT_NOT_FOUND, ErrorCode.OUT_OF_STOCK})
    @PutMapping("/stock/{id}")
    public ResponseEntity<ProductResponse> updateStockProduct(
            @PathVariable Long id,
            @RequestBody @Valid UpdateInventoryProductRequest request
    ) {
        ProductResponse product = productService.updateInventory(id, request);

        return ResponseEntity.ok()
                .body(product);
    }

    @Operation(summary = "상품 삭제", description = "등록한 상품을 삭제합니다.")
    @SwaggerAPIError(ErrorCode.PRODUCT_NOT_FOUND)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.delete(id);
        return ResponseEntity.ok()
                .build();
    }
}
