package com.company.generatecheck.service.impl;

import com.company.generatecheck.model.Item;
import com.company.generatecheck.model.Product;
import com.company.generatecheck.repository.ItemRepository;
import com.company.generatecheck.service.ItemService;
import com.company.generatecheck.service.WholesaleDiscountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;
    private final WholesaleDiscountService wholesaleDiscountService;

    private static final Double ZERO = 0.0;

    @Override
    public Set<Item> createItems(Map<Product, Integer> foundProducts) {
        List<Item> items = new ArrayList<>();
        for (Map.Entry<Product, Integer> entry : foundProducts.entrySet()) {
            Product product = entry.getKey();
            Integer qty = entry.getValue();
            Item item = Item.builder().product(product).qty(qty).total(product.getPrice() * qty).wholesaleDiscount(ZERO).build();
            if (qty > 5) {
                Double total = item.getTotal();
                Double discount = total * wholesaleDiscountService.getWholesaleDiscount();
                item.setTotal(total - discount);
                item.setWholesaleDiscount(discount);
            }
            items.add(item);
        }
        return itemRepository.saveAllAndFlush(items).stream().collect(Collectors.toSet());
    }
}
