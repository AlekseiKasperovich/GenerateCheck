package com.company.generatecheck.service;

import com.company.generatecheck.dto.CheckDto;
import com.company.generatecheck.dto.OrderDto;

import java.util.Set;

public interface CheckService {
    CheckDto createCheck(Set<OrderDto> products, Long cardId);
}
