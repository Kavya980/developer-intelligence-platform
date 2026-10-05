package com.kavya.developerintelligenceplatform.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kavya.developerintelligenceplatform.dto.GithubCommitActivityDTO;
import com.kavya.developerintelligenceplatform.dto.GithubCommitDTO;
import com.kavya.developerintelligenceplatform.dto.GithubRepositoryDTO;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

@Service
public class GithubService {

    private final ObjectMapper objectMapper;
    private final HttpClient httpClient;

    public GithubService(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
        this.httpClient = HttpClient.newHttpClient();
    }

    public List<GithubRepositoryDTO> getRepositories(
            String githubUsername)
            throws IOException, InterruptedException {

        String url =
                "https://api.github.com/users/"
                        + githubUsername
                        + "/repos?per_page=100";

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Accept", "application/vnd.github+json")
                .header("X-GitHub-Api-Version", "2022-11-28")
                .GET()
                .build();

        HttpResponse<String> response =
                httpClient.send(
                        request,
                        HttpResponse.BodyHandlers.ofString()
                );

        if (response.statusCode() != 200) {
            throw new RuntimeException(
                    "GitHub API error: " + response.statusCode());
        }

        return objectMapper.readValue(
                response.body(),
                new TypeReference<List<GithubRepositoryDTO>>() {}
        );
    }

    public List<GithubCommitDTO> getCommits(
            String username,
            String repository)
            throws IOException, InterruptedException {

        String url =
                "https://api.github.com/repos/"
                        + username
                        + "/"
                        + repository
                        + "/commits?per_page=10";

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Accept", "application/vnd.github+json")
                .header("X-GitHub-Api-Version", "2022-11-28")
                .GET()
                .build();

        HttpResponse<String> response =
                httpClient.send(
                        request,
                        HttpResponse.BodyHandlers.ofString()
                );

        if (response.statusCode() != 200) {
            throw new RuntimeException(
                    "GitHub API error: " + response.statusCode());
        }

        return objectMapper.readValue(
                response.body(),
                new TypeReference<List<GithubCommitDTO>>() {}
        );
    }

    public GithubCommitActivityDTO getCommitActivity(
            String username,
            String repository)
            throws IOException, InterruptedException {

        List<GithubCommitDTO> commits =
                getCommits(username, repository);

        if (commits.isEmpty()) {
            return new GithubCommitActivityDTO(
                    repository,
                    0,
                    null,
                    null,
                    null
            );
        }

        GithubCommitDTO latestCommit = commits.get(0);

        String message =
                latestCommit.getCommit() != null
                        ? latestCommit.getCommit().getMessage()
                        : null;

        String authorName = null;
        String date = null;

        if (latestCommit.getCommit() != null
                && latestCommit.getCommit().getAuthor() != null) {

            authorName =
                    latestCommit.getCommit()
                            .getAuthor()
                            .getName();

            date =
                    latestCommit.getCommit()
                            .getAuthor()
                            .getDate();
        }

        return new GithubCommitActivityDTO(
                repository,
                commits.size(),
                message,
                authorName,
                date
        );
    }
}