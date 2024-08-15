package com.example.java_travel_api.controllers;

import com.example.java_travel_api.interfaces.TravelService;
import com.example.java_travel_api.model.Travel;
import com.example.java_travel_api.model.User;
import com.example.java_travel_api.model.travel.TravelReq;
import com.example.java_travel_api.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/travels")
public class TravelController {

    private final UserRepository userRepository;
    private final TravelService travelService;

    public TravelController(UserRepository userRepository, TravelService travelService) {
        this.userRepository = userRepository;
        this.travelService = travelService;
    }

    @PostMapping("/{ownerId}/create-travel")
    public void createTravel(@RequestBody TravelReq travel, @RequestHeader("email") String email, @PathVariable Long ownerId) {
        User user = userRepository.findByEmail(email);
        if (user == null) throw new IllegalArgumentException("User not found");
        travelService.createTravel(travel, user);
    }

    @GetMapping("/{travelId}/include-traveler/{travelerUsername}")
    public void includeTraveler(@PathVariable Long travelId, @PathVariable String travelerUsername, @RequestHeader("Authorization") String token, @RequestHeader("email") String email) {
        // TODO
    }

}
