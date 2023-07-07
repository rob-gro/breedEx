package com.example.breedex.service;

import com.example.breedex.model.Breed;

import java.util.List;
import java.util.Optional;

public interface BreedService {

    Iterable<Breed> getAllBreeds();

    List<Breed> findAll();

    Optional<Breed> getBreedById(Long id);

    Breed saveBreed(Breed breed);

    public Iterable<Breed> save(List<Breed> breeds);

    void deleteBreedById(Long id);
}
