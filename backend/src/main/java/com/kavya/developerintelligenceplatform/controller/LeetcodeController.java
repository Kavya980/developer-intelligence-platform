package com.kavya.developerintelligenceplatform.controller;

import com.kavya.developerintelligenceplatform.dto.LeetcodeContestDTO;
import com.kavya.developerintelligenceplatform.dto.LeetcodeProblemDTO;
import com.kavya.developerintelligenceplatform.dto.LeetcodeProfileDTO;
import com.kavya.developerintelligenceplatform.dto.LeetcodeStatsDTO;
import com.kavya.developerintelligenceplatform.service.LeetcodeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/leetcode")
public class LeetcodeController {

    private final LeetcodeService leetcodeService;

    public LeetcodeController(
            LeetcodeService leetcodeService) {
        this.leetcodeService = leetcodeService;
    }

    @GetMapping("/{username}")
    public LeetcodeProfileDTO getProfile(
            @PathVariable String username) {
        return leetcodeService.getProfile(username);
    }

    @GetMapping("/{username}/stats")
    public LeetcodeStatsDTO getStats(
            @PathVariable String username)
            throws Exception {
        return leetcodeService.getStats(username);
    }

    @GetMapping("/problems")
    public List<LeetcodeProblemDTO> getProblems()
            throws Exception {
        return leetcodeService.getProblems();
    }

    @GetMapping("/{username}/contest")
    public LeetcodeContestDTO getContestStats(
            @PathVariable String username)
            throws Exception {
        return leetcodeService.getContestStats(username);
    }
}