package com.example.java_travel_api.model.travel;

import com.amazonaws.services.dynamodbv2.datamodeling.*;
import com.example.java_travel_api.utils.LocalDateConverterDynamo;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDate;

@DynamoDBTable(tableName = "travel_dynamo")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Section {
    @DynamoDBHashKey
    private Long sectionId;

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
