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
@Document(collection = "body_info")
public class BodyInfo {

    @Id
    private Long customerId;

    @Field(name = "weight")
    private Double weight;

    @Field(name = "height")
    private Double height;

    @Field(name = "register_date")
    private LocalDateTime registerDate;
}