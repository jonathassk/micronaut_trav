package com.example.java_travel_api.interfaces;

import com.example.java_travel_api.model.User;

public interface UserService {
    User createUser(User user);
    User getUserById(Long id);
    User updateUser(User user);
}
