package com.example.linkedin.repositories;

import com.example.linkedin.entities.JobTitle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobTitleRepository extends JpaRepository<JobTitle,Long> {
}
