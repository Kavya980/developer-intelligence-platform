package com.kavya.developerintelligenceplatform.service;

import com.kavya.developerintelligenceplatform.dto.DeveloperAnalyticsDTO;
import com.kavya.developerintelligenceplatform.dto.LeetcodeContestDTO;
import com.kavya.developerintelligenceplatform.dto.LeetcodeLanguageDTO;
import com.kavya.developerintelligenceplatform.dto.LeetcodeStatsDTO;
import com.kavya.developerintelligenceplatform.entity.Developer;
import com.kavya.developerintelligenceplatform.entity.GithubRepository;
import com.kavya.developerintelligenceplatform.repository.DeveloperRepository;
import com.kavya.developerintelligenceplatform.repository.GithubRepositoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeveloperAnalyticsService {

    private final DeveloperRepository developerRepository;
    private final GithubRepositoryRepository githubRepositoryRepository;
    private final LeetcodeService leetcodeService;

    public DeveloperAnalyticsService(
            DeveloperRepository developerRepository,
            GithubRepositoryRepository githubRepositoryRepository,
            LeetcodeService leetcodeService) {

        this.developerRepository = developerRepository;
        this.githubRepositoryRepository = githubRepositoryRepository;
        this.leetcodeService = leetcodeService;
    }

    public DeveloperAnalyticsDTO getAnalytics(Long developerId)
            throws Exception {

        Developer developer =
                developerRepository.findById(developerId)
                        .orElseThrow(() ->
                                new RuntimeException("Developer not found"));

        DeveloperAnalyticsDTO analytics =
                new DeveloperAnalyticsDTO();

        analytics.setDeveloperId(developerId);

        // =========================
        // GitHub Analytics
        // =========================

        List<GithubRepository> repositories =
                githubRepositoryRepository.findByDeveloper(developer);

        analytics.setGithubRepositories(repositories.size());

        int stars = 0;
        int forks = 0;
        int openIssues = 0;

        for (GithubRepository repository : repositories) {
            stars += repository.getStars();
            forks += repository.getForks();
            openIssues += repository.getOpenIssues();
        }

        analytics.setGithubStars(stars);
        analytics.setGithubForks(forks);
        analytics.setGithubOpenIssues(openIssues);

        // =========================
        // LeetCode Analytics
        // =========================

        String username = developer.getLeetcodeUsername();

        if (username != null && !username.isBlank()) {

            LeetcodeStatsDTO stats =
                    leetcodeService.getStats(username);

            analytics.setLeetcodeTotalSolved(
                    stats.getTotalSolved());

            analytics.setLeetcodeEasySolved(
                    stats.getEasySolved());

            analytics.setLeetcodeMediumSolved(
                    stats.getMediumSolved());

            analytics.setLeetcodeHardSolved(
                    stats.getHardSolved());

            LeetcodeContestDTO contest =
                    leetcodeService.getContestStats(username);

            analytics.setLeetcodeRating(
                    contest.getRating());

            List<LeetcodeLanguageDTO> languages =
                    leetcodeService.getLanguages(username);

            analytics.setLanguages(languages);
        }

        // =========================
        // Overall Score
        // =========================

        int score = calculateOverallScore(analytics);

        analytics.setOverallScore(score);

        return analytics;
    }

    private int calculateOverallScore(
            DeveloperAnalyticsDTO analytics) {

        int githubScore =
                Math.min(40,
                        analytics.getGithubRepositories() * 5
                                + analytics.getGithubStars());

        int leetcodeScore =
                Math.min(40,
                        analytics.getLeetcodeTotalSolved() / 3);

        int ratingScore = 0;

        if (analytics.getLeetcodeRating() != null) {
            ratingScore =
                    Math.min(20,
                            (int)
                                    (analytics.getLeetcodeRating()
                                            / 100));
        }

        return Math.min(
                100,
                githubScore + leetcodeScore + ratingScore
        );
    }
}