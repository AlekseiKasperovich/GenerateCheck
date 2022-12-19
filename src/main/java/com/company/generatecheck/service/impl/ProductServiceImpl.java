package com.company.generatecheck.service.impl;

import com.company.generatecheck.dto.OrderDto;
import com.company.generatecheck.exception.ProductNotFoundException;
import com.company.generatecheck.model.Product;
import com.company.generatecheck.repository.ProductRepository;
import com.company.generatecheck.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public Map<Product, Integer> findProductsById(Set<OrderDto> products) {
        Map<Long, Integer> map = products.stream().collect(Collectors.toMap(OrderDto::getProductId, OrderDto::getQty));
        Set<Long> keys = map.keySet();
        List<Product> foundProducts = productRepository.findAllById(keys);
        if (foundProducts.size() != keys.size()) {
            throw new ProductNotFoundException("These products are not found: "
                    + checkNotFoundProducts(foundProducts, keys));
        }
        Map<Product, Integer> result = new HashMap<>();
        Product product;
        for (int i = 0; i < foundProducts.size(); i++) {
            product = foundProducts.get(i);
            result.put(product, map.get(product.getId()));
        }
        return result;
    }

    private Set<Long> checkNotFoundProducts(List<Product> foundProducts, Set<Long> ids) {
        List<Long> productIds = foundProducts.stream().map(Product::getId).collect(Collectors.toList());
        ids.removeAll(productIds);
        return ids;
    }
}
