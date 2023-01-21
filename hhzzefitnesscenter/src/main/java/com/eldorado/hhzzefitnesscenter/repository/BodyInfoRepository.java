package com.eldorado.hhzzefitnesscenter.repository;

import com.eldorado.hhzzefitnesscenter.model.BodyInfo;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface BodyInfoRepository extends MongoRepository<BodyInfo, String> {

    Optional<BodyInfo> findBodyInfoByCustomerId(Long id);

}
