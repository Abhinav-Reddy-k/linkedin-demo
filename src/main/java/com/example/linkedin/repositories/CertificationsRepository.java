package com.example.linkedin.repositories;

import com.example.linkedin.entities.Certifications;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CertificationsRepository extends JpaRepository<Certifications,Long> {
    List<Certifications> findByProfileId(Long profileId);
}
