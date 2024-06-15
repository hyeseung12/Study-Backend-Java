package io.whatap.order.dto.order;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UpdateAddressOrderRequest {
    @Schema(description = "주문 주소")
    @NotEmpty(message = "주문자 주소(address)를 작성해주세요.")
    private String address;
}
