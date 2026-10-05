package com.kavya.developerintelligenceplatform.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "github_commits")
public class GithubCommit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String sha;

    private String message;
    private String authorName;
    private String authorDate;

    @ManyToOne
    @JoinColumn(name = "repository_id")
    private GithubRepository repository;

    public GithubCommit() {
    }

    public Long getId() {
        return id;
    }

    public String getSha() {
        return sha;
    }

    public String getMessage() {
        return message;
    }

    public String getAuthorName() {
        return authorName;
    }

    public String getAuthorDate() {
        return authorDate;
    }

    public GithubRepository getRepository() {
        return repository;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setSha(String sha) {
        this.sha = sha;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public void setAuthorDate(String authorDate) {
        this.authorDate = authorDate;
    }

    public void setRepository(GithubRepository repository) {
        this.repository = repository;
    }
}