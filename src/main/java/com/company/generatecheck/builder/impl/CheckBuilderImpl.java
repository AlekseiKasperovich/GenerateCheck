package com.company.generatecheck.builder.impl;

import com.company.generatecheck.builder.CheckBuilder;
import com.company.generatecheck.dto.CheckDto;
import com.company.generatecheck.dto.OrderDto;
import com.company.generatecheck.service.CheckService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@RequiredArgsConstructor
public class CheckBuilderImpl implements CheckBuilder {

    private final CheckService checkService;

    @Override
    public CheckDto buildCheck(Set<OrderDto> products, Long cardId) {
        return checkService.createCheck(products, cardId);
    }
}
