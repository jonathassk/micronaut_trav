package com.example.java_travel_api.model.travel;

import com.amazonaws.services.dynamodbv2.datamodeling.*;
import com.example.java_travel_api.utils.dynamoDbConverters.SectionListConverter;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@DynamoDBTable(tableName = "travel_dynamo")
public class TravelPlan {
    @DynamoDBHashKey
    private Long sectionId;

    @DynamoDBAttribute
    List<Long> userList;

    @DynamoDBAttribute
    @DynamoDBTypeConverted(converter = SectionListConverter.class)
    List<Section> section;
}