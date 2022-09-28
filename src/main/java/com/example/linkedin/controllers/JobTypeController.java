package com.example.linkedin.controllers;

import com.example.linkedin.entities.JobType;
import com.example.linkedin.services.JobTypeService;
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
@RequestMapping("/api/jobtypes")
public class JobTypeController {

    @Autowired
    private JobTypeService jobTypeService;

    @GetMapping
    public List<JobType> getAllJobTypes() {
        return jobTypeService.showJobTypes();
    }


    @GetMapping(value = "/{id}")
    public JobType getJobTypeByProfileId(@PathVariable Long id) {
        return jobTypeService.get(id);
    }

    @PostMapping
    public JobType createJobType(@RequestBody JobType jobType) {
        return jobTypeService.createJobType(jobType);
    }

    @PutMapping("/{id}")
    public JobType updateJobType(@PathVariable Long id, @RequestBody JobType jobType) {
        return jobTypeService.updateJobType(id, jobType);
    }


    @DeleteMapping("/{id}")
    public void deleteJobType(@PathVariable Long id) {
        jobTypeService.deleteJobType(id);
    }

}
