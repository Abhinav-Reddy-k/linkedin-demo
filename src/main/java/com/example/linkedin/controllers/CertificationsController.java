package com.example.linkedin.controllers;

import com.example.linkedin.entities.Certifications;
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
    public List<Certifications> showAllCertifications() {
        return certificationsService.showAllCertifications();
    }

    @GetMapping("/profile/{profileId}")
    public List<Certifications> getByProfile(@PathVariable Long profileId) {
        return certificationsService.getByProfile(profileId);
    }

    @PutMapping("/{id}")
    public Certifications updateJobType(@PathVariable Long id, @RequestBody Certifications certifications) {
        return certificationsService.updateJobType(id, certifications);
    }

    @DeleteMapping("/{id}")
    public void deleteCertification(@PathVariable Long id) {
        certificationsService.deleteCertification(id);
    }

    @PostMapping
    public Certifications createCertification(@RequestBody Certifications jobType) {
        return certificationsService.createCertification(jobType);
    }
}
