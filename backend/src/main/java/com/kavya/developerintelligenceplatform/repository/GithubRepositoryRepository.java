package com.kavya.developerintelligenceplatform.repository;

import com.kavya.developerintelligenceplatform.entity.Developer;
import com.kavya.developerintelligenceplatform.entity.GithubRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GithubRepositoryRepository
        extends JpaRepository<GithubRepository, Long> {

    List<GithubRepository> findByDeveloper(Developer developer);

    GithubRepository findByGithubRepositoryId(Long githubRepositoryId);
}