package com.example.java_travel_api.interfaces;

import com.example.java_travel_api.model.register.RegisterReturn;
import com.example.java_travel_api.model.User;

public interface UserService {
    RegisterReturn createUser(User user);
    User getUserById(Long id);
    RegisterReturn updateUser(User user);
}
