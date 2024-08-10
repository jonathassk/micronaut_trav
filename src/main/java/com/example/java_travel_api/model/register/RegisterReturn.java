package com.example.java_travel_api.model;

import org.springframework.http.HttpStatus;

public record RegisterReturn(String body, String message, HttpStatus status) {
}
