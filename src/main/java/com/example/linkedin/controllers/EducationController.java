package com.example.linkedin.controllers;

import com.example.linkedin.entities.Education;
import com.example.linkedin.repositories.EducationRepository;
import com.example.linkedin.services.EducationService;
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
@RequestMapping("/api/education")
public class EducationController {
    @Autowired
    private EducationService educationService;

    @GetMapping
    public List<Education> showEducation() {
        return educationService.showEducation();
    }

    @GetMapping("/profile/{profileId}")
    public List<Education> getByProfile(@PathVariable Long profileId){
        return educationService.getByProfile(profileId);
    }

    @GetMapping(value = "/{id}")
    public Education get(@PathVariable Long id) {
        return educationService.get(id);
    }

    @PostMapping
    public Education createEducation(@RequestBody Education jobType) {
        return educationService.createEducation(jobType);
    }

    @PutMapping("/{id}")
    public Education updateJobType(@PathVariable Long id, @RequestBody Education education) {
        return educationService.updateJobType(id,education);
    }


    @DeleteMapping("/{id}")
    public void deleteEducation(@PathVariable Long id) {
        educationService.deleteEducation(id);
    }
}
