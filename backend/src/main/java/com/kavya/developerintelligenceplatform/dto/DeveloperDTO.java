package com.kavya.developerintelligenceplatform.dto;

import jakarta.validation.constraints.NotBlank;


public class DeveloperDTO {

    @NotBlank(message = "Username cannot be empty")
    private String username;

    @NotBlank(message = "Name cannot be empty")
    private String name;

    public DeveloperDTO() {
    }

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setName(String name) {
        this.name = name;
    }
}