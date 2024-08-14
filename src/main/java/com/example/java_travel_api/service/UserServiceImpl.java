package com.example.java_travel_api.service;

import com.example.java_travel_api.interfaces.UserService;
import com.example.java_travel_api.model.register.RegisterReturn;
import com.example.java_travel_api.model.User;
import com.example.java_travel_api.repository.UserRepository;
import com.example.java_travel_api.utils.ValidateRegister;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ValidateRegister validateRegister;

    public UserServiceImpl(UserRepository userRepository, ValidateRegister validateRegister) {
        this.userRepository = userRepository;
        this.validateRegister = validateRegister;
    }

    @Override
    public RegisterReturn createUser(User user) {
        RegisterReturn validationFields = validateRegister.validate(user);
        if (validationFields != null) return validationFields;
        if (userRepository.existsByEmail(user.getEmail())) return new RegisterReturn(null, "email already registered", HttpStatus.BAD_REQUEST);
        if (userRepository.existsByUsername(user.getUsername())) return new RegisterReturn(null, "username already registered", HttpStatus.BAD_REQUEST);
        setTime(user);
        userRepository.save(user);
        return new RegisterReturn(user.getId().toString(), "user " + user.getId() + " registered",HttpStatus.CREATED);
    }

    @Override
    public RegisterReturn updateUser(User user, String email) {
        Optional<User> oldUser = userRepository.findById(user.getId());
        if (oldUser.isEmpty()) return new RegisterReturn(null, "user not found", HttpStatus.NOT_FOUND);
        if (!oldUser.get().getEmail().equals(email)) return new RegisterReturn(null, "email not match", HttpStatus.BAD_REQUEST);
        setTime(user);
        userRepository.save(user);
        return new RegisterReturn(user.getId().toString(), "user " + user.getId() + " updated", HttpStatus.OK);
    }

    private void setTime(User user) {
        if (user.getCreatedAt() == null) user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());
    }
}
