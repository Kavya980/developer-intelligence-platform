package com.kavya.developerintelligenceplatform.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GithubRepositoryDTO {

    private Long id;
    private String name;
    private String fullName;
    private String description;
    private String htmlUrl;
    private int stars;
    private int forks;
    private String language;

    public GithubRepositoryDTO() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFullName() {
        return fullName;
    }

    public String getDescription() {
        return description;
    }

    public String getHtmlUrl() {
        return htmlUrl;
    }

    public int getStars() {
        return stars;
    }

    public int getForks() {
        return forks;
    }

    public String getLanguage() {
        return language;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setHtmlUrl(String htmlUrl) {
        this.htmlUrl = htmlUrl;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public void setForks(int forks) {
        this.forks = forks;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}