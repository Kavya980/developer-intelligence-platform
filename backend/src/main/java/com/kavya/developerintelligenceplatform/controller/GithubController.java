package com.kavya.developerintelligenceplatform.controller;

import com.kavya.developerintelligenceplatform.dto.GithubCommitActivityDTO;
import com.kavya.developerintelligenceplatform.dto.GithubCommitDTO;
import com.kavya.developerintelligenceplatform.dto.GithubLanguageSummaryDTO;
import com.kavya.developerintelligenceplatform.dto.GithubRepositoryDTO;
import com.kavya.developerintelligenceplatform.service.GithubService;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/github")
public class GithubController {

    private final GithubService githubService;

    public GithubController(GithubService githubService) {
        this.githubService = githubService;
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
}