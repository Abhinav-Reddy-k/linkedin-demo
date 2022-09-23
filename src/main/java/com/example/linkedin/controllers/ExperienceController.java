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
    public List<Experience> get() {
        return experienceService.get();
    }

    @GetMapping(value = "/{id}")
    public Experience get(@PathVariable Long id) {
        return experienceService.get(id);
    }

    @GetMapping("/profile/{profileId}")
    public List<Experience> getByProfile(@PathVariable Long profileId) {
        return experienceService.getByProfile(profileId);
    }

    @PostMapping
    public Experience createExperience(@RequestBody Experience experience) {
        return experienceService.createExperience(experience);
    }

    @PutMapping("/{id}")
    public Experience updateExperience(@PathVariable Long id, @RequestBody Experience experience) {
        return experienceService.updateExperience(id,experience);
    }


    @DeleteMapping("/{id}")
    public void deleteJobType(@PathVariable Long id) {
        experienceService.deleteJobType(id);
    }
}
