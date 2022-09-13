package com.example.linkedin.controllers;

import com.example.linkedin.model.JobType;
import com.example.linkedin.repositories.JobTypeRepository;
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
@RequestMapping("/jobtypes")
public class JobTypeController {

    final
    JobTypeRepository jobTypeRepository;

//    @Autowired
//    PreferedJobTypeService preferedJobTypeService;

    public JobTypeController(JobTypeRepository jobTypeRepository) {
        this.jobTypeRepository = jobTypeRepository;
    }

    @GetMapping
    public List<JobType> showJobTypes() {
        return jobTypeRepository.findAll();
    }

    @GetMapping(value = "/{id}")
    public JobType get(@PathVariable Long id) {
        return jobTypeRepository.findById(id).get();
    }

    @PostMapping
    public JobType createJobType(@RequestBody JobType jobType) {
        return jobTypeRepository.save(jobType);
    }

    @PutMapping("/{id}")
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


    @DeleteMapping("/{id}")
    public void deleteJobType(@PathVariable Long id) {
        jobTypeRepository.deleteById(id);
    }

//    @PutMapping("/{jobId}/profiles/{profileId}")
//    public JobType addProfileToJobType(@PathVariable Integer jobId, @PathVariable Integer profileId) {
//        JobType jt = preferedJobTypeService.addPreferedJobType(profileId, jobId);
//        return jobTypeRepository.save(jt);
//    }

}
