package com.eldorado.hhzzefitnesscenter.controller;

import com.eldorado.hhzzefitnesscenter.dto.CustomerSaveDTO;
import com.eldorado.hhzzefitnesscenter.dto.CustomerWeightAndHeightRequestDTO;
import com.eldorado.hhzzefitnesscenter.dto.CustomerWeightAndHeightResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

public interface CustomerController {

    ResponseEntity<CustomerSaveDTO> addCustomer(CustomerSaveDTO customerSaveDTO);

    ResponseEntity<CustomerWeightAndHeightResponseDTO> addCustomerWeightAndHeight(Long id, CustomerWeightAndHeightRequestDTO customerWeightAndHeightRequestDTO);

    @GetMapping("/bmi/{id}")
    public void getCustomerBMI(@PathVariable Long id);

    @PutMapping("/edit/{id}")
    public void editCustomerWeightAndHeight(@PathVariable Long id, double newWeight, double newHeight);
}
