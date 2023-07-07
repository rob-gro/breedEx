package com.example.breedex.controller;

import com.example.breedex.model.Breed;
import com.example.breedex.service.BreedService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/breeds")
public class BreedController {

    private final BreedService breedService;

    public BreedController(BreedService breedService) {
        this.breedService = breedService;
    }

    @GetMapping("/list")
    public Iterable<Breed> getAllBreeds() {
        return breedService.getAllBreeds();
    }

    @GetMapping("/all")
    public String findAll() {
        return breedService.findAll().toString();
    }
}


