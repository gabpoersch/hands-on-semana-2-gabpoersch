package com.eldorado.hhzzefitnesscenter.service.bodyinfo;

import com.eldorado.hhzzefitnesscenter.dto.bodyinfo.BodyInfoDTO;
import com.eldorado.hhzzefitnesscenter.dto.bodyinfo.BodyInfoRequestDTO;
import com.eldorado.hhzzefitnesscenter.dto.bodyinfo.BodyInfoResponseDTO;
import com.eldorado.hhzzefitnesscenter.enums.BMICategory;
import com.eldorado.hhzzefitnesscenter.model.BodyInfo;
import com.eldorado.hhzzefitnesscenter.model.Customer;
import com.eldorado.hhzzefitnesscenter.repository.BodyInfoRepository;
import com.eldorado.hhzzefitnesscenter.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class BodyInfoServiceImpl implements BodyInfoService {

    private final CustomerRepository customerRepository;
    private final BodyInfoRepository bodyInfoRepository;

    @Autowired
    public BodyInfoServiceImpl(CustomerRepository customerRepository, BodyInfoRepository bodyInfoRepository) {
        this.customerRepository = customerRepository;
        this.bodyInfoRepository = bodyInfoRepository;
    }

    @Override
    public Long getNextVal() {
        return bodyInfoRepository.count() + 1;
    }

    @Override
    public String bmiCalculator(BodyInfo bodyInfo) {
        Double weight = bodyInfo.getWeight();
        Double height = bodyInfo.getHeight();
        Double bmi = weight / (height * height);

        String category;
        if (bmi < 18.5) {
            category = BMICategory.UNDERWEIGHT.getCategory();
        } else if (bmi < 25) {
            category = BMICategory.NORMAL.getCategory();
        } else if (bmi < 30) {
            category = BMICategory.OVERWEIGHT.getCategory();
        } else if (bmi < 40) {
            category = BMICategory.OBESE.getCategory();
        } else {
            category = BMICategory.MORBID_OBESE.getCategory();
        }

        return category;
    }

    @Override
    public ResponseEntity<BodyInfoDTO> addCustomerWeightAndHeight(Long id, BodyInfoDTO bodyInfoDTO) {
        Optional<Customer> customerOpt = customerRepository.findCustomerById(id);

        if (customerOpt.isPresent()) {
            BodyInfo bodyInfo = BodyInfo.builder()
                    .id(getNextVal())
                    .customerId(id)
                    .weight(bodyInfoDTO.getWeight())
                    .height(bodyInfoDTO.getHeight())
                    .registerDate(LocalDateTime.now())
                    .build();

            bodyInfo.setCategory(bmiCalculator(bodyInfo));

            bodyInfoRepository.save(bodyInfo);
            BodyInfoDTO responseDTO = BodyInfoDTO.builder()
                    .id(id)
                    .weight(bodyInfoDTO.getWeight())
                    .height(bodyInfoDTO.getHeight())
                    .category(bodyInfo.getCategory())
                    .build();
            return new ResponseEntity<>(responseDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<List<BodyInfo>> getCustomerBMI(Long id) {
        List<BodyInfo> bodyInfoList = bodyInfoRepository.findByCustomerIdSortedByDate(id);

        if (bodyInfoList != null) {
            return new ResponseEntity<>(bodyInfoList, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @Override
    public ResponseEntity<BodyInfoResponseDTO> updateCustomerWeightAndHeight(Long id, BodyInfoRequestDTO requestDTO) {
        Optional<BodyInfo> bodyInfoOpt = bodyInfoRepository.findBodyInfoById(id);
        if (!bodyInfoOpt.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        BodyInfo bodyInfo = bodyInfoOpt.get();
        Double oldWeight = bodyInfo.getWeight();
        Double oldHeight = bodyInfo.getHeight();

        bodyInfo.setWeight(requestDTO.getWeight());
        bodyInfo.setHeight(requestDTO.getHeight());
        bodyInfo.setCategory(bmiCalculator(bodyInfo));
        bodyInfoRepository.save(bodyInfo);

        BodyInfoResponseDTO responseDTO = BodyInfoResponseDTO.builder()
                .id(id)
                .oldWeight(oldWeight)
                .newWeight(requestDTO.getWeight())
                .oldHeight(oldHeight)
                .newHeight(requestDTO.getHeight())
                .build();

        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}
