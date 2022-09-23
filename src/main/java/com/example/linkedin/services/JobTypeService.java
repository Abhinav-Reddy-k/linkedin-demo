package com.example.linkedin.services;

import com.example.linkedin.entities.JobType;
import com.example.linkedin.repositories.JobTypeRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class JobTypeService {
    final
    JobTypeRepository jobTypeRepository;

    public JobTypeService(JobTypeRepository jobTypeRepository) {
        this.jobTypeRepository = jobTypeRepository;
    }

    public List<JobType> showJobTypes() {
        return jobTypeRepository.findAll();
    }

    public JobType get(@PathVariable Long id) {
        return jobTypeRepository.findById(id).get();
    }

    public JobType createJobType(@RequestBody JobType jobType) {
        return jobTypeRepository.save(jobType);
    }

    public JobType updateJobType(@PathVariable Long id, @RequestBody JobType jobType) {
        return jobTypeRepository.findById(id)
                .map(oldJobTypes -> {
                    oldJobTypes.setName(jobType.getName());
                    return jobTypeRepository.save(oldJobTypes);
                })
                .orElseGet(() -> {
                    jobType.setId(id);
                    return jobTypeRepository.save(jobType);
                });
    }

    public void deleteJobType(@PathVariable Long id) {
        jobTypeRepository.deleteById(id);
    }
}
