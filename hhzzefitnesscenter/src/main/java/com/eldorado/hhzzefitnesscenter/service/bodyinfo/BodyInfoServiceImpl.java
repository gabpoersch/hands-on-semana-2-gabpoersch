package com.eldorado.hhzzefitnesscenter.service.bodyinfo;

import com.eldorado.hhzzefitnesscenter.dto.BmiDTO;
import com.eldorado.hhzzefitnesscenter.dto.bodyinfo.BodyInfoDTO;
import com.eldorado.hhzzefitnesscenter.dto.bodyinfo.BodyInfoRequestDTO;
import com.eldorado.hhzzefitnesscenter.dto.bodyinfo.BodyInfoResponseDTO;
import com.eldorado.hhzzefitnesscenter.model.BMICategory;
import com.eldorado.hhzzefitnesscenter.model.BodyInfo;
import com.eldorado.hhzzefitnesscenter.model.Customer;
import com.eldorado.hhzzefitnesscenter.repository.BodyInfoRepository;
import com.eldorado.hhzzefitnesscenter.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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
    public Double bmiCalculator(BodyInfo bodyInfo) {
        double weight = bodyInfo.getWeight();
        double height = bodyInfo.getHeight();
        return weight / (height * height);
    }

    @Override
    public ResponseEntity<BodyInfoDTO> addCustomerWeightAndHeight(Long id, BodyInfoDTO bodyInfoDTO) {
        Optional<Customer> customerOpt = customerRepository.findCustomerById(id);

        if (customerOpt.isPresent()) {
            BodyInfo bodyInfo = BodyInfo.builder()
                    .customerId(id)
                    .weight(bodyInfoDTO.getWeight())
                    .height(bodyInfoDTO.getHeight())
                    .registerDate(LocalDateTime.now())
                    .build();

            bodyInfoRepository.save(bodyInfo);
            BodyInfoDTO responseDTO = BodyInfoDTO.builder()
                    .id(id)
                    .weight(bodyInfoDTO.getWeight())
                    .height(bodyInfoDTO.getHeight())
                    .build();
            return new ResponseEntity<>(responseDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<BmiDTO> getCustomerBMI(Long id) {
        Optional<Customer> customerOpt = customerRepository.findCustomerById(id);
        Optional<BodyInfo> bodyInfoOpt = bodyInfoRepository.findBodyInfoByCustomerId(id);
        Double bmi;

        if (customerOpt.isPresent() && bodyInfoOpt.isPresent()) {
            Customer customer = customerOpt.get();
            BodyInfo bodyInfo = bodyInfoOpt.get();
            bmi = this.bmiCalculator(bodyInfo);
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
            BmiDTO bmiDTO = BmiDTO.builder()
                    .id(id)
                    .name(customer.getName())
                    .bmi(bmi)
                    .category(category)
                    .build();
            return new ResponseEntity<>(bmiDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @Override
    public ResponseEntity<BodyInfoResponseDTO> updateCustomerWeightAndHeight(Long id, BodyInfoRequestDTO requestDTO) {
        Optional<BodyInfo> bodyInfoOpt = bodyInfoRepository.findBodyInfoByCustomerId(id);
        if (!bodyInfoOpt.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        BodyInfo bodyInfo = bodyInfoOpt.get();
        Double oldWeight = bodyInfo.getWeight();
        Double oldHeight = bodyInfo.getHeight();

        bodyInfo.setWeight(requestDTO.getWeight());
        bodyInfo.setHeight(requestDTO.getHeight());
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
