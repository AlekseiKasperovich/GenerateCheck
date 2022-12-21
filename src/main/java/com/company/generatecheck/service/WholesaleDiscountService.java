package com.company.generatecheck.service;

import com.company.generatecheck.model.Item;

import java.math.BigDecimal;
import java.util.Set;

public interface WholesaleDiscountService {

    BigDecimal getWholesaleDiscount();

    BigDecimal getTotalDiscount(Set<Item> items);
}
