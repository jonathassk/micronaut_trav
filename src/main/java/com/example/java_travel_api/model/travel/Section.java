package com.example.java_travel_api.model.travel;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverted;
import com.example.java_travel_api.utils.dynamoDbConverters.LocalDateConverterDynamo;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Section {
    @DynamoDBAttribute
    @DynamoDBTypeConverted(converter = LocalDateConverterDynamo.class)
    private LocalDate dayStart;

    @DynamoDBAttribute
    @DynamoDBTypeConverted(converter = LocalDateConverterDynamo.class)
    private LocalDate dayEnd;

    @DynamoDBAttribute
    private String city;

    @DynamoDBAttribute
    private String country;

    @DynamoDBAttribute
    private int quantityDailyActivities;

}
