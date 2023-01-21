package com.eldorado.hhzzefitnesscenter.dto.bodyinfo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BodyInfoDTO {
    private Long id;
    private Double weight;
    private Double height;
    private String category;
}
