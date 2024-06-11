package io.whatap.whatap.domain.order.repository;

import io.whatap.whatap.domain.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
