package com.company.generatecheck.service.impl;

import com.company.generatecheck.service.TaxService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class TaxServiceImpl implements TaxService {

    @Value("${app.tax}")
    private BigDecimal tax;

    @Override
    public BigDecimal getTax() {
        return tax;
    }

    @Override
    public BigDecimal getPriceWithTax(BigDecimal taxablePrice) {
        return taxablePrice.multiply(getTax()).add(taxablePrice)
                .setScale(2, RoundingMode.CEILING);
    }
}
