package io.whatap.whatap.domain.order.service;

import io.whatap.whatap.domain.order.dto.AddOrderRequest;
import io.whatap.whatap.domain.order.dto.OrderResponse;
import io.whatap.whatap.domain.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;

    @Transactional
    public OrderResponse save(AddOrderRequest request) {
        return new OrderResponse(orderRepository.save(request.toEntity()));
    }

    @Transactional(readOnly = true)
    public List<OrderResponse> findAll() {
        return orderRepository.findAll()
                .stream()
                .map(OrderResponse::new)
                .collect(Collectors.toList());
    }
}
