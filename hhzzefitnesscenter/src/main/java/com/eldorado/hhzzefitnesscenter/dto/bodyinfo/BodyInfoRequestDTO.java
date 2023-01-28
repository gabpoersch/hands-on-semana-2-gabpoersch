package com.eldorado.hhzzefitnesscenter.dto.bodyinfo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BodyInfoRequestDTO {
    private Double weight;
    private Double height;
}
