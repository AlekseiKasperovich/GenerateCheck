package com.company.generatecheck.service;

public interface TaxService {

   Double getTax();

    Double getPriceWithTax(Double taxablePrice);
}
