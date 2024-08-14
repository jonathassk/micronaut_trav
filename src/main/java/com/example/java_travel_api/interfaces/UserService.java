package com.example.java_travel_api.interfaces;

import com.example.java_travel_api.model.register.RegisterReturn;
import com.example.java_travel_api.model.User;

public interface UserService {
    RegisterReturn createUser(User user);
    RegisterReturn updateUser(User user, String email);
}
