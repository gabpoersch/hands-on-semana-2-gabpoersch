package com.eldorado.hhzzefitnesscenter.controller.bodyinfo;

import com.eldorado.hhzzefitnesscenter.dto.BmiDTO;
import com.eldorado.hhzzefitnesscenter.dto.bodyinfo.BodyInfoDTO;
import com.eldorado.hhzzefitnesscenter.dto.bodyinfo.BodyInfoRequestDTO;
import com.eldorado.hhzzefitnesscenter.dto.bodyinfo.BodyInfoResponseDTO;
import com.eldorado.hhzzefitnesscenter.service.bodyinfo.BodyInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BodyInfoControllerImpl implements BodyInfoController {

    @Autowired
    private BodyInfoService bodyInfoService;

    @Override
    public ResponseEntity<BodyInfoDTO> addCustomerWeightAndHeight(Long id, BodyInfoDTO bodyInfoDTO) {
        return bodyInfoService.addCustomerWeightAndHeight(id, bodyInfoDTO);
    }

    @Override
    public ResponseEntity<BmiDTO> getCustomerBMI(Long id) {
        return bodyInfoService.getCustomerBMI(id);
    }

    @Override
    public ResponseEntity<BodyInfoResponseDTO> updateCustomerWeightAndHeight(Long id, BodyInfoRequestDTO requestDTO) {
        return bodyInfoService.updateCustomerWeightAndHeight(id, requestDTO);
    }

}
