package com.example.breedex.service;

import com.example.breedex.model.Breed;

import java.util.List;

public interface BreedService {

    Breed createBreed(Long id, String breedName, List<String> varieties);

    Breed addVariety(Long id, String varietyName);

    List<Breed> findAllBreeds();

    Breed findBreedById(Long id);

    void deleteBreedById(Long id);

    void deleteVariety(Long breedId, int index);
}