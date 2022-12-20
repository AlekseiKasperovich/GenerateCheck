package com.company.generatecheck.service.impl;

import com.company.generatecheck.model.Item;
import com.company.generatecheck.service.WholesaleDiscountService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class WholesaleDiscountServiceImpl implements WholesaleDiscountService {

    @Value("${app.wholesale.discount}")
    private Double wholesaleDiscount;

    @Override
    public Double getWholesaleDiscount() {
        return wholesaleDiscount;
    }

    @Override
    public Double getTotalDiscount(Set<Item> items) {
        Double totalDiscount = 0.0;
        for (Item item : items) {
            totalDiscount += item.getWholesaleDiscount();
        }
        return totalDiscount;
    }
}
