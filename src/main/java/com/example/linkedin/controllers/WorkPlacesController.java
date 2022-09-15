package com.example.linkedin.controllers;

import com.example.linkedin.model.Workplace;
import com.example.linkedin.repositories.WorkplaceRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/workplaces")
public class WorkPlacesController {
    final WorkplaceRepository workplaceRepository;


    public WorkPlacesController(WorkplaceRepository workplaceRepository) {
        this.workplaceRepository = workplaceRepository;
    }

    @GetMapping
    public List<Workplace> get(){
        return workplaceRepository.findAll();
    }
}
