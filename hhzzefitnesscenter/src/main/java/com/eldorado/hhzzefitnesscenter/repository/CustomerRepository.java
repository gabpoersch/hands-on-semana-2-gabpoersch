package com.eldorado.hhzzefitnesscenter.repository;

import com.eldorado.hhzzefitnesscenter.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, String> {

}
