package com.kavya.developerintelligenceplatform.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kavya.developerintelligenceplatform.dto.LeetcodeProfileDTO;
import com.kavya.developerintelligenceplatform.dto.LeetcodeStatsDTO;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class LeetcodeService {

    private final ObjectMapper objectMapper;
    private final HttpClient httpClient;

    public LeetcodeService(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
        this.httpClient = HttpClient.newHttpClient();
    }

    public LeetcodeProfileDTO getProfile(String username) {

        if (username == null || username.isBlank()) {
            throw new RuntimeException(
                    "LeetCode username cannot be empty");
        }

        String profileUrl =
                "https://leetcode.com/u/" + username + "/";

        return new LeetcodeProfileDTO(
                username,
                profileUrl
        );
    }

    public LeetcodeStatsDTO getStats(String username)
            throws Exception {

        String query = """
                query getUserProfile($username: String!) {
                    matchedUser(username: $username) {
                        username
                        submitStats {
                            acSubmissionNum {
                                difficulty
                                count
                            }
                        }
                    }
                }
                """;

        String variables =
                "{\"username\":\"" + username + "\"}";

        String requestBody =
                objectMapper.writeValueAsString(
                        new GraphQLRequest(
                                query,
                                java.util.Map.of(
                                        "username",
                                        username
                                )
                        )
                );

        HttpRequest request =
                HttpRequest.newBuilder()
                        .uri(URI.create(
                                "https://leetcode.com/graphql"))
                        .header(
                                "Content-Type",
                                "application/json")
                        .header(
                                "User-Agent",
                                "Mozilla/5.0")
                        .POST(
                                HttpRequest.BodyPublishers
                                        .ofString(requestBody))
                        .build();

        HttpResponse<String> response =
                httpClient.send(
                        request,
                        HttpResponse.BodyHandlers.ofString()
                );

        if (response.statusCode() != 200) {
            throw new RuntimeException(
                    "LeetCode API error: "
                            + response.statusCode());
        }

        JsonNode root =
                objectMapper.readTree(response.body());

        JsonNode user =
                root.path("data")
                        .path("matchedUser");

        if (user.isMissingNode()
                || user.isNull()) {

            throw new RuntimeException(
                    "LeetCode user not found");
        }

        int total = 0;
        int easy = 0;
        int medium = 0;
        int hard = 0;

        JsonNode submissions =
                user.path("submitStats")
                        .path("acSubmissionNum");

        for (JsonNode submission : submissions) {

            String difficulty =
                    submission.path("difficulty")
                            .asText();

            int count =
                    submission.path("count")
                            .asInt();

            switch (difficulty) {

                case "All" -> total = count;

                case "Easy" -> easy = count;

                case "Medium" -> medium = count;

                case "Hard" -> hard = count;
            }
        }

        return new LeetcodeStatsDTO(
                username,
                total,
                easy,
                medium,
                hard
        );
    }

    private record GraphQLRequest(
            String query,
            java.util.Map<String, String> variables) {
    }
}