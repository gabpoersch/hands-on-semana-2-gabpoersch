package com.eldorado.hhzzefitnesscenter.controller.customer;

import com.eldorado.hhzzefitnesscenter.dto.customer.CustomerRequestDTO;
import com.eldorado.hhzzefitnesscenter.dto.customer.CustomerResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
public interface CustomerController {

    @PostMapping(value = "/add", consumes = "application/json")
    ResponseEntity<CustomerResponseDTO> addCustomer(@RequestBody CustomerRequestDTO customerRequestDTO);

}
