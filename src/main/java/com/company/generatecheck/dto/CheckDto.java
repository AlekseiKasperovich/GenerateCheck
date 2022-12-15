package com.company.generatecheck.dto;

import com.company.generatecheck.model.DiscountCard;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;

@Data
public class CheckDto {

    private String cashier;
    private LocalDateTime printed;
    private Integer taxablePrice;
    private Integer tax;
    private Integer totalPrice;
    private DiscountCard discountCard;
    private Set<ItemDto> items;
}
