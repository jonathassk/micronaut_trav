package com.example.java_travel_api.utils;

import com.example.java_travel_api.model.User;
import com.example.java_travel_api.model.register.RegisterReturn;
import com.example.java_travel_api.model.register.ValidationResult;
import com.example.java_travel_api.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

@Component
public class ValidateRegister {

    private final UserRepository userRepository;
    private static final String REGEX_SENHA = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!]).*$";
    private static final String REGEX_EMAIL = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

    public ValidateRegister(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public RegisterReturn validate(User user) {
        List<ValidationResult> missingValues = verifyFieldsRegister(user);
        if (!missingValues.isEmpty()) return new RegisterReturn(null, missingValues.toString(), HttpStatus.BAD_REQUEST);
        verifyEmail(user.getEmail());
        if (userRepository.existsByEmail(user.getEmail())) return new RegisterReturn(null, "email already registered", HttpStatus.BAD_REQUEST);
        verifyPassWord(user.getPassword());
        return null;
    }

    private List<ValidationResult> verifyFieldsRegister(User user) {
        List<ValidationResult> missingFields = new ArrayList<>();
        if (user.getUsername() == null || user.getUsername().length() < 4) missingFields.add(ValidationResult.failure("USERNAME"));
        if (user.getFirstname() == null || user.getFirstname().length() < 3) missingFields.add(ValidationResult.failure("NAME"));
        if (user.getLastname() == null || user.getLastname().length() < 2) missingFields.add(ValidationResult.failure("LASTNAME"));
        if (user.getPassword() == null) missingFields.add(ValidationResult.failure("PASSWORD"));
        if (user.getEmail() == null) missingFields.add(ValidationResult.failure("EMAIL"));
        if (user.getCity() == null) missingFields.add(ValidationResult.failure("CITY"));
        if (user.getCountry() == null) missingFields.add(ValidationResult.failure("COUNTRY"));
        return missingFields;
    }

    private void verifyPassWord(String password) {
        if (password.length() < 8) throw new IllegalArgumentException("password must be longer than 8!");
        if (!Pattern.compile(REGEX_SENHA).matcher(password).matches()) throw new IllegalArgumentException("password must have a lowercase, a uppercase, a number and a special character!");
    }

    private RegisterReturn verifyEmail(String email) {
        if (email.length() < 6) throw new IllegalArgumentException("email must be longer than 6 characters!");
        if (!Pattern.compile(REGEX_EMAIL).matcher(email).matches()) throw new IllegalArgumentException("invalid email!");
        return new RegisterReturn(null, null, null);
    }
}
