package com.example.java_travel_api.model.openai;

import java.util.List;


public record OpenAiResponse(String id, List<Choices> choices, String model) {
}