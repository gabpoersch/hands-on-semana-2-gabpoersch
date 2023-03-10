package com.eldorado.hhzzefitnesscenter.controller.bodyinfo;

import com.eldorado.hhzzefitnesscenter.dto.bodyinfo.BodyInfoDTO;
import com.eldorado.hhzzefitnesscenter.dto.bodyinfo.BodyInfoRequestDTO;
import com.eldorado.hhzzefitnesscenter.dto.bodyinfo.BodyInfoResponseDTO;
import com.eldorado.hhzzefitnesscenter.model.BodyInfo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bodyinfo")
public interface BodyInfoController {

    @PutMapping(value = "/{id}/add", consumes = "application/json")
    ResponseEntity<BodyInfoDTO> addCustomerWeightAndHeight(@PathVariable Long id, @RequestBody BodyInfoDTO customerWeightAndHeightRequestDTO);

    @GetMapping(value = "/{id}/bmi")
    ResponseEntity<List<BodyInfo>> getCustomerBMI(@PathVariable Long id);

    @PutMapping(value = "/{id}/update", consumes = "application/json")
    ResponseEntity<BodyInfoResponseDTO> updateCustomerWeightAndHeight(@PathVariable Long id, @RequestBody BodyInfoRequestDTO requestDTO);
}
