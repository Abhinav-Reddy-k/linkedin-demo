package com.example.linkedin.services;

import com.example.linkedin.entities.Profile;
import com.example.linkedin.repositories.ProfileRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

@Service
public class ProfileService {

    final
    ProfileRepository profileRepository;

    public ProfileService(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    public ResponseEntity<?> authUser(@RequestBody Map<String, String> creds) {
        Profile p = profileRepository.findProfileByEmailAndPassword(creds.get("email"), creds.get("password"));
        if (p == null) {
            return new ResponseEntity<>("No user found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(p, HttpStatus.ACCEPTED);
    }

    public List<Profile> showProfiles() {
        return profileRepository.findAll();
    }

    public Profile get(@PathVariable Long id) {
        return profileRepository.findById(id).get();
    }

    public Profile createProfile(@RequestBody Profile profile) {
        return profileRepository.save(profile);
    }

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

    public void deleteProfile(@PathVariable Long id) {
        profileRepository.deleteById(id);
    }

}
