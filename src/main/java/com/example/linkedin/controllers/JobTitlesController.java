package com.example.linkedin.controllers;

import com.example.linkedin.model.JobTitle;
import com.example.linkedin.repositories.JobTitleRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/jobtitles")
public class JobTitlesController {
    final JobTitleRepository jobTitleRepository;

    public JobTitlesController( JobTitleRepository jobTitleRepository) {
        this.jobTitleRepository = jobTitleRepository;
    }

    @GetMapping
    private List<JobTitle> get(){
        return jobTitleRepository.findAll();
    }


}
