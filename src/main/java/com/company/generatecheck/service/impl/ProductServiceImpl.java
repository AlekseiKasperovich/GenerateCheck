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
import java.util.stream.IntStream;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public Map<Product, Integer> findProductsById(Set<OrderDto> products) {
        List<Long> ids = products.stream().map(OrderDto::getProductId).collect(Collectors.toList());
        List<Integer> amount = products.stream().map(OrderDto::getQty).collect(Collectors.toList());
        System.out.println(ids);
        System.out.println(amount);
        List<Product> foundProducts = productRepository.findAllById(ids);
        if (foundProducts.size() != ids.size()) {
            throw new ProductNotFoundException("These products are not found: " + checkNotFoundProducts(foundProducts, ids));
        }
        System.out.println(Arrays.asList(foundProducts));
        return IntStream.range(0, foundProducts.size()).boxed()
                .collect(Collectors.toMap(foundProducts::get, amount::get));
    }

    private List<Long> checkNotFoundProducts(List<Product> foundProducts, List<Long> ids) {
        List<Long> productIds = foundProducts.stream().map(Product::getId).collect(Collectors.toList());
        ids.removeAll(productIds);
        return ids;
    }
}
