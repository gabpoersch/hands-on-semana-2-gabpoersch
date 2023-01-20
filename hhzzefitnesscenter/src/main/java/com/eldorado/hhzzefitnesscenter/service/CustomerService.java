package com.eldorado.hhzzefitnesscenter.service;

import com.eldorado.hhzzefitnesscenter.model.Customer;

public class CustomerService {

    public double bmiCalculator(Customer customer) {
            double weight = customer.getWeight();
            double height = customer.getHeight();
            return weight / (height * height);
    }

}
