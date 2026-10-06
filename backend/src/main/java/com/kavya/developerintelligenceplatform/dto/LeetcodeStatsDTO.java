package com.kavya.developerintelligenceplatform.dto;

public class LeetcodeStatsDTO {

    private String username;
    private int totalSolved;
    private int easySolved;
    private int mediumSolved;
    private int hardSolved;

    public LeetcodeStatsDTO() {
    }

    public LeetcodeStatsDTO(
            String username,
            int totalSolved,
            int easySolved,
            int mediumSolved,
            int hardSolved) {

        this.username = username;
        this.totalSolved = totalSolved;
        this.easySolved = easySolved;
        this.mediumSolved = mediumSolved;
        this.hardSolved = hardSolved;
    }

    public String getUsername() {
        return username;
    }

    public int getTotalSolved() {
        return totalSolved;
    }

    public int getEasySolved() {
        return easySolved;
    }

    public int getMediumSolved() {
        return mediumSolved;
    }

    public int getHardSolved() {
        return hardSolved;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setTotalSolved(int totalSolved) {
        this.totalSolved = totalSolved;
    }

    public void setEasySolved(int easySolved) {
        this.easySolved = easySolved;
    }

    public void setMediumSolved(int mediumSolved) {
        this.mediumSolved = mediumSolved;
    }

    public void setHardSolved(int hardSolved) {
        this.hardSolved = hardSolved;
    }
}