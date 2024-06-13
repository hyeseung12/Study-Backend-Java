package io.whatap.whatap.domain.order.service;

import io.whatap.whatap.domain.order.Order;
import io.whatap.whatap.domain.order.dto.AddOrderRequest;
import io.whatap.whatap.domain.order.dto.OrderResponse;
import io.whatap.whatap.domain.order.dto.UpdateOrderRequest;
import io.whatap.whatap.domain.order.exception.OrderNotFoundException;
import io.whatap.whatap.domain.order.repository.OrderRepository;
import io.whatap.whatap.domain.product.exception.ProductNotFoundException;
import io.whatap.whatap.domain.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    @Transactional
    public OrderResponse save(AddOrderRequest request) {
        if(!productRepository.existsById(request.getProduct().getId())) throw ProductNotFoundException.EXCEPTION;
        return new OrderResponse(orderRepository.save(request.toEntity()));
    }

    @Transactional(readOnly = true)
    public List<OrderResponse> findAll() {
        return orderRepository.findAll()
                .stream()
                .map(OrderResponse::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public OrderResponse findById(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> OrderNotFoundException.EXCEPTION);

        return new OrderResponse(order);
    }

    @Transactional
    public OrderResponse update(Long id, UpdateOrderRequest request) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> OrderNotFoundException.EXCEPTION);

        order.update(
                request.getAddress(),
                request.getQuantity()
        );

        return new OrderResponse(order);
    }

    @Transactional
    public void delete(Long id) {
        if(!orderRepository.existsById(id)) throw OrderNotFoundException.EXCEPTION;
        orderRepository.deleteById(id);
    }
}
