package com.eldorado.hhzzefitnesscenter.controller.customer;

import com.eldorado.hhzzefitnesscenter.dto.customer.CustomerRequestDTO;
import com.eldorado.hhzzefitnesscenter.dto.customer.CustomerResponseDTO;
import com.eldorado.hhzzefitnesscenter.service.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerControllerImpl implements CustomerController {

    @Autowired
    private CustomerService customerService;

    @Override
    public ResponseEntity<CustomerResponseDTO> addCustomer(CustomerRequestDTO customerRequestDTO) {
        return customerService.addCustomer(customerRequestDTO);
    }
}
