package com.company.generatecheck.service.impl;

import com.company.generatecheck.model.DiscountCard;
import com.company.generatecheck.model.Item;
import com.company.generatecheck.service.PriceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Set;


@Service
@RequiredArgsConstructor
public class PriceServiceImpl implements PriceService {

    @Override
    public BigDecimal getTaxablePrice(Set<Item> items) {
        BigDecimal taxablePrice = BigDecimal.valueOf(0);
        for (Item item : items) {
           taxablePrice= taxablePrice.add(item.getTotal());
        }
        return taxablePrice;
    }

    @Override
    public BigDecimal getPromotionalDiscount(BigDecimal taxablePrice, DiscountCard discountCard) {
        return taxablePrice.multiply(discountCard.getDiscount()).setScale(2, RoundingMode.CEILING);
    }

    @Override
    public BigDecimal getTotalPrice(BigDecimal priceWithTax, BigDecimal promotionalDiscount) {
        return priceWithTax.subtract(promotionalDiscount).setScale(2, RoundingMode.CEILING);
    }
}
