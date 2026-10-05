package com.kavya.developerintelligenceplatform.service;

import com.kavya.developerintelligenceplatform.dto.GithubCommitDTO;
import com.kavya.developerintelligenceplatform.entity.Developer;
import com.kavya.developerintelligenceplatform.entity.GithubCommit;
import com.kavya.developerintelligenceplatform.entity.GithubRepository;
import com.kavya.developerintelligenceplatform.repository.DeveloperRepository;
import com.kavya.developerintelligenceplatform.repository.GithubCommitRepository;
import com.kavya.developerintelligenceplatform.repository.GithubRepositoryRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GithubCommitService {

    private final GithubCommitRepository githubCommitRepository;
    private final GithubRepositoryRepository githubRepositoryRepository;
    private final DeveloperRepository developerRepository;
    private final GithubService githubService;

    public GithubCommitService(
            GithubCommitRepository githubCommitRepository,
            GithubRepositoryRepository githubRepositoryRepository,
            DeveloperRepository developerRepository,
            GithubService githubService) {

        this.githubCommitRepository = githubCommitRepository;
        this.githubRepositoryRepository = githubRepositoryRepository;
        this.developerRepository = developerRepository;
        this.githubService = githubService;
    }

    public List<GithubCommit> syncCommits(Long developerId)
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

        List<GithubRepository> repositories =
                githubRepositoryRepository
                        .findByDeveloper(developer);

        List<GithubCommit> savedCommits =
                new ArrayList<>();

        for (GithubRepository repository : repositories) {

            List<GithubCommitDTO> commits =
                    githubService.getCommits(
                            username,
                            repository.getName()
                    );

            for (GithubCommitDTO dto : commits) {

                GithubCommit commit =
                        githubCommitRepository
                                .findBySha(dto.getSha());

                if (commit == null) {
                    commit = new GithubCommit();
                    commit.setSha(dto.getSha());
                }

                commit.setRepository(repository);

                if (dto.getCommit() != null) {

                    commit.setMessage(
                            dto.getCommit().getMessage()
                    );

                    if (dto.getCommit().getAuthor() != null) {

                        commit.setAuthorName(
                                dto.getCommit()
                                        .getAuthor()
                                        .getName()
                        );

                        commit.setAuthorDate(
                                dto.getCommit()
                                        .getAuthor()
                                        .getDate()
                        );
                    }
                }

                savedCommits.add(
                        githubCommitRepository.save(commit)
                );
            }
        }

        return savedCommits;
    }

    public List<GithubCommit> getCommits(Long developerId) {

        Developer developer =
                developerRepository.findById(developerId)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Developer not found"));

        List<GithubRepository> repositories =
                githubRepositoryRepository
                        .findByDeveloper(developer);

        List<GithubCommit> commits =
                new ArrayList<>();

        for (GithubRepository repository : repositories) {

            commits.addAll(
                    githubCommitRepository
                            .findByRepository(repository)
            );
        }

        return commits;
    }
}