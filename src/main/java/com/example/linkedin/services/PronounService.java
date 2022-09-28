package com.example.linkedin.services;

import com.example.linkedin.entities.Pronoun;
import com.example.linkedin.repositories.PronounRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PronounService {
    final PronounRepository pronounRepository;

    public PronounService(PronounRepository pronounRepository) {
        this.pronounRepository = pronounRepository;
    }

    public List<Pronoun> get() {
        return pronounRepository.findAll();
    }

}
