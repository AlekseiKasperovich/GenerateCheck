package com.company.generatecheck.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductDto {

    private String description;
    private Double price;
}
