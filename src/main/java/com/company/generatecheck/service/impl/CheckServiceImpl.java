package com.company.generatecheck.service.impl;

import com.company.generatecheck.dto.CheckDto;
import com.company.generatecheck.dto.OrderDto;
import com.company.generatecheck.model.DiscountCard;
import com.company.generatecheck.model.Item;
import com.company.generatecheck.model.Product;
import com.company.generatecheck.repository.CheckRepository;
import com.company.generatecheck.service.CheckService;
import com.company.generatecheck.service.DiscountCardService;
import com.company.generatecheck.service.ItemService;
import com.company.generatecheck.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;


@Service
@RequiredArgsConstructor
@Transactional
public class CheckServiceImpl implements CheckService {

    private final CheckRepository checkRepository;
    private final ProductService productService;
    private final ItemService itemService;
    private final DiscountCardService discountCardService;


    @Override
    public CheckDto createCheck(Set<OrderDto> products, Long cardId) {
        Map<Product, Integer> foundProducts = productService.findProductsById(products);
        for (Map.Entry<Product, Integer> entry : foundProducts.entrySet()) {
            System.out.println(entry.getKey().getId()+" "+entry.getValue());
        }
        Set<Item> items = itemService.createItems(foundProducts);
       
        DiscountCard discountCard = null;
        if (cardId != null) {
            discountCard = discountCardService.findById(cardId);
        }

        return null;
    }
}
