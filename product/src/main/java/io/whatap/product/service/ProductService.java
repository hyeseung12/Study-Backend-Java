package io.whatap.product.service;

import io.whatap.product.domain.Product;
import io.whatap.product.dto.AddProductRequest;
import io.whatap.product.dto.ProductResponse;
import io.whatap.product.dto.UpdateInventoryProductRequest;
import io.whatap.product.dto.UpdateProductRequest;
import io.whatap.product.global.exception.OutOfStockException;
import io.whatap.product.global.exception.ProductNotFoundException;
import io.whatap.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    /**
     * 상품 등록
     */
    @Transactional
    public ProductResponse save(AddProductRequest request) {
        return new ProductResponse(productRepository.save(request.toEntity()));
    }

    /**
     * 상품 페이징 조회
     */
    @Transactional(readOnly = true)
    public Page<ProductResponse> findAll(Pageable pageable) {
        return productRepository.findAll(pageable)
                .map(ProductResponse::new);
    }

    /**
     * 상품 하나 조회
     */
    @Transactional(readOnly = true)
    public ProductResponse findById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> ProductNotFoundException.EXCEPTION);

        return new ProductResponse(product);
    }

    /**
     * 상품 총 갯수
     */
    @Transactional(readOnly = true)
    public Long countAll() {
        return productRepository.count();
    }

    /**
     * 상품 정보 수정
     */
    @Transactional
    public ProductResponse update(Long id, UpdateProductRequest request) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> ProductNotFoundException.EXCEPTION);

        product.updateInfo(
                request.getName(),
                request.getDescription(),
                request.getPrice()
        );

        return new ProductResponse(product);
    }

    @Transactional
    public ProductResponse updateInventory(Long id, UpdateInventoryProductRequest request) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> ProductNotFoundException.EXCEPTION);

        long inventory = product.getInventory() + request.getInventory();
        if(inventory < 0) throw OutOfStockException.EXCEPTION;

        product.updateInventory(inventory);

        return new ProductResponse(product);
    }

    /**
     * 상품 삭제
     */
    @Transactional
    public void delete(Long id) {
        if (!productRepository.existsById(id)) throw ProductNotFoundException.EXCEPTION;
        productRepository.deleteById(id);
    }
}
