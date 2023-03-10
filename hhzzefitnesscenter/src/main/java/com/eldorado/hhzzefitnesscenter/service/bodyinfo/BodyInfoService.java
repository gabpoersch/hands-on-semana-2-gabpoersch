package com.eldorado.hhzzefitnesscenter.service.bodyinfo;

import com.eldorado.hhzzefitnesscenter.dto.bodyinfo.BodyInfoDTO;
import com.eldorado.hhzzefitnesscenter.dto.bodyinfo.BodyInfoRequestDTO;
import com.eldorado.hhzzefitnesscenter.dto.bodyinfo.BodyInfoResponseDTO;
import com.eldorado.hhzzefitnesscenter.model.BodyInfo;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BodyInfoService {

    Long getNextVal();

    String bmiCalculator(BodyInfo bodyInfo);

    ResponseEntity<BodyInfoDTO> addCustomerWeightAndHeight(Long id, BodyInfoDTO bodyInfoDTO);

    ResponseEntity<List<BodyInfo>> getCustomerBMI(Long id);

    ResponseEntity<BodyInfoResponseDTO> updateCustomerWeightAndHeight(Long id, BodyInfoRequestDTO requestDTO);
}
