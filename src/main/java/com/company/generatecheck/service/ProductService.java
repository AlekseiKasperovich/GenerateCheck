package com.company.generatecheck.service;

import com.company.generatecheck.dto.OrderDto;
import com.company.generatecheck.model.Product;

import java.util.Map;
import java.util.Set;

public interface ProductService {
    Map<Product, Integer> findProductsById(Set<OrderDto> products);
}
