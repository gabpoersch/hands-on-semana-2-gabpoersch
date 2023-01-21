package com.eldorado.hhzzefitnesscenter.service;

import com.eldorado.hhzzefitnesscenter.model.Customer;

public interface CustomerService {
    Double bmiCalculator(Customer customer);

    Long getNextVal();
}
