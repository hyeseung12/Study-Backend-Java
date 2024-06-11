package io.whatap.whatap.domain.product.repository;

import io.whatap.whatap.domain.product.Product;
import io.whatap.whatap.domain.product.dto.ProductResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Page<ProductResponse> findAllById(Long id, Pageable pageable);
}
