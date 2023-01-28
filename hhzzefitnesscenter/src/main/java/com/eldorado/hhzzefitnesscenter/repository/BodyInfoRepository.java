package com.eldorado.hhzzefitnesscenter.repository;

import com.eldorado.hhzzefitnesscenter.model.BodyInfo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface BodyInfoRepository extends MongoRepository<BodyInfo, String> {

    Optional<BodyInfo> findBodyInfoById(Long id);

    @Query(value = "{'customer_id': ?0}", sort = "{'register_date': -1}")
    List<BodyInfo> findByCustomerIdSortedByDate(Long customerId);

}
