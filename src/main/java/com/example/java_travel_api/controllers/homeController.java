package com.example.java_travel_api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
public class homeController {

    @GetMapping
    public String getController() {
        return "teste";
    }
}
