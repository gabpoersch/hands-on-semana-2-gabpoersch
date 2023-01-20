package com.eldorado.hhzzefitnesscenter.controller;

import com.eldorado.hhzzefitnesscenter.model.Customer;
import com.eldorado.hhzzefitnesscenter.repository.CustomerRepository;
import com.eldorado.hhzzefitnesscenter.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerControllerImpl implements CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CustomerService customerService;

    @Override
    public void addCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void addCustomerWeightAndHeight(Long id, double weight, double height) {
        Customer customer = customerRepository.findById(String.valueOf(id)).orElse(null);

        if (customer != null) {
            customer.setWeight(weight);
            customer.setHeight(height);
            customerRepository.save(customer);
        }
    }

    @Override
    public void getCustomerBMI(Long id) {
        Customer customer = customerRepository.findById(String.valueOf(id)).orElse(null);
        customerService.bmiCalculator(customer);
    }

    @Override
    public void editCustomerWeightAndHeight(Long id, double newWeight, double newHeight) {
        Customer customer = customerRepository.findById(String.valueOf(id)).orElse(null);
        if (customer != null) {
            customer.setWeight(newWeight);
            customer.setHeight(newHeight);
            customerRepository.save(customer);
        }

    }

}
