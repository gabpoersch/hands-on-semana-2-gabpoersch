package com.eldorado.hhzzefitnesscenter.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class CustomerSaveDTO {
    private String name;
    private String gender;
    @JsonProperty("birth_date")
    private Date birthDate;
    @JsonProperty("days_per_month")
    private Integer daysPerMonth;
    private String phone;
    private String address;
}
