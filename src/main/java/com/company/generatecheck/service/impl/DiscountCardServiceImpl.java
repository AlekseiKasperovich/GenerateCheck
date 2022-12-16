package com.company.generatecheck.service.impl;

import com.company.generatecheck.exception.DiscountCardNotFoundException;
import com.company.generatecheck.model.DiscountCard;
import com.company.generatecheck.repository.DiscountCardRepository;
import com.company.generatecheck.service.DiscountCardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class DiscountCardServiceImpl implements DiscountCardService {

    private final DiscountCardRepository discountCardRepository;

    @Override
    public DiscountCard findById(Long cardId) {
        return discountCardRepository.findById(cardId).orElseThrow(() ->
                new DiscountCardNotFoundException(String.format("DiscountCard with id = %s is not found", cardId)));
    }
}
