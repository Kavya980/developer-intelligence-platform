package com.kavya.developerintelligenceplatform.controller;

import com.kavya.developerintelligenceplatform.dto.LoginRequest;
import com.kavya.developerintelligenceplatform.dto.RegisterRequest;
import com.kavya.developerintelligenceplatform.entity.User;
import com.kavya.developerintelligenceplatform.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public User register(@Valid @RequestBody RegisterRequest request) {

        return authService.register(
                request.getUsername(),
                request.getPassword()
        );
    }

    @PostMapping("/login")
    public String login(@Valid @RequestBody LoginRequest request) {

        String token = authService.login(
                request.getUsername(),
                request.getPassword()
        );

        if (token == null) {
            return "Invalid username or password";
        }

        return token;
    }
}