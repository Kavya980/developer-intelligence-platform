package com.kavya.developerintelligenceplatform.dto;

import java.util.List;

public class DeveloperAnalyticsDTO {

    private Long developerId;

    private int githubRepositories;
    private int githubStars;
    private int githubForks;
    private int githubOpenIssues;

    private int leetcodeTotalSolved;
    private int leetcodeEasySolved;
    private int leetcodeMediumSolved;
    private int leetcodeHardSolved;

    private Double leetcodeRating;

    private List<LeetcodeLanguageDTO> languages;

    private int overallScore;

    public DeveloperAnalyticsDTO() {
    }

    public Long getDeveloperId() {
        return developerId;
    }

    public int getGithubRepositories() {
        return githubRepositories;
    }

    public int getGithubStars() {
        return githubStars;
    }

    public int getGithubForks() {
        return githubForks;
    }

    public int getGithubOpenIssues() {
        return githubOpenIssues;
    }

    public int getLeetcodeTotalSolved() {
        return leetcodeTotalSolved;
    }

    public int getLeetcodeEasySolved() {
        return leetcodeEasySolved;
    }

    public int getLeetcodeMediumSolved() {
        return leetcodeMediumSolved;
    }

    public int getLeetcodeHardSolved() {
        return leetcodeHardSolved;
    }

    public Double getLeetcodeRating() {
        return leetcodeRating;
    }

    public List<LeetcodeLanguageDTO> getLanguages() {
        return languages;
    }

    public int getOverallScore() {
        return overallScore;
    }

    public void setDeveloperId(Long developerId) {
        this.developerId = developerId;
    }

    public void setGithubRepositories(int githubRepositories) {
        this.githubRepositories = githubRepositories;
    }

    public void setGithubStars(int githubStars) {
        this.githubStars = githubStars;
    }

    public void setGithubForks(int githubForks) {
        this.githubForks = githubForks;
    }

    public void setGithubOpenIssues(int githubOpenIssues) {
        this.githubOpenIssues = githubOpenIssues;
    }

    public void setLeetcodeTotalSolved(int leetcodeTotalSolved) {
        this.leetcodeTotalSolved = leetcodeTotalSolved;
    }

    public void setLeetcodeEasySolved(int leetcodeEasySolved) {
        this.leetcodeEasySolved = leetcodeEasySolved;
    }

    public void setLeetcodeMediumSolved(int leetcodeMediumSolved) {
        this.leetcodeMediumSolved = leetcodeMediumSolved;
    }

    public void setLeetcodeHardSolved(int leetcodeHardSolved) {
        this.leetcodeHardSolved = leetcodeHardSolved;
    }

    public void setLeetcodeRating(Double leetcodeRating) {
        this.leetcodeRating = leetcodeRating;
    }

    public void setLanguages(List<LeetcodeLanguageDTO> languages) {
        this.languages = languages;
    }

    public void setOverallScore(int overallScore) {
        this.overallScore = overallScore;
    }
}