package com.kavya.developerintelligenceplatform.service;

import com.kavya.developerintelligenceplatform.dto.GithubRepositoryDTO;
import com.kavya.developerintelligenceplatform.entity.Developer;
import com.kavya.developerintelligenceplatform.entity.GithubRepository;
import com.kavya.developerintelligenceplatform.repository.DeveloperRepository;
import com.kavya.developerintelligenceplatform.repository.GithubRepositoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GithubRepositoryService {

    private final GithubRepositoryRepository githubRepositoryRepository;
    private final DeveloperRepository developerRepository;
    private final GithubService githubService;

    public GithubRepositoryService(
            GithubRepositoryRepository githubRepositoryRepository,
            DeveloperRepository developerRepository,
            GithubService githubService) {

        this.githubRepositoryRepository = githubRepositoryRepository;
        this.developerRepository = developerRepository;
        this.githubService = githubService;
    }

    public List<GithubRepository> syncRepositories(
            Long developerId)
            throws Exception {

        Developer developer =
                developerRepository.findById(developerId)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Developer not found"));

        String username = developer.getGithubUsername();

        if (username == null || username.isBlank()) {
            throw new RuntimeException(
                    "GitHub username not found");
        }

        List<GithubRepositoryDTO> githubRepositories =
                githubService.getRepositories(username);

        for (GithubRepositoryDTO dto : githubRepositories) {

            GithubRepository repository =
                    githubRepositoryRepository
                            .findByGithubRepositoryId(dto.getId());

            if (repository == null) {
                repository = new GithubRepository();
                repository.setGithubRepositoryId(dto.getId());
            }

            repository.setName(dto.getName());
            repository.setFullName(dto.getFullName());
            repository.setDescription(dto.getDescription());
            repository.setHtmlUrl(dto.getHtmlUrl());
            repository.setStars(dto.getStars());
            repository.setForks(dto.getForks());
            repository.setLanguage(dto.getLanguage());
            repository.setOpenIssues(dto.getOpenIssues());
            repository.setUpdatedAt(dto.getUpdatedAt());
            repository.setDeveloper(developer);

            githubRepositoryRepository.save(repository);
        }

        return githubRepositoryRepository
                .findByDeveloper(developer);
    }

    public List<GithubRepository> getRepositories(
            Long developerId) {

        Developer developer =
                developerRepository.findById(developerId)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Developer not found"));

        return githubRepositoryRepository
                .findByDeveloper(developer);
    }
}