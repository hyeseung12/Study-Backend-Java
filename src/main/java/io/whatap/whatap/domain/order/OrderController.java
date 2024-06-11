package io.whatap.whatap.domain.order;

import io.whatap.whatap.domain.order.dto.AddOrderRequest;
import io.whatap.whatap.domain.order.dto.OrderResponse;
import io.whatap.whatap.domain.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
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
    public ResponseEntity<OrderResponse> orderProduct(@RequestBody @Valid AddOrderRequest request) {
        OrderResponse order = orderService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(order);
    }

    @GetMapping
    public ResponseEntity<List<OrderResponse>> getOrders() {
        List<OrderResponse> orderList = orderService.findAll();
        return ResponseEntity.ok()
                .body(orderList);
    }
}
