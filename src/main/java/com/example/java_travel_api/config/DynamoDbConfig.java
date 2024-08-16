package com.example.java_travel_api.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

@Configuration
public class DynamoDbConfig {

    @Value("${AWS_ACCESS_KEY}")
    private String ACCESS_KEY;
    @Value("${AWS_SECRET_KEY}")
    private String SECRET_KEY;
    @Value("${AWS_REGION:sa-east-1}")
    private String REGION;
    @Bean
    public DynamoDbClient dynamoDbClient() {
        return DynamoDbClient.builder().
                    region(Region.of(REGION)).
                    credentialsProvider(StaticCredentialsProvider.create(AwsBasicCredentials.create(ACCESS_KEY, SECRET_KEY))).
                    build();
    }
}
