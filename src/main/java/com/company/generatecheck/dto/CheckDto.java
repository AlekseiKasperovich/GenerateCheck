package com.company.generatecheck.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@Builder
public class CheckDto {

    private String cashier;
    @JsonFormat(pattern = "dd.MM.yyyy HH:mm:ss")
    private LocalDateTime printed;
    private Set<ItemDto> items;
    private BigDecimal wholesaleDiscount;
    private BigDecimal taxablePrice;
    private BigDecimal tax;
    @Column(nullable = false)
    private BigDecimal priceWithTax;
    private DiscountCardDto discountCard;
    private BigDecimal promotionalDiscount;
    private BigDecimal totalPrice;
}