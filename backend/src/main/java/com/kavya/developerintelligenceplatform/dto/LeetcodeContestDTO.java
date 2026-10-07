package com.kavya.developerintelligenceplatform.dto;

public class LeetcodeContestDTO {

    private String username;
    private Double rating;
    private Integer globalRanking;
    private Integer totalParticipants;
    private Integer attendedContestsCount;

    public LeetcodeContestDTO() {
    }

    public LeetcodeContestDTO(
            String username,
            Double rating,
            Integer globalRanking,
            Integer totalParticipants,
            Integer attendedContestsCount) {

        this.username = username;
        this.rating = rating;
        this.globalRanking = globalRanking;
        this.totalParticipants = totalParticipants;
        this.attendedContestsCount = attendedContestsCount;
    }

    public String getUsername() {
        return username;
    }

    public Double getRating() {
        return rating;
    }

    public Integer getGlobalRanking() {
        return globalRanking;
    }

    public Integer getTotalParticipants() {
        return totalParticipants;
    }

    public Integer getAttendedContestsCount() {
        return attendedContestsCount;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public void setGlobalRanking(Integer globalRanking) {
        this.globalRanking = globalRanking;
    }

    public void setTotalParticipants(Integer totalParticipants) {
        this.totalParticipants = totalParticipants;
    }

    public void setAttendedContestsCount(Integer attendedContestsCount) {
        this.attendedContestsCount = attendedContestsCount;
    }
}