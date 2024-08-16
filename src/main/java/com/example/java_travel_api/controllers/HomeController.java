package com.example.java_travel_api.controllers;

import com.example.java_travel_api.model.User;
import com.example.java_travel_api.model.register.RegisterReturn;
import com.example.java_travel_api.model.travel.Section;
import com.example.java_travel_api.repository.SectionTravelRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/test")
public class HomeController {

    private final SectionTravelRepository sectionTravelRepository;

    public HomeController(SectionTravelRepository sectionTravelRepository) {
        this.sectionTravelRepository = sectionTravelRepository;
    }

    @GetMapping("/test")
    public void test() {
        sectionTravelRepository.save(new Section(1L, LocalDate.now(), LocalDate.now(), "New York", "USA", 2));
    }

    @GetMapping("/test2")
    public void test2() {
        sectionTravelRepository.findAll().forEach(item -> {
            System.out.println(item.getCity());
        });
    }
}
