package com.example.java_travel_api.controllers;

import com.example.java_travel_api.model.User;
import com.example.java_travel_api.model.register.RegisterReturn;
import com.example.java_travel_api.model.travel.Section;
import com.example.java_travel_api.repository.SectionTravelRepository;
import com.example.java_travel_api.utils.GetPromptAi;
import com.example.java_travel_api.utils.OpenAiRequests;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import software.amazon.awssdk.services.dynamodb.model.Get;

import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.Queue;

@RestController
@RequestMapping("/test")
public class HomeController {

    private final SectionTravelRepository sectionTravelRepository;
    private final OpenAiRequests openAiRequests;

    public HomeController(SectionTravelRepository sectionTravelRepository, OpenAiRequests openAiRequests) {
        this.sectionTravelRepository = sectionTravelRepository;
        this.openAiRequests = openAiRequests;
    }

    @GetMapping("/test")
    public void test() throws UnsupportedEncodingException, JsonProcessingException {
        Queue<String> infoTravel = new LinkedList<>();
        infoTravel.add("1");
        infoTravel.add("Paris");
        infoTravel.add("11/10/2024");
        infoTravel.add("12/10/2024");
        infoTravel.add("50");
        String getPromptAi = new GetPromptAi().getPromptText(infoTravel);
    }

    @GetMapping("/test2")
    public void test2() {
        sectionTravelRepository.findAll().forEach(item -> {
            System.out.println(item.getCity());
        });
    }
}
