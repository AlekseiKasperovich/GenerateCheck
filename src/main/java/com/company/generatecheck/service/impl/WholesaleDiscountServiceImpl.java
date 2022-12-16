package com.company.generatecheck.service.impl;

import com.company.generatecheck.service.WholesaleDiscountService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class WholesaleDiscountServiceImpl implements WholesaleDiscountService {

    @Value("${app.wholesale.discount}")
    private Double wholesaleDiscount;

    @Override
    public Double getWholesaleDiscount() {
        return wholesaleDiscount;
    }
}
