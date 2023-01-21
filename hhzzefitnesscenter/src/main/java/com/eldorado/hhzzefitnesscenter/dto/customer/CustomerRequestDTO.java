package com.eldorado.hhzzefitnesscenter.dto.customer;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class CustomerRequestDTO {
    private String name;
    private String gender;
    @JsonProperty("birth_date")
    private LocalDateTime birthDate;
    @JsonProperty("days_per_month")
    private Integer daysPerMonth;
    private String phone;
    private String address;
}
