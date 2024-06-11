package io.whatap.whatap.domain.order;

import io.whatap.whatap.domain.order.dto.AddOrderRequest;
import io.whatap.whatap.domain.order.dto.OrderResponse;
import io.whatap.whatap.domain.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/order")
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    public OrderResponse orderProduct(@RequestBody @Valid AddOrderRequest request) {
        return orderService.save(request);
    }
}
