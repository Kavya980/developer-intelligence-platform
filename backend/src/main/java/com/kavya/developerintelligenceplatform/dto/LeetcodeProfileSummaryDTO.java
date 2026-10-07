package com.kavya.developerintelligenceplatform.dto;

import java.util.List;

public class LeetcodeProfileSummaryDTO {

    private String username;
    private String profileUrl;
    private LeetcodeStatsDTO stats;
    private LeetcodeContestDTO contest;
    private List<LeetcodeLanguageDTO> languages;

    public LeetcodeProfileSummaryDTO() {
    }

    public LeetcodeProfileSummaryDTO(
            String username,
            String profileUrl,
            LeetcodeStatsDTO stats,
            LeetcodeContestDTO contest,
            List<LeetcodeLanguageDTO> languages) {

        this.username = username;
        this.profileUrl = profileUrl;
        this.stats = stats;
        this.contest = contest;
        this.languages = languages;
    }

    public String getUsername() {
        return username;
    }

    public String getProfileUrl() {
        return profileUrl;
    }

    public LeetcodeStatsDTO getStats() {
        return stats;
    }

    public LeetcodeContestDTO getContest() {
        return contest;
    }

    public List<LeetcodeLanguageDTO> getLanguages() {
        return languages;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setProfileUrl(String profileUrl) {
        this.profileUrl = profileUrl;
    }

    public void setStats(LeetcodeStatsDTO stats) {
        this.stats = stats;
    }

    public void setContest(LeetcodeContestDTO contest) {
        this.contest = contest;
    }

    public void setLanguages(List<LeetcodeLanguageDTO> languages) {
        this.languages = languages;
    }
}