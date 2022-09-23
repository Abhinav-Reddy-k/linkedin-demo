package com.example.linkedin.repositories;

import com.example.linkedin.entities.Education;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EducationRepository extends JpaRepository<Education,Long> {
    List<Education> findByProfileId(Long profileId);
}
