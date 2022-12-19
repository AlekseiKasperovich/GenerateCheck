package com.company.generatecheck.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@Builder
public class CheckDto {

    private String cashier;
    @JsonFormat(pattern = "dd.MM.yyyy HH:mm:ss")
    private LocalDateTime printed;
    private Set<ItemDto> items;
    private Double wholesaleDiscount;
    private Double taxablePrice;
    private Integer tax;
    private DiscountCardDto discountCard;
    private Double promotionalDiscount;
    private Double totalPrice;
}