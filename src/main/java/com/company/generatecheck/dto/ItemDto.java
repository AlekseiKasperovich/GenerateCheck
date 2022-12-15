package com.company.generatecheck.dto;

import lombok.Data;


@Data
public class ItemDto {

    private Short qty;
    private ProductDto product;
    private Integer total;
}
