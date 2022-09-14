package com.example.linkedin.repositories;

import com.example.linkedin.model.Workplace;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkplaceRepository extends JpaRepository<Workplace,Long> {
}
