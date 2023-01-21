package com.eldorado.hhzzefitnesscenter.service;

import com.eldorado.hhzzefitnesscenter.model.Customer;
import org.springframework.stereotype.Service;

@Service
public interface CustomerService {
    Double bmiCalculator(Customer customer);
    Long getNextVal();
}
