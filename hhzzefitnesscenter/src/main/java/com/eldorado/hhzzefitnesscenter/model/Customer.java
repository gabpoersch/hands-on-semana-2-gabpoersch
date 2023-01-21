package com.eldorado.hhzzefitnesscenter.model;

import com.mongodb.lang.Nullable;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

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
    private Date birthDate;

    @Field(name = "days_per_month")
    private Integer daysPerMonth;

    @Field(name = "phone")
    private String phone;

    @Field(name = "address")
    private String address;

    @Field(name = "weight")
    @Nullable
    private Double weight;

    @Nullable
    @Field(name = "height")
    private Double height;
}