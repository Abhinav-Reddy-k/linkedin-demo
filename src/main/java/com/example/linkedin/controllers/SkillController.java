package com.example.linkedin.controllers;

import com.example.linkedin.model.Certifications;
import com.example.linkedin.model.Skill;
import com.example.linkedin.repositories.SkillRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/skill")
public class SkillController {

    final SkillRepository skillRepository;

    public SkillController(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }

    @GetMapping
    List<Skill> get(){
        return skillRepository.findAll();
    }


    @DeleteMapping("/{id}")
    public void deleteSkill(@PathVariable Long id) {
        skillRepository.deleteById(id);
    }
    @PostMapping
    public Skill createCertification(@RequestBody Skill skill) {
        return skillRepository.save(skill);
    }
}
