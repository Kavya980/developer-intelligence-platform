package com.kavya.developerintelligenceplatform.service;

import com.kavya.developerintelligenceplatform.entity.Developer;
import com.kavya.developerintelligenceplatform.repository.DeveloperRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeveloperService {

    private final DeveloperRepository developerRepository;

    public DeveloperService(DeveloperRepository developerRepository) {
        this.developerRepository = developerRepository;
    }

    public Developer createDeveloper(Developer developer) {
        return developerRepository.save(developer);
    }

    public List<Developer> getAllDevelopers() {
        return developerRepository.findAll();
    }

    public Developer getDeveloperById(Long id) {
        return developerRepository.findById(id).orElse(null);
    }

    public Developer updateDeveloper(Long id, Developer updatedDeveloper) {

        Developer existingDeveloper =
                developerRepository.findById(id).orElse(null);

        if (existingDeveloper == null) {
            return null;
        }

        existingDeveloper.setName(updatedDeveloper.getName());
        existingDeveloper.setEmail(updatedDeveloper.getEmail());
        existingDeveloper.setGithubUsername(
                updatedDeveloper.getGithubUsername());
        existingDeveloper.setLeetcodeUsername(
                updatedDeveloper.getLeetcodeUsername());
        existingDeveloper.setCodeforcesUsername(
                updatedDeveloper.getCodeforcesUsername());

        return developerRepository.save(existingDeveloper);
    }

    public void deleteDeveloper(Long id) {
        developerRepository.deleteById(id);
    }
}