package com.example.java_travel_api.utils;

import com.example.java_travel_api.model.User;
import com.example.java_travel_api.repository.UserRepository;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.regex.Pattern;

public class RegisterUtils {

    private final UserRepository userRepository;
    private static final String REGEX_SENHA = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!]).*$";
    private static final String REGEX_EMAIL = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

    public RegisterUtils(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private void verifyFieldsRegister(User user) {
        if (user.getUsername() == null) throw new IllegalArgumentException("username must be filled!");
        if (user.getFirstname() == null) throw new IllegalArgumentException("name must be filled!");
        if (user.getLastname() == null) throw new IllegalArgumentException("lastname must be filled!");
        if (user.getPassword() == null) throw new IllegalArgumentException("password must be filled!");
        if (user.getEmail() == null) throw new IllegalArgumentException("email must be filled!");
        if (user.getCity() == null) throw new IllegalArgumentException("city must be filled!");
        if (user.getCountry() == null) throw new IllegalArgumentException("country must be filled!");
    }

    private void verifyPassWord(String password) {
        if (password.length() < 8) throw new IllegalArgumentException("password must be longer than 8!");
        if (!Pattern.compile(REGEX_SENHA).matcher(password).matches()) throw new IllegalArgumentException("password must have a lowercase, a uppercase, a number and a special character!");
    }

    private void verifyEmail(String email) {
        if (email.length() < 6) throw new IllegalArgumentException("email must be longer than 6 characters!");
        if (!Pattern.compile(REGEX_EMAIL).matcher(email).matches()) throw new IllegalArgumentException("invalid email!");
        if (userRepository.existsByEmail(email)) throw new DataIntegrityViolationException("Email already registered!");
    }
}
