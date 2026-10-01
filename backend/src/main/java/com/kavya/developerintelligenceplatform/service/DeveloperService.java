package com.kavya.developerintelligenceplatform.service;

import java.util.List;

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

    public List<Developer> getAllDevelopers() {
        return developerRepository.findAll();
    }

    public Developer getDeveloperById(Long id) {
        return developerRepository.findById(id).orElse(null);
    }
}