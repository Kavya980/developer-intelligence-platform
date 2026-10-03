package com.kavya.developerintelligenceplatform.controller;

import java.util.List;
import com.kavya.developerintelligenceplatform.dto.DeveloperDTO;
import jakarta.validation.Valid;

import com.kavya.developerintelligenceplatform.entity.Developer;
import com.kavya.developerintelligenceplatform.service.DeveloperService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/developers")
public class DeveloperController {

    private final DeveloperService developerService;

    public DeveloperController(DeveloperService developerService) {
        this.developerService = developerService;
    }

    @PostMapping
    public Developer createDeveloper(@Valid @RequestBody DeveloperDTO developerDTO) {

        Developer developer = new Developer();

        developer.setUsername(developerDTO.getUsername());
        developer.setName(developerDTO.getName());

        return developerService.saveDeveloper(developer);
    }

    @GetMapping
    public List<Developer> getAllDevelopers() {
        return developerService.getAllDevelopers();
    }

    @GetMapping("/{id}")
    public Developer getDeveloperById(@PathVariable Long id) {
        return developerService.getDeveloperById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteDeveloper(@PathVariable Long id) {
        developerService.deleteDeveloper(id);
    }

    @PutMapping("/{id}")
    public Developer updateDeveloper(
            @PathVariable Long id,
            @RequestBody Developer developer) {

        return developerService.updateDeveloper(id, developer);
    }
}