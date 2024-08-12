package com.example.java_travel_api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
            .csrf(csrf -> csrf.disable())  // Desativa temporariamente a proteção CSRF
            .authorizeRequests(auth -> {
                auth.requestMatchers("/user/**").authenticated();
                auth.anyRequest().permitAll();
            })
            .oauth2Login(Customizer.withDefaults())
            .formLogin(Customizer.withDefaults())
            .build();
    }

}
