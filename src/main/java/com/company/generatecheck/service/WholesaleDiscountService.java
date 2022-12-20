package com.company.generatecheck.service;

import com.company.generatecheck.model.Item;

import java.util.Set;

public interface WholesaleDiscountService {

    Double getWholesaleDiscount();

    Double getTotalDiscount(Set<Item> items);
}
