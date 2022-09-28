package com.example.linkedin.controllers;

import com.example.linkedin.entities.Experience;
import com.example.linkedin.services.ExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/experience")
public class ExperienceController {

    @Autowired
    private ExperienceService experienceService;

    @GetMapping
    public List<Experience> getAllExperience() {
        return experienceService.getAllExperience();
    }

    @GetMapping(value = "/{id}")
    public Experience getExperienceById(@PathVariable Long id) {
        return experienceService.getExperienceById(id);
    }

    @GetMapping("/profile/{profileId}")
    public List<Experience> getExperienceByProfile(@PathVariable Long profileId) {
        return experienceService.getExperienceByProfile(profileId);
    }

    @PostMapping
    public Experience createExperience(@RequestBody Experience experience) {
        return experienceService.createExperience(experience);
    }

    @PutMapping("/{id}")
    public Experience updateExperience(@PathVariable Long id, @RequestBody Experience experience) {
        return experienceService.updateExperience(id, experience);
    }


    @DeleteMapping("/{id}")
    public void deleteExperience(@PathVariable Long id) {
        experienceService.deleteExperience(id);
    }
}
