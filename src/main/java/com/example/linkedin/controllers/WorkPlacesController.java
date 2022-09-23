package com.example.linkedin.controllers;

import com.example.linkedin.entities.Workplace;
import com.example.linkedin.services.WorkplaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/workplaces")
public class WorkPlacesController {
    @Autowired
    private WorkplaceService workplaceService;

    @GetMapping
    public List<Workplace> get() {
        return
                workplaceService.get();
    }
}
