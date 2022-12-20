package com.company.generatecheck.service.impl;

import com.company.generatecheck.model.DiscountCard;
import com.company.generatecheck.model.Item;
import com.company.generatecheck.service.PriceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;


@Service
@RequiredArgsConstructor
public class PriceServiceImpl implements PriceService {

    @Override
    public Double getTaxablePrice(Set<Item> items) {
        Double taxablePrice = 0.0;
        for (Item item : items) {
            taxablePrice += item.getTotal();
        }
        return taxablePrice;
    }

    @Override
    public Double getPromotionalDiscount(Double taxablePrice, DiscountCard discountCard) {
        return taxablePrice*discountCard.getDiscount();
    }

    @Override
    public Double getTotalPrice(Double priceWithTax, Double promotionalDiscount) {
        return priceWithTax-promotionalDiscount;
    }
}
