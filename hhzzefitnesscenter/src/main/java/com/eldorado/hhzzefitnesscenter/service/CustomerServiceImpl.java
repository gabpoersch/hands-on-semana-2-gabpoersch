package com.eldorado.hhzzefitnesscenter.service;

import com.eldorado.hhzzefitnesscenter.model.Customer;
import com.eldorado.hhzzefitnesscenter.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Double bmiCalculator(Customer customer) {
        double weight = customer.getWeight();
        double height = customer.getHeight();
        return weight / (height * height);
    }

    public Long getNextVal() {
        Long nextVal = customerRepository.count() + 1;

        return nextVal;
    }

}
