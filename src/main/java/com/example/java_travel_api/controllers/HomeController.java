package com.example.java_travel_api.controllers;

import com.example.java_travel_api.model.travel.*;
import com.example.java_travel_api.repository.SectionTravelRepository;
import com.example.java_travel_api.utils.OpenAiRequests;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
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

        Activities activity = Activities.builder()
                .activity("Test Activity")
                .price(100)
                .address("Test Address")
                .build();

        Activities activity2 = Activities.builder()
                .activity("Test Activity 2")
                .price(200)
                .address("Test Address 2")
                .build();

        ActivitiesTravel activitiesTravel = ActivitiesTravel.builder()
                .activities(List.of(activity, activity2))
                .build();


        Hotel hotel = Hotel.builder()
            .name("Hotel Test")
            .address("Test Address")
            .city("Buenos Aires")
            .country("Argentina")
            .price(100)
            .build();

        Flight flight = Flight.builder()
            .airline("Aerolineas Argentinas")
            .flightNumber("AR123")
            .origin("EZE")
            .destination("MIA")
            .price(1000)
            .seatClass("Economy")
            .dateTimeDeparture(LocalDateTime.now())
            .dateTimeArrival(LocalDateTime.of(2024, 10, 10, 10, 10))
            .returnDateTimeDeparture(LocalDateTime.of(2024, 10, 11, 10, 10))
            .returnDateTimeArrival(LocalDateTime.of(2024, 10, 12, 10, 10))
            .build();

        Section section = Section.builder()
                .dayStart(LocalDate.now())
                .dayEnd(LocalDate.now())
                .city("Buenos Aires")
                .country("Argentina")
                .quantityDailyActivities(3)
                .flights(List.of(flight))
                .hotels(List.of(hotel))
                .activitiesTravel(List.of(activitiesTravel))
                .build();

        TravelPlan test = TravelPlan.builder()
                .sectionId(1L)
                .userList(List.of(1L, 2L))
                .section(List.of(section))
                .build();
        sectionTravelRepository.save(test);
    }

    @GetMapping("/test2")
    public ResponseEntity<TravelPlan> test2() {
        return ResponseEntity.ok(sectionTravelRepository.findById(1L));
    }

}
