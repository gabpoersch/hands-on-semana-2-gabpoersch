package com.eldorado.hhzzefitnesscenter.controller;

import com.eldorado.hhzzefitnesscenter.dto.CustomerSaveDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface CustomerController {
    @PostMapping(consumes = "application/json")
    ResponseEntity<CustomerSaveDTO> addCustomer(@RequestBody CustomerSaveDTO customerSaveDTO);

    @PutMapping("/data/{id}")
    public void addCustomerWeightAndHeight(@PathVariable Long id, double weight, double height);

    @GetMapping("/bmi/{id}")
    public void getCustomerBMI(@PathVariable Long id);

    @PutMapping("/edit/{id}")
    public void editCustomerWeightAndHeight(@PathVariable Long id, double newWeight, double newHeight);
}
