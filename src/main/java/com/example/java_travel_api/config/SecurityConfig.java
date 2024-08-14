package com.example.java_travel_api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
            .csrf(AbstractHttpConfigurer::disable)
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .authorizeHttpRequests(auth -> auth
                    .requestMatchers("/guests/**").permitAll()
                    .anyRequest().authenticated())
            .oauth2Login(Customizer.withDefaults())
            .formLogin(Customizer.withDefaults())
            .oauth2ResourceServer(oauth2 -> oauth2.jwt(Customizer.withDefaults()))  // Adiciona suporte ao OAuth2 Resource Server com JWT
            .build();
    }

    @Bean
    public JwtDecoder jwtDecoder() {
        // Substitua pela URL real do seu provedor de identidade
        String jwkSetUri = "https://www.googleapis.com/oauth2/v3/certs";
        return NimbusJwtDecoder.withJwkSetUri(jwkSetUri).build();
    }

}
