package com.company.generatecheck.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class ProductDto {

    private String description;
    private BigDecimal price;
}
