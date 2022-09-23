package com.example.linkedin.repositories;

import com.example.linkedin.entities.Pronoun;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PronounRepository extends JpaRepository<Pronoun,Long> {
}
