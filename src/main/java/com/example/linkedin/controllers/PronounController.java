package com.example.linkedin.controllers;

import com.example.linkedin.model.Pronoun;
import com.example.linkedin.repositories.PronounRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("pronouns")
public class PronounController {
    final PronounRepository pronounRepository;

    public PronounController(PronounRepository pronounRepository) {
        this.pronounRepository = pronounRepository;
    }

    @GetMapping
    List<Pronoun> get(){
        return pronounRepository.findAll();
    }

}
