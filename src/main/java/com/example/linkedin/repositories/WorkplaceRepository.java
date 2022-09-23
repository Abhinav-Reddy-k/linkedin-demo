package com.example.linkedin.repositories;

import com.example.linkedin.entities.Workplace;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkplaceRepository extends JpaRepository<Workplace,Long> {
}
