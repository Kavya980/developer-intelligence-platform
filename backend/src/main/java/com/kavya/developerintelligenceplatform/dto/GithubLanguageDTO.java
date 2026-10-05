package com.kavya.developerintelligenceplatform.dto;

public class GithubLanguageDTO {

    private String language;
    private long bytes;

    public GithubLanguageDTO() {
    }

    public GithubLanguageDTO(String language, long bytes) {
        this.language = language;
        this.bytes = bytes;
    }

    public String getLanguage() {
        return language;
    }

    public long getBytes() {
        return bytes;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setBytes(long bytes) {
        this.bytes = bytes;
    }
}