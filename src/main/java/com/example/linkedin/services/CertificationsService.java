package com.example.linkedin.services;

import com.example.linkedin.entities.Certification;
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

    public List<Certification> showAllCertifications() {
        return certificationsRepository.findAll();
    }

    public List<Certification> getByProfile(@PathVariable Long profileId) {
        return certificationsRepository.findByProfileId(profileId);
    }

    public Certification updateCertification(@PathVariable Long id, @RequestBody Certification certification) {
        return certificationsRepository.findById(id)
                .map(oldCertification -> {
                    oldCertification.setCredentialId(certification.getCredentialId());
                    oldCertification.setCredentialUrl(certification.getCredentialUrl());
                    oldCertification.setName(certification.getName());
                    oldCertification.setExpirationDate(certification.getExpirationDate());
                    oldCertification.setIssueDate(certification.getIssueDate());
                    oldCertification.setIssuingOrganisation(certification.getIssuingOrganisation());
                    return certificationsRepository.save(oldCertification);
                })
                .orElseGet(() -> certificationsRepository.save(certification));
    }

    public void deleteCertification(@PathVariable Long id) {
        certificationsRepository.deleteById(id);
    }

    public Certification createCertification(@RequestBody Certification jobType) {
        return certificationsRepository.save(jobType);
    }
}
