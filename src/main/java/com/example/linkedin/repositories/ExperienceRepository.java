package com.example.linkedin.repositories;

import com.example.linkedin.entities.Experience;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExperienceRepository extends JpaRepository<Experience,Long> {
    List<Experience> findByProfileId(Long profileId);
}
