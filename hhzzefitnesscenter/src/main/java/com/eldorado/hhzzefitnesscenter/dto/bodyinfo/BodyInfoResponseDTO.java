package com.eldorado.hhzzefitnesscenter.dto.bodyinfo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BodyInfoResponseDTO {
    private Long id;
    private Double oldWeight;
    private Double newWeight;
    private Double oldHeight;
    private Double newHeight;
}
