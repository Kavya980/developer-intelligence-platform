package com.kavya.developerintelligenceplatform.dto;

public class LeetcodeProfileDTO {

    private String username;
    private String profileUrl;

    public LeetcodeProfileDTO() {
    }

    public LeetcodeProfileDTO(String username, String profileUrl) {
        this.username = username;
        this.profileUrl = profileUrl;
    }

    public String getUsername() {
        return username;
    }

    public String getProfileUrl() {
        return profileUrl;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setProfileUrl(String profileUrl) {
        this.profileUrl = profileUrl;
    }
}