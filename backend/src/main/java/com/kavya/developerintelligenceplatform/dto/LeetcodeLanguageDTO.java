package com.kavya.developerintelligenceplatform.dto;

public class LeetcodeLanguageDTO {

    private String languageName;
    private int problemsSolved;

    public LeetcodeLanguageDTO() {
    }

    public LeetcodeLanguageDTO(
            String languageName,
            int problemsSolved) {

        this.languageName = languageName;
        this.problemsSolved = problemsSolved;
    }

    public String getLanguageName() {
        return languageName;
    }

    public int getProblemsSolved() {
        return problemsSolved;
    }

    public void setLanguageName(String languageName) {
        this.languageName = languageName;
    }

    public void setProblemsSolved(int problemsSolved) {
        this.problemsSolved = problemsSolved;
    }
}