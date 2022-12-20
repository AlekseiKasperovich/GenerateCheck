package com.company.generatecheck.service;

import com.company.generatecheck.model.DiscountCard;
import com.company.generatecheck.model.Item;

import java.util.Set;

public interface PriceService {

    Double getTaxablePrice(Set<Item> items);

    Double getPromotionalDiscount(Double taxablePrice, DiscountCard discountCard);

    Double getTotalPrice(Double priceWithTax, Double promotionalDiscount);
}
