package com.eldorado.hhzzefitnesscenter.model;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;

@Data
@Builder
@ToString
@Document(collection = "customer")
public class Customer {

    @Field(name = "name")
    private String name;

    @Field(name = "gender")
    private String gender;

    @Id
    private Long id;

    @Field(name = "birth_date")
    private LocalDateTime birthDate;

    @Field(name = "days_per_month")
    private Integer daysPerMonth;

    @Field(name = "phone")
    private String phone;

    @Field(name = "address")
    private String address;

}