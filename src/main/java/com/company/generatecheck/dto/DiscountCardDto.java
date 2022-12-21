package com.company.generatecheck.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class DiscountCardDto {

    private BigDecimal discount;
}
