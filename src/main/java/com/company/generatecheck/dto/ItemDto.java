package com.company.generatecheck.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class ItemDto {

    private Integer qty;
    private ProductDto product;
    private BigDecimal wholesaleDiscount;
    private BigDecimal total;
}