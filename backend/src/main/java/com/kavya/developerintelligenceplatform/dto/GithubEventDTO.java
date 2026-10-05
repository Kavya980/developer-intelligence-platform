package com.kavya.developerintelligenceplatform.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GithubEventDTO {

    private String id;
    private String type;

    @JsonProperty("created_at")
    private String createdAt;

    private Repo repo;

    public GithubEventDTO() {
    }

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public Repo getRepo() {
        return repo;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public void setRepo(Repo repo) {
        this.repo = repo;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Repo {

        private String name;

        public Repo() {
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}