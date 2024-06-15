package io.whatap.order.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UpdateAddressOrderRequest {
    @NotEmpty(message = "주문자 주소(address)를 작성해주세요.")
    private String address;
}
