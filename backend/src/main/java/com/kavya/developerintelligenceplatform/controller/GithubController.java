package com.kavya.developerintelligenceplatform.controller;

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
}