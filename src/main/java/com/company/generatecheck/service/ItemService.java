package com.company.generatecheck.service;

import com.company.generatecheck.model.Item;
import com.company.generatecheck.model.Product;

import java.util.Map;
import java.util.Set;

public interface ItemService {
    Set<Item> createItems(Map<Product, Integer> foundProducts);
}
