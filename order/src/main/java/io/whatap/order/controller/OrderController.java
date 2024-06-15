package io.whatap.order.controller;

import io.whatap.order.dto.order.AddOrderRequest;
import io.whatap.order.dto.order.OrderResponse;
import io.whatap.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<OrderResponse> addOrder(@RequestBody @Valid AddOrderRequest request) {
        OrderResponse order = orderService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(order);
    }
}
