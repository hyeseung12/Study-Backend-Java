package io.whatap.whatap.domain.product.repository;

import io.whatap.whatap.domain.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
