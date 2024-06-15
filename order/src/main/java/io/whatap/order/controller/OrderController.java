package io.whatap.order.controller;

import feign.Response;
import io.whatap.order.dto.order.AddOrderRequest;
import io.whatap.order.dto.order.OrderResponse;
import io.whatap.order.dto.order.UpdateAddressOrderRequest;
import io.whatap.order.dto.order.UpdateQuantityOrderRequest;
import io.whatap.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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

    @GetMapping
    public ResponseEntity<List<OrderResponse>> getOrders() {
        List<OrderResponse> orders = orderService.findAll();
        return ResponseEntity.ok(orders);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderResponse> getOrder(@PathVariable("id") Long id) {
        OrderResponse order = orderService.findById(id);
        return ResponseEntity.ok(order);
    }

    @PutMapping("/address/{id}")
    public ResponseEntity<OrderResponse> changeAddressOrder(
            @PathVariable("id") Long id,
            @RequestBody @Valid UpdateAddressOrderRequest request
    ) {
        OrderResponse order = orderService.updateAddress(id, request);
        return ResponseEntity.ok(order);
    }

    @PutMapping("/quantity/{id}")
    public ResponseEntity<OrderResponse> changeQuantityOrder(
            @PathVariable("id") Long id,
            @RequestBody @Valid UpdateQuantityOrderRequest request
    ) {
        OrderResponse order = orderService.updateQuantity(id, request);
        return ResponseEntity.ok(order);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable("id") Long id) {
        orderService.delete(id);
        return ResponseEntity.ok().build();
    }
}
