package com.example.linkedin.repositories;

import com.example.linkedin.entities.JobType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobTypeRepository extends JpaRepository<JobType,Long> {
}
