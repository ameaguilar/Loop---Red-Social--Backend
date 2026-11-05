package com.develoopers.loop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain config(HttpSecurity http){
        http.csrf( (csrf) -> csrf.disable());
        return http.build();
    }// config

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    } // PasswordEncoder
} // SecurityConfig
