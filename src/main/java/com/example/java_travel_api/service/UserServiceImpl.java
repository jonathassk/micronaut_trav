package com.example.java_travel_api.service;

import com.example.java_travel_api.interfaces.UserService;
import com.example.java_travel_api.model.User;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public User createUser(User user) {
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

    private void validateUser(User user) {

    }
}
