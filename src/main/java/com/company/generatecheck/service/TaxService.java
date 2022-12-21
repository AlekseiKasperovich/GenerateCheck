package com.company.generatecheck.service;

import java.math.BigDecimal;

public interface TaxService {

    BigDecimal getTax();

    BigDecimal getPriceWithTax(BigDecimal taxablePrice);
}
