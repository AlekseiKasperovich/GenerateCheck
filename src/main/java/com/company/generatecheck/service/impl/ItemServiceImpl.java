package com.company.generatecheck.service.impl;

import com.company.generatecheck.model.Item;
import com.company.generatecheck.model.Product;
import com.company.generatecheck.repository.ItemRepository;
import com.company.generatecheck.service.ItemService;
import com.company.generatecheck.service.WholesaleDiscountService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;
    private final WholesaleDiscountService wholesaleDiscountService;

    @Value("${app.wholesale.count}")
    private Integer wholesaleCount;

    @Override
    public Set<Item> createItems(Map<Product, Integer> foundProducts) {
        List<Item> items = new ArrayList<>();
        for (Map.Entry<Product, Integer> entry : foundProducts.entrySet()) {
            Product product = entry.getKey();
            Integer qty = entry.getValue();
            Item item = Item.builder()
                    .product(product)
                    .qty(qty)
                    .total(product.getPrice().multiply(BigDecimal.valueOf(qty)))
                    .wholesaleDiscount(BigDecimal.valueOf(0))
                    .build();
            if (qty > wholesaleCount) {
                BigDecimal total = item.getTotal();
                BigDecimal discount = total.multiply(
                        wholesaleDiscountService.getWholesaleDiscount()).setScale(2, RoundingMode.CEILING);
                item.setTotal(total.subtract(discount));
                item.setWholesaleDiscount(discount);
            }
            items.add(item);
        }
        return itemRepository.saveAllAndFlush(items).stream().collect(Collectors.toSet());
    }
}
