package com.company.generatecheck.controller;

import com.company.generatecheck.builder.CheckBuilder;
import com.company.generatecheck.dto.CheckDto;
import com.company.generatecheck.dto.OrderDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


import java.util.Set;

@RestController
@RequestMapping(value = "/check")
@RequiredArgsConstructor
public class CheckController {

    private final CheckBuilder checkBuilder;

    @PostMapping
    public CheckDto createCheck(@RequestBody Set<OrderDto> products, @RequestParam(required = false) Long cardId) {
        return checkBuilder.buildCheck(products, cardId);
    }

}
