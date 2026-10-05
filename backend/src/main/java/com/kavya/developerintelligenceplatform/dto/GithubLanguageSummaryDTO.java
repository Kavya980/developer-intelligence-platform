package com.kavya.developerintelligenceplatform.dto;

import java.util.List;

public class GithubLanguageSummaryDTO {

    private String repository;
    private List<GithubLanguageDTO> languages;

    public GithubLanguageSummaryDTO() {
    }

    public GithubLanguageSummaryDTO(
            String repository,
            List<GithubLanguageDTO> languages) {

        this.repository = repository;
        this.languages = languages;
    }

    public String getRepository() {
        return repository;
    }

    public List<GithubLanguageDTO> getLanguages() {
        return languages;
    }

    public void setRepository(String repository) {
        this.repository = repository;
    }

    public void setLanguages(List<GithubLanguageDTO> languages) {
        this.languages = languages;
    }
}