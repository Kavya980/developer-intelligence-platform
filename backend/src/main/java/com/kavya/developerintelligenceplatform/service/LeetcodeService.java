package com.kavya.developerintelligenceplatform.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kavya.developerintelligenceplatform.dto.LeetcodeContestDTO;
import com.kavya.developerintelligenceplatform.dto.LeetcodeProblemDTO;
import com.kavya.developerintelligenceplatform.dto.LeetcodeProfileDTO;
import com.kavya.developerintelligenceplatform.dto.LeetcodeStatsDTO;
import org.springframework.stereotype.Service;
import com.kavya.developerintelligenceplatform.dto.LeetcodeLanguageDTO;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

        return new LeetcodeProfileDTO(
                username,
                "https://leetcode.com/u/" + username + "/"
        );
    }

    public LeetcodeStatsDTO getStats(String username)
            throws Exception {

        String query = """
                query getUserProfile($username: String!) {
                    matchedUser(username: $username) {
                        username
                        submitStats: submitStatsGlobal {
                            acSubmissionNum {
                                difficulty
                                count
                            }
                        }
                    }
                }
                """;

        JsonNode user =
                executeQuery(
                        query,
                        Map.of("username", username),
                        "getUserProfile")
                        .path("data")
                        .path("matchedUser");

        if (user.isMissingNode() || user.isNull()) {
            throw new RuntimeException(
                    "LeetCode user not found");
        }

        int total = 0;
        int easy = 0;
        int medium = 0;
        int hard = 0;

        for (JsonNode submission :
                user.path("submitStats")
                        .path("acSubmissionNum")) {

            int count =
                    submission
                            .path("count")
                            .asInt();

            switch (
                    submission
                            .path("difficulty")
                            .asText()) {

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

    public List<LeetcodeProblemDTO> getProblems()
            throws Exception {

        String query = """
                query problemsetQuestionList(
                    $categorySlug: String,
                    $limit: Int,
                    $skip: Int,
                    $filters: QuestionListFilterInput
                ) {
                    problemsetQuestionList: questionList(
                        categorySlug: $categorySlug,
                        limit: $limit,
                        skip: $skip,
                        filters: $filters
                    ) {
                        total: totalNum
                        questions: data {
                            difficulty
                            questionFrontendId
                            title
                            titleSlug
                            topicTags {
                                name
                                id
                                slug
                            }
                        }
                    }
                }
                """;

        Map<String, Object> variables =
                Map.of(
                        "categorySlug", "",
                        "limit", 20,
                        "skip", 0,
                        "filters", Map.of()
                );

        JsonNode questions =
                executeQuery(
                        query,
                        variables,
                        "problemsetQuestionList")
                        .path("data")
                        .path("problemsetQuestionList")
                        .path("questions");

        if (!questions.isArray()) {
            throw new RuntimeException(
                    "Invalid LeetCode problem response");
        }

        List<LeetcodeProblemDTO> problems =
                new ArrayList<>();

        for (JsonNode question : questions) {

            List<String> topics =
                    new ArrayList<>();

            for (JsonNode topic :
                    question.path("topicTags")) {

                topics.add(
                        topic
                                .path("name")
                                .asText()
                );
            }

            problems.add(
                    new LeetcodeProblemDTO(
                            question
                                    .path("questionFrontendId")
                                    .asInt(),

                            question
                                    .path("title")
                                    .asText(),

                            question
                                    .path("difficulty")
                                    .asText(),

                            topics
                    )
            );
        }

        return problems;
    }

    public LeetcodeContestDTO getContestStats(
            String username)
            throws Exception {

        String query = """
            query userContestRankingInfo(
                $username: String!
            ) {
                userContestRanking(
                    username: $username
                ) {
                    attendedContestsCount
                    rating
                    globalRanking
                    totalParticipants
                }
            }
            """;

        JsonNode contest =
                executeQuery(
                        query,
                        Map.of("username", username),
                        "userContestRankingInfo")
                        .path("data")
                        .path("userContestRanking");

        // User has no contest history
        if (contest.isMissingNode() || contest.isNull()) {

            return new LeetcodeContestDTO(
                    username,
                    null,
                    null,
                    null,
                    0
            );
        }

        return new LeetcodeContestDTO(
                username,
                contest.path("rating").asDouble(),
                contest.path("globalRanking").asInt(),
                contest.path("totalParticipants").asInt(),
                contest.path("attendedContestsCount").asInt()
        );
    }

    public List<LeetcodeLanguageDTO> getLanguages(
            String username)
            throws Exception {

        String query = """
            query languageStats($username: String!) {
                matchedUser(username: $username) {
                    languageProblemCount {
                        languageName
                        problemsSolved
                    }
                }
            }
            """;

        JsonNode languages =
                executeQuery(
                        query,
                        Map.of("username", username),
                        "languageStats")
                        .path("data")
                        .path("matchedUser")
                        .path("languageProblemCount");

        if (!languages.isArray()) {
            throw new RuntimeException(
                    "Invalid LeetCode language response");
        }

        List<LeetcodeLanguageDTO> result =
                new ArrayList<>();

        for (JsonNode language : languages) {

            result.add(
                    new LeetcodeLanguageDTO(
                            language
                                    .path("languageName")
                                    .asText(),

                            language
                                    .path("problemsSolved")
                                    .asInt()
                    )
            );
        }

        return result;
    }

    private JsonNode executeQuery(
            String query,
            Map<String, ?> variables,
            String operationName)
            throws Exception {

        String requestBody =
                objectMapper.writeValueAsString(
                        Map.of(
                                "query", query,
                                "variables", variables,
                                "operationName", operationName
                        )
                );

        HttpRequest request =
                HttpRequest.newBuilder()
                        .uri(URI.create(
                                "https://leetcode.com/graphql/"))
                        .header(
                                "Content-Type",
                                "application/json")
                        .header(
                                "User-Agent",
                                "Mozilla/5.0")
                        .header(
                                "Accept",
                                "application/json")
                        .POST(
                                HttpRequest.BodyPublishers
                                        .ofString(requestBody))
                        .build();

        HttpResponse<String> response =
                httpClient.send(
                        request,
                        HttpResponse.BodyHandlers
                                .ofString());

        if (response.statusCode() != 200) {

            throw new RuntimeException(
                    "LeetCode API error: "
                            + response.statusCode()
                            + " - "
                            + response.body());
        }

        return objectMapper.readTree(
                response.body());
    }
}