package com.kavya.developerintelligenceplatform.controller;

import com.kavya.developerintelligenceplatform.dto.DeveloperAnalyticsDTO;
import com.kavya.developerintelligenceplatform.service.DeveloperAnalyticsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/analytics")
public class DeveloperAnalyticsController {

    private final DeveloperAnalyticsService analyticsService;

    public DeveloperAnalyticsController(
            DeveloperAnalyticsService analyticsService) {
        this.analyticsService = analyticsService;
    }

    @GetMapping("/{developerId}")
    public DeveloperAnalyticsDTO getAnalytics(
            @PathVariable Long developerId)
            throws Exception {

        return analyticsService.getAnalytics(developerId);
    }
}