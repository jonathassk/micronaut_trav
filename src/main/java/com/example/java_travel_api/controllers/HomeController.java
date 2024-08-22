package com.example.java_travel_api.controllers;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.example.java_travel_api.model.travel.Section;
import com.example.java_travel_api.repository.SectionTravelRepository;
import com.example.java_travel_api.utils.OpenAiRequests;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.time.LocalDate;

@RestController
@RequestMapping("/test")
public class HomeController {

    private final SectionTravelRepository sectionTravelRepository;
    private final OpenAiRequests openAiRequests;

    public HomeController(OpenAiRequests openAiRequests, SectionTravelRepository sectionTravelRepository) {
        this.sectionTravelRepository = sectionTravelRepository;
        this.openAiRequests = openAiRequests;
    }

    @GetMapping("/test")
    public void test() {
        Section test = Section.builder()
                .sectionId(1L)
                .city("São Paulo")
                .country("Brasil")
                .dayStart(LocalDate.now())
                .dayEnd(LocalDate.now().plusDays(5))
                .quantityDailyActivities(3)
                .build();
        sectionTravelRepository.save(test);
    }

    @GetMapping("/test2")
    public void test2() {
        System.out.println(sectionTravelRepository.findById(1L).getCity());
    }
}
