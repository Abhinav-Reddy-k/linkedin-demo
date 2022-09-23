package com.example.linkedin.controllers;

import com.example.linkedin.entities.JobTitle;
import com.example.linkedin.services.JobTitlesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/jobtitles")
public class JobTitlesController {
    @Autowired
    private JobTitlesService jobTitlesService;

    @GetMapping
    private List<JobTitle> get(){
        return jobTitlesService.get();
    }


}
