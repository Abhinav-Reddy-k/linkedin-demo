package com.example.linkedin.services;

import com.example.linkedin.entities.Workplace;
import com.example.linkedin.repositories.WorkplaceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkplaceService {
    final WorkplaceRepository workplaceRepository;


    public WorkplaceService(WorkplaceRepository workplaceRepository) {
        this.workplaceRepository = workplaceRepository;
    }

    public List<Workplace> get() {
        return workplaceRepository.findAll();
    }
}
