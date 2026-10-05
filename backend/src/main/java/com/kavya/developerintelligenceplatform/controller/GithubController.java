package com.kavya.developerintelligenceplatform.controller;

import com.kavya.developerintelligenceplatform.dto.GithubCommitActivityDTO;
import com.kavya.developerintelligenceplatform.dto.GithubCommitDTO;
import com.kavya.developerintelligenceplatform.dto.GithubEventDTO;
import com.kavya.developerintelligenceplatform.dto.GithubIssueDTO;
import com.kavya.developerintelligenceplatform.dto.GithubLanguageSummaryDTO;
import com.kavya.developerintelligenceplatform.dto.GithubPullRequestDTO;
import com.kavya.developerintelligenceplatform.dto.GithubRepositoryDTO;
import com.kavya.developerintelligenceplatform.entity.GithubRepository;
import com.kavya.developerintelligenceplatform.service.GithubRepositoryService;
import com.kavya.developerintelligenceplatform.service.GithubService;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/github")
public class GithubController {

    private final GithubService githubService;
    private final GithubRepositoryService githubRepositoryService;

    public GithubController(
            GithubService githubService,
            GithubRepositoryService githubRepositoryService) {

        this.githubService = githubService;
        this.githubRepositoryService = githubRepositoryService;
    }

    @GetMapping("/repositories/{username}")
    public List<GithubRepositoryDTO> getRepositories(
            @PathVariable String username)
            throws IOException, InterruptedException {

        return githubService.getRepositories(username);
    }

    @GetMapping("/repositories/{username}/{repository}/commits")
    public List<GithubCommitDTO> getCommits(
            @PathVariable String username,
            @PathVariable String repository)
            throws IOException, InterruptedException {

        return githubService.getCommits(
                username,
                repository
        );
    }

    @GetMapping("/repositories/{username}/{repository}/activity")
    public GithubCommitActivityDTO getCommitActivity(
            @PathVariable String username,
            @PathVariable String repository)
            throws IOException, InterruptedException {

        return githubService.getCommitActivity(
                username,
                repository
        );
    }

    @GetMapping("/repositories/{username}/{repository}/languages")
    public GithubLanguageSummaryDTO getLanguages(
            @PathVariable String username,
            @PathVariable String repository)
            throws IOException, InterruptedException {

        return githubService.getLanguages(
                username,
                repository
        );
    }

    @GetMapping("/repositories/{username}/{repository}/issues")
    public List<GithubIssueDTO> getIssues(
            @PathVariable String username,
            @PathVariable String repository)
            throws IOException, InterruptedException {

        return githubService.getIssues(
                username,
                repository
        );
    }

    @GetMapping("/repositories/{username}/{repository}/pulls")
    public List<GithubPullRequestDTO> getPullRequests(
            @PathVariable String username,
            @PathVariable String repository)
            throws IOException, InterruptedException {

        return githubService.getPullRequests(
                username,
                repository
        );
    }

    @GetMapping("/users/{username}/events")
    public List<GithubEventDTO> getUserEvents(
            @PathVariable String username)
            throws IOException, InterruptedException {

        return githubService.getUserEvents(username);
    }

    @PostMapping("/sync/{developerId}")
    public List<GithubRepository> syncRepositories(
            @PathVariable Long developerId)
            throws Exception {

        return githubRepositoryService
                .syncRepositories(developerId);
    }

    @GetMapping("/saved/{developerId}")
    public List<GithubRepository> getSavedRepositories(
            @PathVariable Long developerId) {

        return githubRepositoryService
                .getRepositories(developerId);
    }
}