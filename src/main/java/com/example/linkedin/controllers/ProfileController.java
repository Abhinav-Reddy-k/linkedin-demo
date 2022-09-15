package com.example.linkedin.controllers;

import com.example.linkedin.model.Profile;
import com.example.linkedin.repositories.ProfileRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/profiles")
public class ProfileController {

    final
    ProfileRepository profileRepository;

    public ProfileController(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }
//
    @PostMapping("/auth")
    public ResponseEntity<?> authUser(@RequestBody Map<String, String> creds) {
        Profile p = profileRepository.findProfileByEmailAndPassword(creds.get("email"), creds.get("password"));
        if(p==null){
            return new ResponseEntity<>("No user found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(p, HttpStatus.ACCEPTED);
    }

    @GetMapping
    public List<Profile> showProfiles() {
        return profileRepository.findAll();
    }

    @GetMapping(value = "/{id}")
    public Profile get(@PathVariable Long id) {
        return profileRepository.findById(id).get();
    }

    @PostMapping
    public Profile createProfile(@RequestBody Profile profile) {
        return profileRepository.save(profile);
    }

    @PutMapping("/{id}")
    public Profile updateProfile(@PathVariable Long id, @RequestBody Profile profile) {
        return profileRepository.findById(id)
                .map(oldProfile -> {
                    oldProfile.setFirstName(profile.getFirstName());
                    oldProfile.setHeadline(profile.getHeadline());
                    oldProfile.setEmail(profile.getEmail());
                    oldProfile.setImageUrl(profile.getImageUrl());
                    oldProfile.setLastName(profile.getLastName());
                    oldProfile.setPhone(profile.getPhone());
                    oldProfile.setPassword(profile.getPassword());
                    return profileRepository.save(oldProfile);
                })
                .orElseGet(() -> {
                    profile.setId(id);
                    return profileRepository.save(profile);
                });
    }

    @DeleteMapping("/{id}")
    public void deleteProfile(@PathVariable Long id) {
        profileRepository.deleteById(id);
    }

    class Creds {
        public String email;
        public String password;
    }
}
