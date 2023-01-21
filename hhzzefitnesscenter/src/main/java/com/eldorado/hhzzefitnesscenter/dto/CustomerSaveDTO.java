package com.eldorado.hhzzefitnesscenter.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class CustomerSaveDTO {
    private String name;
    private String gender;
    private Date birthDate;
    private Integer daysPerMonth;
    private String phone;
    private String address;
}
