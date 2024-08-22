package com.example.java_travel_api.model.travel;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@DynamoDBTable(tableName = "Travel")
public class TravelEntityMongo {

    @DynamoDBHashKey
    private Long id;

    @DynamoDBAttribute
    private List<TravelPlan> travelPlans;

    @DynamoDBAttribute
    private LocalDate dayStart;

    @DynamoDBAttribute
    private LocalDate dayEnd;

    @DynamoDBAttribute
    private LocalDate createdAt;

    @DynamoDBAttribute
    private LocalDateTime updatedAt;
}
