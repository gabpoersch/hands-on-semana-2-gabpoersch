package com.eldorado.hhzzefitnesscenter.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BmiDTO {
    private Long id;
    private String name;
    private Double bmi;
    private String category;
}
