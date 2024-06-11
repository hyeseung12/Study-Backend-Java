package io.whatap.whatap.domain.order.service;

import io.whatap.whatap.domain.order.dto.AddOrderRequest;
import io.whatap.whatap.domain.order.dto.OrderResponse;
import io.whatap.whatap.domain.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;

    @Transactional
    public OrderResponse save(AddOrderRequest request) {
        return new OrderResponse(orderRepository.save(request.toEntity()));
    }
}
