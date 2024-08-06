package com.example.java_travel_api.service;

import com.example.java_travel_api.interfaces.UserService;
import com.example.java_travel_api.model.User;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
public class UserServiceImpl implements UserService {

    private static final String REGEX_SENHA = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!]).*$";
    @Override
    public User createUser(User user) {
        verifyPassWord(user.getPassword());
        return null;
    }

    @Override
    public User getUserById(Long id) {
        return null;
    }

    @Override
    public User updateUser(User user) {
        return null;
    }

    private void verifyPassWord(String password) {
        if (password.length() < 8) throw new IllegalArgumentException("password must be longer than 8!");
        if (!Pattern.compile(REGEX_SENHA).matcher(password).matches()) throw new IllegalArgumentException("password must have a lowercase, a uppercase, a number and a special character!");
    }
}
