package com.kavya.developerintelligenceplatform.service;

import com.kavya.developerintelligenceplatform.entity.Role;
import com.kavya.developerintelligenceplatform.entity.User;
import com.kavya.developerintelligenceplatform.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthService(UserRepository userRepository,
                       PasswordEncoder passwordEncoder,
                       JwtService jwtService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    public User register(String username, String password) {

        User user = new User();

        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        user.setRole(Role.DEVELOPER);

        return userRepository.save(user);
    }

    public String login(String username, String password) {

        User user = userRepository.findByUsername(username)
                .orElse(null);

        if (user == null) {
            return null;
        }

        if (!passwordEncoder.matches(password, user.getPassword())) {
            return null;
        }

        return jwtService.generateToken(user.getUsername());
    }
}