package com.kavya.developerintelligenceplatform.dto;

public class LeetcodeActivityDTO {

    private int id;
    private String title;
    private String titleSlug;
    private String timestamp;

    public LeetcodeActivityDTO() {
    }

    public LeetcodeActivityDTO(
            int id,
            String title,
            String titleSlug,
            String timestamp) {

        this.id = id;
        this.title = title;
        this.titleSlug = titleSlug;
        this.timestamp = timestamp;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getTitleSlug() {
        return titleSlug;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setTitleSlug(String titleSlug) {
        this.titleSlug = titleSlug;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}