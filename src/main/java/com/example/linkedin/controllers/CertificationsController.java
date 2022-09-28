package com.example.linkedin.controllers;

import com.example.linkedin.entities.Certification;
import com.example.linkedin.services.CertificationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/certifications")
public class CertificationsController {
    @Autowired
    private CertificationsService certificationsService;

    @GetMapping
    public List<Certification> showAllCertifications() {
        return certificationsService.showAllCertifications();
    }

    @GetMapping("/profile/{profileId}")
    public List<Certification> getCertificationsByProfile(@PathVariable Long profileId) {
        return certificationsService.getByProfile(profileId);
    }

    @PutMapping("/{id}")
    public Certification updateCertificationsById(@PathVariable Long id, @RequestBody Certification certification) {
        return certificationsService.updateCertification(id, certification);
    }

    @DeleteMapping("/{id}")
    public void deleteCertificationById(@PathVariable Long id) {
        certificationsService.deleteCertification(id);
    }

    @PostMapping
    public Certification createCertification(@RequestBody Certification jobType) {
        return certificationsService.createCertification(jobType);
    }
}
