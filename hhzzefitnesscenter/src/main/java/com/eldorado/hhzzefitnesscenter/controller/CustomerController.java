package com.eldorado.hhzzefitnesscenter.controller;

import com.eldorado.hhzzefitnesscenter.dto.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface CustomerController {

    ResponseEntity<CustomerSaveDTO> addCustomer(CustomerSaveDTO customerSaveDTO);

    ResponseEntity<CustomerBodyInfoResponseDTO> addCustomerWeightAndHeight(Long id, CustomerWeightAndHeightRequestDTO customerWeightAndHeightRequestDTO);

    ResponseEntity<CustomerBmiDTO> getCustomerBMI(Long id);
    ResponseEntity<CustomerWeightAndHeightResponseDTO> editCustomerWeightAndHeight(Long id, CustomerWeightAndHeightRequestDTO requestDTO);
}
