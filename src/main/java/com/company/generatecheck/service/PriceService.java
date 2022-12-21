package com.company.generatecheck.service;

import com.company.generatecheck.model.DiscountCard;
import com.company.generatecheck.model.Item;

import java.math.BigDecimal;
import java.util.Set;

public interface PriceService {

    BigDecimal getTaxablePrice(Set<Item> items);

    BigDecimal getPromotionalDiscount(BigDecimal taxablePrice, DiscountCard discountCard);

    BigDecimal getTotalPrice(BigDecimal priceWithTax, BigDecimal promotionalDiscount);
}
