package com.example.linkedin.repositories;

import com.example.linkedin.entities.Certification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CertificationsRepository extends JpaRepository<Certification,Long> {
    List<Certification> findByProfileId(Long profileId);
}
