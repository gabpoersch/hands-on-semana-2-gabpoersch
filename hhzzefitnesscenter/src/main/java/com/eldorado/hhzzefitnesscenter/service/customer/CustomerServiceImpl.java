package com.eldorado.hhzzefitnesscenter.service.customer;

import com.eldorado.hhzzefitnesscenter.dto.customer.CustomerRequestDTO;
import com.eldorado.hhzzefitnesscenter.dto.customer.CustomerResponseDTO;
import com.eldorado.hhzzefitnesscenter.model.Customer;
import com.eldorado.hhzzefitnesscenter.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Long getNextVal() {
        return customerRepository.count() + 1;
    }

    @Override
    public ResponseEntity<CustomerResponseDTO> addCustomer(CustomerRequestDTO customerRequestDTO) {
        Customer customer = Customer.builder()
                .name(customerRequestDTO.getName())
                .gender(customerRequestDTO.getGender())
                .id(getNextVal())
                .birthDate(customerRequestDTO.getBirthDate())
                .daysPerMonth(customerRequestDTO.getDaysPerMonth())
                .phone(customerRequestDTO.getPhone())
                .address(customerRequestDTO.getAddress())
                .build();

        CustomerResponseDTO customerResponseDTO = CustomerResponseDTO.builder()
                .id(customer.getId())
                .name(customer.getName())
                .daysPerMonth(customer.getDaysPerMonth()).build();

        customerRepository.save(customer);
        return new ResponseEntity<>(customerResponseDTO, HttpStatus.CREATED);
    }

}
