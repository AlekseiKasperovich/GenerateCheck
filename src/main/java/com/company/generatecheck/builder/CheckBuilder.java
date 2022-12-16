package com.company.generatecheck.builder;

import com.company.generatecheck.dto.CheckDto;
import com.company.generatecheck.dto.OrderDto;

import java.util.Set;

public interface CheckBuilder {

    CheckDto buildCheck(Set<OrderDto> products, Long cardId);
}
