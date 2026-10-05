package com.kavya.developerintelligenceplatform.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GithubCommitDTO {

    private String sha;

    @JsonProperty("commit")
    private CommitDetails commit;

    public GithubCommitDTO() {
    }

    public String getSha() {
        return sha;
    }

    public CommitDetails getCommit() {
        return commit;
    }

    public void setSha(String sha) {
        this.sha = sha;
    }

    public void setCommit(CommitDetails commit) {
        this.commit = commit;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class CommitDetails {

        private String message;
        private Author author;

        public CommitDetails() {
        }

        public String getMessage() {
            return message;
        }

        public Author getAuthor() {
            return author;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public void setAuthor(Author author) {
            this.author = author;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Author {

        private String name;
        private String date;

        public Author() {
        }

        public String getName() {
            return name;
        }

        public String getDate() {
            return date;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setDate(String date) {
            this.date = date;
        }
    }
}