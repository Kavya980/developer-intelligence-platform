package com.kavya.developerintelligenceplatform.service;

import com.kavya.developerintelligenceplatform.entity.Developer;
import com.kavya.developerintelligenceplatform.repository.DeveloperRepository;
import org.springframework.stereotype.Service;

@Service
public class DeveloperService {

    private final DeveloperRepository developerRepository;

    public DeveloperService(DeveloperRepository developerRepository) {
        this.developerRepository = developerRepository;
    }

    public Developer saveDeveloper(Developer developer) {
        return developerRepository.save(developer);
    }
}