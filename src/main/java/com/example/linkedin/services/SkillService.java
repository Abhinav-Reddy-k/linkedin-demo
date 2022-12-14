package com.example.linkedin.services;

import com.example.linkedin.entities.Skill;
import com.example.linkedin.repositories.SkillRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class SkillService {

    final SkillRepository skillRepository;

    public SkillService(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }

    public List<Skill> getAllSkill() {
        return skillRepository.findAll();
    }


    public void deleteSkillById(@PathVariable Long id) {
        skillRepository.deleteById(id);
    }

    public Skill createSkill(@RequestBody Skill skill) {
        return skillRepository.save(skill);
    }
}
