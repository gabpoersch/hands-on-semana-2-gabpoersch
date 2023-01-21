package com.eldorado.hhzzefitnesscenter.controller;

import com.eldorado.hhzzefitnesscenter.dto.CustomerSaveDTO;
import com.eldorado.hhzzefitnesscenter.model.Customer;
import com.eldorado.hhzzefitnesscenter.repository.CustomerRepository;
import com.eldorado.hhzzefitnesscenter.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerControllerImpl implements CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    CustomerService customerService;

    @Override
    public ResponseEntity<CustomerSaveDTO> addCustomer(CustomerSaveDTO customerSaveDTO) {
        Customer customer = Customer.builder()
                .name(customerSaveDTO.getName())
                .gender(customerSaveDTO.getGender())
                .id(customerService.getNextVal())
                .birthDate(customerSaveDTO.getBirthDate())
                .daysPerMonth(customerSaveDTO.getDaysPerMonth())
                .phone(customerSaveDTO.getPhone())
                .address(customerSaveDTO.getAddress()).build();

        customerRepository.save(customer);
        return new ResponseEntity<>(customerSaveDTO, HttpStatus.CREATED);
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
