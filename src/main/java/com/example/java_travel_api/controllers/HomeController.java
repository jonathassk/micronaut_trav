package com.example.java_travel_api.controllers;

import com.example.java_travel_api.model.User;
import com.example.java_travel_api.model.register.RegisterReturn;
import com.example.java_travel_api.model.travel.Section;
import com.example.java_travel_api.repository.SectionTravelRepository;
import com.example.java_travel_api.utils.OpenAiRequests;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.time.LocalDate;

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
        openAiRequests.sendRequestOpenAi("me responda que versão do openAi estou usando");
        // sectionTravelRepository.save(new Section(1L, LocalDate.now(), LocalDate.now(), "New York", "USA", 2));
    }

    @GetMapping("/test2")
    public void test2() {
        sectionTravelRepository.findAll().forEach(item -> {
            System.out.println(item.getCity());
        });
    }
}
