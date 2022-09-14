package com.example.linkedin.controllers;

import com.example.linkedin.model.Education;
import com.example.linkedin.repositories.EducationRepository;
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
@RequestMapping("/education")
public class EducationController {
    final EducationRepository educationRepository;

    public EducationController(EducationRepository educationRepository) {
        this.educationRepository = educationRepository;
    }

    @GetMapping
    public List<Education> showEducation() {
        return educationRepository.findAll();
    }

    @GetMapping("/profile/{profileId}")
    public List<Education> getByProfile(@PathVariable Long profileId){
        return educationRepository.findByProfileId(profileId);
    }

    @GetMapping(value = "/{id}")
    public Education get(@PathVariable Long id) {
        return educationRepository.findById(id).get();
    }

    @PostMapping
    public Education createEducation(@RequestBody Education jobType) {
        return educationRepository.save(jobType);
    }

    @PutMapping("/{id}")
    public Education updateJobType(@PathVariable Long id, @RequestBody Education education) {
        return educationRepository.findById(id)
                .map(oldEducation -> {
                    oldEducation.setDegree(education.getDegree());
                    oldEducation.setDescription(education.getDescription());
                    oldEducation.setEndDate(education.getEndDate());
                    oldEducation.setFieldOfStudy(education.getFieldOfStudy());
                    oldEducation.setGrade(education.getGrade());
                    oldEducation.setSchool(education.getSchool());
                    return educationRepository.save(oldEducation);
                })
                .orElseGet(() -> {
                    education.setId(id);
                    return educationRepository.save(education);
                });
    }


    @DeleteMapping("/{id}")
    public void deleteEducation(@PathVariable Long id) {
        educationRepository.deleteById(id);
    }
}
