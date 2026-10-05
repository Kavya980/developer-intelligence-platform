package com.kavya.developerintelligenceplatform.controller;

import com.kavya.developerintelligenceplatform.dto.DeveloperDTO;
import com.kavya.developerintelligenceplatform.entity.Developer;
import com.kavya.developerintelligenceplatform.service.DeveloperService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/developers")
public class DeveloperController {

    private final DeveloperService developerService;

    public DeveloperController(DeveloperService developerService) {
        this.developerService = developerService;
    }

    @PostMapping
    public Developer createDeveloper(
            @Valid @RequestBody DeveloperDTO developerDTO) {

        Developer developer = new Developer();

        developer.setName(developerDTO.getName());
        developer.setEmail(developerDTO.getEmail());
        developer.setGithubUsername(developerDTO.getGithubUsername());
        developer.setLeetcodeUsername(developerDTO.getLeetcodeUsername());
        developer.setCodeforcesUsername(developerDTO.getCodeforcesUsername());

        return developerService.createDeveloper(developer);
    }

    @GetMapping
    public List<Developer> getAllDevelopers() {
        return developerService.getAllDevelopers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Developer> getDeveloperById(
            @PathVariable Long id) {

        Developer developer =
                developerService.getDeveloperById(id);

        if (developer == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(developer);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Developer> updateDeveloper(
            @PathVariable Long id,
            @Valid @RequestBody DeveloperDTO developerDTO) {

        Developer updatedDeveloper = new Developer();

        updatedDeveloper.setName(developerDTO.getName());
        updatedDeveloper.setEmail(developerDTO.getEmail());
        updatedDeveloper.setGithubUsername(
                developerDTO.getGithubUsername());
        updatedDeveloper.setLeetcodeUsername(
                developerDTO.getLeetcodeUsername());
        updatedDeveloper.setCodeforcesUsername(
                developerDTO.getCodeforcesUsername());

        Developer result =
                developerService.updateDeveloper(id, updatedDeveloper);

        if (result == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDeveloper(
            @PathVariable Long id) {

        Developer developer =
                developerService.getDeveloperById(id);

        if (developer == null) {
            return ResponseEntity.notFound().build();
        }

        developerService.deleteDeveloper(id);

        return ResponseEntity.noContent().build();
    }
}