package com.example.linkedin.controllers;

import com.example.linkedin.entities.Skill;
import com.example.linkedin.services.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private SkillService skillService;

    @GetMapping
    List<Skill> get() {
        return skillService.getAllSkill();
    }


    @DeleteMapping("/{id}")
    public void deleteSkill(@PathVariable Long id) {
        skillService.deleteSkillById(id);
    }

    @PostMapping
    public Skill createCertification(@RequestBody Skill skill) {
        return skillService.createSkill(skill);
    }
}
