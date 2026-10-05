package com.kavya.developerintelligenceplatform.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/developer")
public class DeveloperRoleController {

    @GetMapping("/dashboard")
    public String developerDashboard() {
        return "Welcome Developer";
    }
}