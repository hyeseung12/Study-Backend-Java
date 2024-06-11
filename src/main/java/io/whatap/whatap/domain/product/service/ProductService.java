package io.whatap.whatap.domain.product.service;

import io.whatap.whatap.domain.product.dto.AddProductRequest;
import io.whatap.whatap.domain.product.dto.ProductResponse;
import io.whatap.whatap.domain.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    @Transactional
    public ProductResponse save(AddProductRequest request) {
        return new ProductResponse(productRepository.save(request.toEntity()));
    }
}
