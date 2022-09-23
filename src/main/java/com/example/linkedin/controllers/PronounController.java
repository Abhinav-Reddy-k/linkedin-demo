package com.example.linkedin.controllers;

import com.example.linkedin.entities.Pronoun;
import com.example.linkedin.services.PronounService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/pronouns")
public class PronounController {
    @Autowired
    private PronounService pronounService;
    @GetMapping
    List<Pronoun> get(){
        return pronounService.get();
    }

}
