package com.company.generatecheck.service.impl;

import com.company.generatecheck.model.Item;
import com.company.generatecheck.service.WholesaleDiscountService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Set;

@Service
public class WholesaleDiscountServiceImpl implements WholesaleDiscountService {

    @Value("${app.wholesale.discount}")
    private BigDecimal wholesaleDiscount;

    @Override
    public BigDecimal getWholesaleDiscount() {
        return wholesaleDiscount;
    }

    @Override
    public BigDecimal getTotalDiscount(Set<Item> items) {
        BigDecimal totalDiscount = BigDecimal.valueOf(0);
        for (Item item : items) {
            totalDiscount = totalDiscount.add(item.getWholesaleDiscount());
        }
        return totalDiscount.setScale(2, RoundingMode.CEILING);
    }
}
