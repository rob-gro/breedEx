package com.example.breedex.service;

import com.example.breedex.model.Breed;
import com.example.breedex.model.Variety;

import java.util.List;

public interface BreedService {

    List<Breed> getAllBreeds();

//    List<Breed> findAll();

    Breed getBreedById(Long id);

    Breed saveBreed(Breed breed);

    void addVarietyToBreed(Long id, Variety variety);

    void removeVarietyFromBreed(Long breedId, Long varietyId);


//    public Iterable<Breed> save(List<Breed> breeds);

    void deleteBreedById(Long id);
}
