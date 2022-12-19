package com.company.generatecheck.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Objects;

@Data
public class OrderDto {

    @NotNull
    private Long productId;

    @NotNull
    private Integer qty;

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
