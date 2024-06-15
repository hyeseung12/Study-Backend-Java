package io.whatap.order.service;

import io.whatap.order.domain.Order;
import io.whatap.order.dto.order.AddOrderRequest;
import io.whatap.order.dto.order.OrderResponse;
import io.whatap.order.dto.product.ProductResponse;
import io.whatap.order.dto.product.UpdateInventoryProductRequest;
import io.whatap.order.global.client.ProductClient;
import io.whatap.order.global.exception.OrderNotFoundException;
import io.whatap.order.global.exception.OutOfStockException;
import io.whatap.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final ProductClient productClient;
    private final OrderRepository orderRepository;

    @Transactional
    public OrderResponse save(AddOrderRequest request) {
        Long productId = request.getProductId();
        Long quantity = request.getQuantity();

        boolean isCheck = checkProductInventory(productId, quantity);

        // 재고량이 부족한 경우
        if(!isCheck) throw OutOfStockException.EXCEPTION;

        // 재고량 수정
        productClient.updateStockByProductId(
                productId,
                new UpdateInventoryProductRequest(-quantity) // 주문한 갯수만큼 차감
        );

        return new OrderResponse(orderRepository.save(request.toEntity()));
    }

    @Transactional(readOnly = true)
    public List<OrderResponse> findAll() {
        return orderRepository.findAll()
                .stream()
                .map(OrderResponse::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public OrderResponse findById(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> OrderNotFoundException.EXCEPTION);

        return new OrderResponse(order);
    }

    // 재고량 체크
    public boolean checkProductInventory(Long productId, Long quantity) {
        ProductResponse product = productClient.findByProductId(productId);
        return quantity <= product.getInventory();
    }
}
