package com.example.java_travel_api.controllers;

import com.example.java_travel_api.model.travel.Section;
import com.example.java_travel_api.model.travel.TravelPlan;
import com.example.java_travel_api.repository.SectionTravelRepository;
import com.example.java_travel_api.utils.OpenAiRequests;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

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
        Section section = Section.builder()
                .dayStart(LocalDate.now())
                .dayEnd(LocalDate.now())
                .city("Buenos Aires")
                .country("Argentina")
                .quantityDailyActivities(3)
                .build();

        TravelPlan test = TravelPlan.builder()
                .sectionId(1L)
                .userList(List.of(1L, 2L))
                .section(List.of(section))
                .build();
        sectionTravelRepository.save(test);
    }

    @GetMapping("/test2")
    public void test2() {
        System.out.println(sectionTravelRepository.findById(1L).getSection());
    }
}
