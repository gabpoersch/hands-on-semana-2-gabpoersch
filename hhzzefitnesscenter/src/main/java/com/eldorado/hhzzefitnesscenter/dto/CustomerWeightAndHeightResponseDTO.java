package com.eldorado.hhzzefitnesscenter.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomerWeightAndHeightResponseDTO {
    private Long id;
    private Double oldWeight;
    private Double newWeight;
    private Double oldHeight;
    private Double newHeight;
}
