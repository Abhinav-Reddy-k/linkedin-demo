package com.example.linkedin.services;

import com.example.linkedin.entities.JobTitle;
import com.example.linkedin.repositories.JobTitleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobTitlesService {
    final JobTitleRepository jobTitleRepository;

    public JobTitlesService( JobTitleRepository jobTitleRepository) {
        this.jobTitleRepository = jobTitleRepository;
    }

    public List<JobTitle> get(){
        return jobTitleRepository.findAll();
    }


}
