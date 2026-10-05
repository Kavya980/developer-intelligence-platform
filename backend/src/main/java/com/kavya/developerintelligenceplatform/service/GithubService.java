package com.kavya.developerintelligenceplatform.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
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
            String githubUsername) throws IOException, InterruptedException {

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
}