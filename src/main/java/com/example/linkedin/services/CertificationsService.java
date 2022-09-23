package com.example.linkedin.services;

import com.example.linkedin.entities.Certifications;
import com.example.linkedin.repositories.CertificationsRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class CertificationsService {
    final CertificationsRepository certificationsRepository;

    public CertificationsService(CertificationsRepository certificationsRepository) {
        this.certificationsRepository = certificationsRepository;
    }

    public List<Certifications> showAllCertifications() {
        return certificationsRepository.findAll();
    }

    public List<Certifications> getByProfile(@PathVariable Long profileId) {
        return certificationsRepository.findByProfileId(profileId);
    }

    public Certifications updateJobType(@PathVariable Long id, @RequestBody Certifications certifications) {
        return certificationsRepository.findById(id)
                .map(oldCertification -> {
                    oldCertification.setCredentialId(certifications.getCredentialId());
                    oldCertification.setCredentialUrl(certifications.getCredentialUrl());
                    oldCertification.setName(certifications.getName());
                    oldCertification.setExpirationDate(certifications.getExpirationDate());
                    oldCertification.setIssueDate(certifications.getIssueDate());
                    oldCertification.setIssuingOrganisation(certifications.getIssuingOrganisation());
                    return certificationsRepository.save(oldCertification);
                })
                .orElseGet(() -> certificationsRepository.save(certifications));
    }

    public void deleteCertification(@PathVariable Long id) {
        certificationsRepository.deleteById(id);
    }

    public Certifications createCertification(@RequestBody Certifications jobType) {
        return certificationsRepository.save(jobType);
    }
}
