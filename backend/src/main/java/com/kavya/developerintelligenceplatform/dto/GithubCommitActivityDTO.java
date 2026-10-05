package com.kavya.developerintelligenceplatform.dto;

public class GithubCommitActivityDTO {

    private String repository;
    private int totalCommits;
    private String latestCommitMessage;
    private String latestCommitAuthor;
    private String latestCommitDate;

    public GithubCommitActivityDTO() {
    }

    public GithubCommitActivityDTO(
            String repository,
            int totalCommits,
            String latestCommitMessage,
            String latestCommitAuthor,
            String latestCommitDate) {

        this.repository = repository;
        this.totalCommits = totalCommits;
        this.latestCommitMessage = latestCommitMessage;
        this.latestCommitAuthor = latestCommitAuthor;
        this.latestCommitDate = latestCommitDate;
    }

    public String getRepository() {
        return repository;
    }

    public int getTotalCommits() {
        return totalCommits;
    }

    public String getLatestCommitMessage() {
        return latestCommitMessage;
    }

    public String getLatestCommitAuthor() {
        return latestCommitAuthor;
    }

    public String getLatestCommitDate() {
        return latestCommitDate;
    }

    public void setRepository(String repository) {
        this.repository = repository;
    }

    public void setTotalCommits(int totalCommits) {
        this.totalCommits = totalCommits;
    }

    public void setLatestCommitMessage(String latestCommitMessage) {
        this.latestCommitMessage = latestCommitMessage;
    }

    public void setLatestCommitAuthor(String latestCommitAuthor) {
        this.latestCommitAuthor = latestCommitAuthor;
    }

    public void setLatestCommitDate(String latestCommitDate) {
        this.latestCommitDate = latestCommitDate;
    }
}