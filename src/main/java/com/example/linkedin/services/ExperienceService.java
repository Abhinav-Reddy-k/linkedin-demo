package com.example.linkedin.services;

import com.example.linkedin.entities.Experience;
import com.example.linkedin.repositories.ExperienceRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class ExperienceService {


    final
    ExperienceRepository experienceRepository;


    public ExperienceService(ExperienceRepository experienceRepository) {
        this.experienceRepository = experienceRepository;
    }

    public List<Experience> getAllExperience() {
        return experienceRepository.findAll();
    }

    public Experience getExperienceById(@PathVariable Long id) {
        return experienceRepository.findById(id).get();
    }

    public List<Experience> getExperienceByProfile(@PathVariable Long profileId) {
        return experienceRepository.findByProfileId(profileId);
    }

    public Experience createExperience(@RequestBody Experience experience) {
        return experienceRepository.save(experience);
    }

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


    public void deleteExperience(@PathVariable Long id) {
        experienceRepository.deleteById(id);
    }
}
