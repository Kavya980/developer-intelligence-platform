package com.kavya.developerintelligenceplatform.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GithubRepositoryDTO {

    private Long id;
    private String name;

    @JsonProperty("full_name")
    private String fullName;

    private String description;

    @JsonProperty("html_url")
    private String htmlUrl;

    @JsonProperty("stargazers_count")
    private int stars;

    @JsonProperty("forks_count")
    private int forks;

    private String language;

    @JsonProperty("open_issues_count")
    private int openIssues;

    @JsonProperty("updated_at")
    private String updatedAt;

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

    public int getOpenIssues() {
        return openIssues;
    }

    public String getUpdatedAt() {
        return updatedAt;
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

    public void setOpenIssues(int openIssues) {
        this.openIssues = openIssues;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
}