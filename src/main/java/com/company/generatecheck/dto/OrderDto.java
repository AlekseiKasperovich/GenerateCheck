package com.company.generatecheck.dto;

import lombok.*;

import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {

    private Long productId;
    private Short qty;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDto orderDto = (OrderDto) o;
        return productId.equals(orderDto.productId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId);
    }
}
