package com.example.java_travel_api.controllers;

import com.example.java_travel_api.model.travel.Flight;
import com.example.java_travel_api.model.travel.Hotel;
import com.example.java_travel_api.model.travel.Section;
import com.example.java_travel_api.model.travel.TravelPlan;
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
