package com.kavya.developerintelligenceplatform.controller;

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
    public Developer createDeveloper(@RequestBody Developer developer) {
        return developerService.saveDeveloper(developer);
    }
}