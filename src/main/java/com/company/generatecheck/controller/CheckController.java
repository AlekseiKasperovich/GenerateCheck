package com.company.generatecheck.controller;

import com.company.generatecheck.dto.CheckDto;
import com.company.generatecheck.dto.OrderDto;
import com.company.generatecheck.service.CheckService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping(value = "/check")
@RequiredArgsConstructor
public class CheckController {

    private final CheckService checkService;

    @PostMapping
    public CheckDto createCheck(@RequestBody Set<OrderDto> products, @RequestParam(required = false) Long cardId) {
        return checkService.createCheck(products, cardId);
    }

}
