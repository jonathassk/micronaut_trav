package com.example.java_travel_api.utils;

import com.example.java_travel_api.model.User;
import com.example.java_travel_api.model.register.RegisterReturn;
import com.example.java_travel_api.repository.UserRepository;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ValidateRegisterTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private ValidateRegister validateRegister;

    @Test
    void testEmailAlreadyRegistered () {
        when(userRepository.existsByEmail(user.getEmail())).thenReturn(true);
        RegisterReturn result = validateRegister.validate(user);
        assertEquals("email already registered", result.message());
        assertEquals(400, result.status().value());
    }

    @Test
    void testValidRegister() {
        when(userRepository.existsByEmail(user.getEmail())).thenReturn(false);
        RegisterReturn result = validateRegister.validate(user);
        assertNull(result);
    }

    @Test
    void testInvalidPassword() {
        user.setPassword("12345678");
        assertThrows(IllegalArgumentException.class, () -> validateRegister.validate(user), "password must be longer than 8!");
    }

    @Test
    void testInvalidEmail() {
        user.setEmail("emails");
        assertThrows(IllegalArgumentException.class, () -> validateRegister.validate(user), "invalid email!");
    }

    @Test
    void testInvalidFields() {
        user.setUsername("jo");
        user.setFirstname("J");
        user.setLastname("D");
        user.setPassword(null);
        user.setEmail(null);
        user.setCity(null);
        user.setCountry(null);
        RegisterReturn result = validateRegister.validate(user);
        assertEquals("[USERNAME, FIRSTNAME, LASTNAME, PASSWORD, EMAIL, CITY, COUNTRY]", result.message());
        assertEquals(400, result.status().value());
    }

    User user = User.builder()
            .firstname("John")
            .lastname("Doe")
            .username("johndoe")
            .password("1!@aA23678")
            .email("email@email.com")
            .city("Sao Paulo")
            .country("Brazil")
            .age(25)
            .build();
}