package com.example.linkedin.controllers;

import com.example.linkedin.entities.PreferredSkill;
import com.example.linkedin.services.PreferredSkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/preferredSkill")
public class PreferredSkillController {
    @Autowired
    private PreferredSkillService preferredSkillService;

    @GetMapping("/profile/{id}")
    public List<PreferredSkill> getSkill(@PathVariable Long id) {
        return preferredSkillService.getSkill(id);
    }

    @PostMapping("/{skillId}/profile/{id}")
    public PreferredSkill addSkill(@PathVariable Long id, @PathVariable Long skillId) {
        return preferredSkillService.addSkill(id, skillId);
    }
}
