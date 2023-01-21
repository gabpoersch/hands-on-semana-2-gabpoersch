package com.eldorado.hhzzefitnesscenter.controller;

import com.eldorado.hhzzefitnesscenter.dto.*;
import com.eldorado.hhzzefitnesscenter.model.Customer;
import com.eldorado.hhzzefitnesscenter.repository.CustomerRepository;
import com.eldorado.hhzzefitnesscenter.service.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/customer")
public class CustomerControllerImpl implements CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CustomerServiceImpl customerService;

    @Override
    @PostMapping(consumes = "application/json")
    public ResponseEntity<CustomerSaveDTO> addCustomer(@RequestBody CustomerSaveDTO customerSaveDTO) {
        Customer customer = Customer.builder()
                .name(customerSaveDTO.getName())
                .gender(customerSaveDTO.getGender())
                .id(customerService.getNextVal())
                .birthDate(customerSaveDTO.getBirthDate())
                .daysPerMonth(customerSaveDTO.getDaysPerMonth())
                .phone(customerSaveDTO.getPhone())
                .address(customerSaveDTO.getAddress())
                .weight(0.0)
                .height(0.0)
                .build();

        customerRepository.save(customer);
        return new ResponseEntity<>(customerSaveDTO, HttpStatus.CREATED);
    }

    @Override
    @PutMapping(value = "/addbodyinfo/{id}", consumes = "application/json")
    public ResponseEntity<CustomerBodyInfoResponseDTO> addCustomerWeightAndHeight(@PathVariable Long id, @RequestBody CustomerWeightAndHeightRequestDTO requestDTO) {
        Optional<Customer> customerOpt = customerRepository.findCustomerById(id);

        if (customerOpt != null) {
            Customer customer = customerOpt.get();
            customer.setWeight(requestDTO.getWeight());
            customer.setHeight(requestDTO.getHeight());
            customerRepository.save(customer);
        }

        CustomerBodyInfoResponseDTO responseDTO = CustomerBodyInfoResponseDTO.builder()
                .id(id)
                .weight(requestDTO.getWeight())
                .height(requestDTO.getHeight())
                .build();

        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @Override
    @GetMapping("/bmi/{id}")
    public ResponseEntity<CustomerBmiDTO> getCustomerBMI(@PathVariable Long id) {
        Optional<Customer> customerOpt = customerRepository.findCustomerById(id);
        Customer customer = customerOpt.get();
        Double bmi = null;

        if (customerOpt != null) {
            bmi = customerService.bmiCalculator(customer);
        }

        CustomerBmiDTO customerBmiDTO = CustomerBmiDTO.builder()
                .id(id)
                .name(customer.getName())
                .bmi(bmi)
                .build();
        return new ResponseEntity<>(customerBmiDTO, HttpStatus.OK);
    }

    @Override
    @PutMapping("/editbodyinfo/{id}")
    public ResponseEntity<CustomerWeightAndHeightResponseDTO> editCustomerWeightAndHeight(@PathVariable Long id, @RequestBody CustomerWeightAndHeightRequestDTO requestDTO) {
        Optional<Customer> customerOpt = customerRepository.findCustomerById(id);
        Double oldHeight = customerOpt.get().getHeight();
        Double oldWeight = customerOpt.get().getWeight();

        if (customerOpt != null) {
            Customer customer = customerOpt.get();
            customer.setWeight(requestDTO.getWeight());
            customer.setHeight(requestDTO.getHeight());
            customerRepository.save(customer);
        }

        CustomerWeightAndHeightResponseDTO responseDTO = CustomerWeightAndHeightResponseDTO.builder()
                .id(id)
                .oldWeight(oldWeight)
                .newWeight(requestDTO.getWeight())
                .oldHeight(oldHeight)
                .newHeight(requestDTO.getHeight())
                .build();

        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

}
