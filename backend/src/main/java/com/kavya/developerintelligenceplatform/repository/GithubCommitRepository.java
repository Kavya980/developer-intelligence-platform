package com.kavya.developerintelligenceplatform.repository;

import com.kavya.developerintelligenceplatform.entity.GithubCommit;
import com.kavya.developerintelligenceplatform.entity.GithubRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GithubCommitRepository
        extends JpaRepository<GithubCommit, Long> {

    GithubCommit findBySha(String sha);

    List<GithubCommit> findByRepository(GithubRepository repository);
}