package com.kavya.developerintelligenceplatform.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class DeveloperDTO {

    @NotBlank(message = "Name cannot be empty")
    private String name;

    @NotBlank(message = "Email cannot be empty")
    @Email(message = "Invalid email")
    private String email;

    private String githubUsername;

    private String leetcodeUsername;

    private String codeforcesUsername;

    public DeveloperDTO() {
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getGithubUsername() {
        return githubUsername;
    }

    public String getLeetcodeUsername() {
        return leetcodeUsername;
    }

    public String getCodeforcesUsername() {
        return codeforcesUsername;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setGithubUsername(String githubUsername) {
        this.githubUsername = githubUsername;
    }

    public void setLeetcodeUsername(String leetcodeUsername) {
        this.leetcodeUsername = leetcodeUsername;
    }

    public void setCodeforcesUsername(String codeforcesUsername) {
        this.codeforcesUsername = codeforcesUsername;
    }
}