package com.company.generatecheck.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ItemDto {

    private Integer qty;
    private ProductDto product;
    private Double wholesaleDiscount;
    private Double total;
}