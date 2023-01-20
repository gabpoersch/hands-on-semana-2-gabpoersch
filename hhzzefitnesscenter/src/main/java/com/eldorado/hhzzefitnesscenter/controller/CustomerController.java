package com.eldorado.hhzzefitnesscenter.controller;

import com.eldorado.hhzzefitnesscenter.model.Customer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

public interface CustomerController {
//    @PostMapping
    public void addCustomer(Customer customer);

//    @PutMapping("/data/{id}")
    public void addCustomerWeightAndHeight(Long id, double weight, double height);

//    @GetMapping("/data/{id}")
    public void getCustomerBMI(Long id);

//    @PutMapping("/data/{id}")
    public void editCustomerWeightAndHeight(Long id, double newWeight, double newHeight);
}
