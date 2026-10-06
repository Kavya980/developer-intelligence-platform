package com.kavya.developerintelligenceplatform.dto;

import java.util.List;

public class LeetcodeProblemDTO {

    private int questionId;
    private String title;
    private String difficulty;
    private List<String> topics;

    public LeetcodeProblemDTO() {
    }

    public LeetcodeProblemDTO(
            int questionId,
            String title,
            String difficulty,
            List<String> topics) {

        this.questionId = questionId;
        this.title = title;
        this.difficulty = difficulty;
        this.topics = topics;
    }

    public int getQuestionId() {
        return questionId;
    }

    public String getTitle() {
        return title;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public List<String> getTopics() {
        return topics;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public void setTopics(List<String> topics) {
        this.topics = topics;
    }
}