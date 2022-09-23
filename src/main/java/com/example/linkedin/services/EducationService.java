package com.example.linkedin.services;

import com.example.linkedin.entities.Education;
import com.example.linkedin.repositories.EducationRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class EducationService {
    final EducationRepository educationRepository;

    public EducationService(EducationRepository educationRepository) {
        this.educationRepository = educationRepository;
    }

    public List<Education> showEducation() {
        return educationRepository.findAll();
    }

    public List<Education> getByProfile(@PathVariable Long profileId){
        return educationRepository.findByProfileId(profileId);
    }

    public Education get(@PathVariable Long id) {
        return educationRepository.findById(id).get();
    }

    public Education createEducation(@RequestBody Education jobType) {
        return educationRepository.save(jobType);
    }

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
                .orElseGet(() -> educationRepository.save(education));
    }


    public void deleteEducation(@PathVariable Long id) {
        educationRepository.deleteById(id);
    }
}
