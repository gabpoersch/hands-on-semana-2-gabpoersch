package com.eldorado.hhzzefitnesscenter.dto.customer;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class CustomerResponseDTO {
    private Long id;
    private String name;
    @JsonProperty("days_per_month")
    private Integer daysPerMonth;
}
