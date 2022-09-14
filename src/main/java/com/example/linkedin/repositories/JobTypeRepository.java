package com.example.linkedin.repositories;

import com.example.linkedin.model.Certifications;
import com.example.linkedin.model.JobType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobTypeRepository extends JpaRepository<JobType,Long> {
}
