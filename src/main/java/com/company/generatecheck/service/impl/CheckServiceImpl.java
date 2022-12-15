package com.company.generatecheck.service.impl;

import com.company.generatecheck.dto.CheckDto;
import com.company.generatecheck.dto.OrderDto;
import com.company.generatecheck.service.CheckService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
@RequiredArgsConstructor
@Transactional
public class CheckServiceImpl implements CheckService {

    @Override
    public CheckDto createCheck(Set<OrderDto> products, Long cardId) {
        return null;
    }
}
