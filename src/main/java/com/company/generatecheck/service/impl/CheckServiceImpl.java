package com.company.generatecheck.service.impl;

import com.company.generatecheck.dto.CheckDto;
import com.company.generatecheck.dto.OrderDto;
import com.company.generatecheck.exception.CheckNotFoundException;
import com.company.generatecheck.mapper.CheckMapper;
import com.company.generatecheck.model.Check;
import com.company.generatecheck.model.DiscountCard;
import com.company.generatecheck.model.Item;
import com.company.generatecheck.model.Product;
import com.company.generatecheck.repository.CheckRepository;
import com.company.generatecheck.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
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
    private final CashierService cashierService;
    private final TaxService taxService;
    private final CheckMapper checkMapper;

    @Override
    public CheckDto createCheck(Set<OrderDto> products, Long cardId) {
        Map<Product, Integer> foundProducts = productService.findProductsById(products);
        Set<Item> items = itemService.createItems(foundProducts);
        DiscountCard discountCard = null;
        if (cardId != null) {
            discountCard = discountCardService.findById(cardId);
        }
        Check check = Check.builder()
                .cashier(cashierService.getCashierNumber())
                .printed(LocalDateTime.now())
                .taxablePrice(2.0)
                .tax(taxService.getTax())
                .wholesaleDiscount(1.0)
                .promotionalDiscount(1.0)
                .totalPrice(100.0)
                .discountCard(discountCard)
                .items(items)
                .build();
        return checkMapper.convert(checkRepository.save(check));
    }

    @Override
    public CheckDto getCheck(Long id) {
        return checkMapper.convert(checkRepository.findById(id).orElseThrow(() ->
                new CheckNotFoundException(String.format("Check with id = %s is not found", id))));
    }
}