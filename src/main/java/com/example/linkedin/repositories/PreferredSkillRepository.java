package com.example.linkedin.repositories;

import com.example.linkedin.entities.PreferredSkill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PreferredSkillRepository extends JpaRepository<PreferredSkill,Long> {
    List<PreferredSkill> findPreferredSkillsByProfileId(Long id);

//    PreferredSkill
}
