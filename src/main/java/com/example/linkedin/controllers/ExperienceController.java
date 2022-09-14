package com.example.linkedin.controllers;

import com.example.linkedin.model.Experience;
import com.example.linkedin.repositories.ExperienceRepository;
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
@RequestMapping("/experience")
public class ExperienceController {

    final
    ExperienceRepository experienceRepository;


    public ExperienceController(ExperienceRepository experienceRepository) {
        this.experienceRepository = experienceRepository;
    }

    @GetMapping
    public List<Experience> get() {
        return experienceRepository.findAll();
    }

    @GetMapping(value = "/{id}")
    public Experience get(@PathVariable Long id) {
        return experienceRepository.findById(id).get();
    }

    @GetMapping("/profile/{profileId}")
    public List<Experience> getByProfile(@PathVariable Long profileId){
        return experienceRepository.findByProfileId(profileId);
    }

    @PostMapping
    public Experience createExperience(@RequestBody Experience experience) {
        return experienceRepository.save(experience);
    }

    @PutMapping("/{id}")
    public Experience updateExperience(@PathVariable Long id, @RequestBody Experience experience) {
        return experienceRepository.findById(id)
                .map(oldExperience -> {
                    oldExperience.setJobRole(experience.getJobRole());
                    oldExperience.setCompanyName(experience.getCompanyName());
                    return experienceRepository.save(oldExperience);
                })
                .orElseGet(() -> {
                    experience.setId(id);
                    return experienceRepository.save(experience);
                });
    }


    @DeleteMapping("/{id}")
    public void deleteJobType(@PathVariable Long id) {
        experienceRepository.deleteById(id);
    }
}
