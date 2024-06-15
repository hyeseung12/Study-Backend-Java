package io.whatap.order.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.whatap.order.dto.order.AddOrderRequest;
import io.whatap.order.dto.order.OrderResponse;
import io.whatap.order.dto.order.UpdateAddressOrderRequest;
import io.whatap.order.dto.order.UpdateQuantityOrderRequest;
import io.whatap.order.global.annotation.SwaggerAPIError;
import io.whatap.order.global.annotation.SwaggerAPIErrors;
import io.whatap.order.global.exception.error.ErrorCode;
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
@Tag(name = "orders", description = "주문 API")
public class OrderController {
    private final OrderService orderService;

    @Operation(summary = "주문 등록", description = "새 주문을 등록합니다.")
    @SwaggerAPIErrors({ErrorCode.OUT_OF_STOCK, ErrorCode.PRODUCT_NOT_FOUND})
    @PostMapping
    public ResponseEntity<OrderResponse> addOrder(@RequestBody @Valid AddOrderRequest request) {
        OrderResponse order = orderService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(order);
    }

    @Operation(summary = "주문 리스트 조회", description = "주문 리스트를 조회합니다.")
    @GetMapping
    public ResponseEntity<List<OrderResponse>> getOrders() {
        List<OrderResponse> orders = orderService.findAll();
        return ResponseEntity.ok(orders);
    }

    @Operation(summary = "주문 조회", description = "등록한 주문의 정보를 조회합니다.")
    @SwaggerAPIError(ErrorCode.ORDER_NOT_FOUND)
    @GetMapping("/{id}")
    public ResponseEntity<OrderResponse> getOrder(@PathVariable("id") Long id) {
        OrderResponse order = orderService.findById(id);
        return ResponseEntity.ok(order);
    }

    @Operation(summary = "주문 주소 수정", description = "등록한 주문의 주소를 수정합니다.")
    @SwaggerAPIError(ErrorCode.ORDER_NOT_FOUND)
    @PutMapping("/address/{id}")
    public ResponseEntity<OrderResponse> changeAddressOrder(
            @PathVariable("id") Long id,
            @RequestBody @Valid UpdateAddressOrderRequest request
    ) {
        OrderResponse order = orderService.updateAddress(id, request);
        return ResponseEntity.ok(order);
    }

    @Operation(summary = "주문 재고 수정", description = "등록한 주문의 재고를 수정합니다.")
    @SwaggerAPIErrors({ErrorCode.ORDER_NOT_FOUND, ErrorCode.OUT_OF_STOCK, ErrorCode.PRODUCT_NOT_FOUND})
    @PutMapping("/quantity/{id}")
    public ResponseEntity<OrderResponse> changeQuantityOrder(
            @PathVariable("id") Long id,
            @RequestBody @Valid UpdateQuantityOrderRequest request
    ) {
        OrderResponse order = orderService.updateQuantity(id, request);
        return ResponseEntity.ok(order);
    }

    @Operation(summary = "주문 삭제", description = "등록한 주문을 삭제합니다.")
    @SwaggerAPIError(ErrorCode.ORDER_NOT_FOUND)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable("id") Long id) {
        orderService.delete(id);
        return ResponseEntity.ok().build();
    }
}
