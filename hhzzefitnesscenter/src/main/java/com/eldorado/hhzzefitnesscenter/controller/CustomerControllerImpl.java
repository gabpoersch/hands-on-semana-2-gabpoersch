package com.eldorado.hhzzefitnesscenter.controller;

import com.eldorado.hhzzefitnesscenter.dto.CustomerSaveDTO;
import com.eldorado.hhzzefitnesscenter.dto.CustomerWeightAndHeightRequestDTO;
import com.eldorado.hhzzefitnesscenter.dto.CustomerWeightAndHeightResponseDTO;
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
                .weight(null)
                .height(null)
                .build();

        customerRepository.save(customer);
        return new ResponseEntity<>(customerSaveDTO, HttpStatus.CREATED);
    }

    @Override
    @PutMapping(value = "/{id}", consumes = "application/json")
    public ResponseEntity<CustomerWeightAndHeightResponseDTO> addCustomerWeightAndHeight(@PathVariable Long id, @RequestBody CustomerWeightAndHeightRequestDTO requestDTO) {
//        Optional<Customer> optionalCustomer = customerRepository.findById(String.valueOf(id));
//        if(!optionalCustomer.isPresent()) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        Customer customer = optionalCustomer.get();
//
//        System.out.println(customer.toString());
//
//        CustomerWeightAndHeightResponseDTO responseDTO = CustomerWeightAndHeightResponseDTO.builder()
//                .id(id)
//                .weight(requestDTO.getWeight())
//                .height(requestDTO.getHeight())
//                .build();
//
//        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
        return null;
    }

    @Override
    public void getCustomerBMI(Long id) {
//        Customer customer = customerRepository.findById(String.valueOf(id)).orElse(null);
//        customerService.bmiCalculator(customer);
    }

    @Override
    public void editCustomerWeightAndHeight(Long id, double newWeight, double newHeight) {
//        Customer customer = customerRepository.findById(String.valueOf(id)).orElse(null);
//        if (customer != null) {
//            customer.setWeight(newWeight);
//            customer.setHeight(newHeight);
//            customerRepository.save(customer);
//        }

    }

}
