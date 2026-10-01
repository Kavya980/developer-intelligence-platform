package com.kavya.developerintelligenceplatform.repository;

import com.kavya.developerintelligenceplatform.entity.Developer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeveloperRepository extends JpaRepository<Developer, Long> {
}