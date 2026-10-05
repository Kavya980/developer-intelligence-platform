package com.kavya.developerintelligenceplatform.entity;

import jakarta.persistence.*;

@Entity
public class Developer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    private String githubUsername;

    private String leetcodeUsername;

    private String codeforcesUsername;

    public Developer() {
    }

    public Long getId() {
        return id;
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

    public void setId(Long id) {
        this.id = id;
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