package com.company.generatecheck.service.impl;

import com.company.generatecheck.service.CashierService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class CashierServiceImpl implements CashierService {

    @Value("${app.cashier.number}")
    private String cashierNumber;

    @Override
    public String getCashierNumber() {
        return cashierNumber;
    }
}
