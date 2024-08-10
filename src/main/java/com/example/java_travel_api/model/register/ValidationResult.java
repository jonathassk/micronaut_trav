package com.example.java_travel_api.model.register;

public record ValidationResult(String message) {
    public static ValidationResult success() {
        return new ValidationResult(null);
    }

    public static ValidationResult failure(String message) {
        return new ValidationResult(message);
    }

}
