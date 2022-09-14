package com.example.linkedin.controllers;

import com.example.linkedin.model.Address;
import com.example.linkedin.model.Certifications;
import com.example.linkedin.repositories.CertificationsRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/certifications")
public class CertificationsController {
    final CertificationsRepository certificationsRepository;

    public CertificationsController(CertificationsRepository certificationsRepository) {
        this.certificationsRepository = certificationsRepository;
    }
    @GetMapping
    public List<Certifications> showAllCertifications() {
        return certificationsRepository.findAll();
    }

    @GetMapping("/profile/{profileId}")
    public List<Certifications> getByProfile(@PathVariable Long profileId){
        return certificationsRepository.findByProfileId(profileId);
    }
    @DeleteMapping("/{id}")
    public void deleteCertification(@PathVariable Long id) {
        certificationsRepository.deleteById(id);
    }
    @PostMapping
    public Certifications createCertification(@RequestBody Certifications jobType) {
        return certificationsRepository.save(jobType);
    }
}
