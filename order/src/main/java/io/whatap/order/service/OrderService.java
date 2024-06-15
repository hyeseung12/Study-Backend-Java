package io.whatap.order.service;

import io.whatap.order.dto.AddOrderRequest;
import io.whatap.order.dto.OrderResponse;
import io.whatap.order.dto.ProductResponse;
import io.whatap.order.global.client.ProductClient;
import io.whatap.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final ProductClient productClient;
    private final OrderRepository orderRepository;

    @Transactional
    public OrderResponse save(AddOrderRequest request) {
        boolean isCheck = checkProductInventory(request.getProductId(), request.getQuantity());

        // 재고량이 부족한 경우
        if(!isCheck) return null;


    }

    // 재고량 체크 (반환값 : productId)
    public boolean checkProductInventory(Long productId, Long quantity) {
        ProductResponse product = productClient.findByProductId(productId);
        return quantity <= product.getInventory();
    }
}
