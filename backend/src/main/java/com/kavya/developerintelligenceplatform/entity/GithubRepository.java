package com.kavya.developerintelligenceplatform.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "github_repositories")
public class GithubRepository {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long githubRepositoryId;

    @Column(nullable = false)
    private String name;

    private String fullName;
    private String description;
    private String htmlUrl;
    private int stars;
    private int forks;
    private String language;
    private int openIssues;
    private String updatedAt;

    @ManyToOne
    @JoinColumn(name = "developer_id")
    private Developer developer;

    public GithubRepository() {
    }

    public Long getId() {
        return id;
    }

    public Long getGithubRepositoryId() {
        return githubRepositoryId;
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

    public Developer getDeveloper() {
        return developer;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setGithubRepositoryId(Long githubRepositoryId) {
        this.githubRepositoryId = githubRepositoryId;
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

    public void setDeveloper(Developer developer) {
        this.developer = developer;
    }
}