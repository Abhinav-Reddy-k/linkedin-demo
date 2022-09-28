package com.example.linkedin.services;

import com.example.linkedin.entities.PreferredSkill;
import com.example.linkedin.entities.Profile;
import com.example.linkedin.entities.Skill;
import com.example.linkedin.repositories.PreferredSkillRepository;
import com.example.linkedin.repositories.ProfileRepository;
import com.example.linkedin.repositories.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
@Service
public class PreferredSkillService {
    @Autowired
    private PreferredSkillRepository preferredSkillRepository;
    @Autowired
    private ProfileRepository profileRepository;
    @Autowired
    private SkillRepository skillRepository;

    public List<PreferredSkill> getSkill(@PathVariable Long id) {
        return preferredSkillRepository.findPreferredSkillsByProfileId(id);
    }

    public PreferredSkill addSkill(@PathVariable Long id, @PathVariable Long skillId) {
        Profile p = profileRepository.findById(id).get();
        Skill s = skillRepository.findById(skillId).get();
        PreferredSkill ps = new PreferredSkill();
        ps.setProfile(p);
        ps.setSkill(s);
        return preferredSkillRepository.save(ps);
    }
}
