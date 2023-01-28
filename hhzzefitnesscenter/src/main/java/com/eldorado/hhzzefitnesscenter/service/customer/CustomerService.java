package com.eldorado.hhzzefitnesscenter.service.customer;

import com.eldorado.hhzzefitnesscenter.dto.customer.CustomerRequestDTO;
import com.eldorado.hhzzefitnesscenter.dto.customer.CustomerResponseDTO;
import org.springframework.http.ResponseEntity;

public interface CustomerService {
    Long getNextVal();

    ResponseEntity<CustomerResponseDTO> addCustomer(CustomerRequestDTO customerRequestDTO);

}
