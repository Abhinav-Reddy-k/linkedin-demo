package com.example.linkedin.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class PreferredSkill {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    @JsonIgnore
    @ManyToOne(targetEntity = Profile.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "profileId", referencedColumnName = "id")
    private Profile profile;
    @ManyToOne(targetEntity = Skill.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "skillId", referencedColumnName = "id")
    private Skill skill;


    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}
