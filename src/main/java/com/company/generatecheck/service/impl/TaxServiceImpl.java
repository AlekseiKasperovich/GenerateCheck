package com.company.generatecheck.service.impl;

import com.company.generatecheck.service.TaxService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TaxServiceImpl implements TaxService {

    @Value("${app.tax}")
    private Double tax;

    @Override
    public Double getTax() {
        return tax;
    }
}
