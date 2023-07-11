package com.example.breedex.service;

import com.example.breedex.model.Breed;
import com.example.breedex.model.Variety;

import java.util.List;

public interface BreedService {

    List<Breed> getAllBreeds();

    Breed getBreedById(Long id);

    Breed saveBreed(Breed breed);

//    void updateBreed(Breed breed);

//    Breed saveBreedAndVariety(Breed breed, Variety variety);

//    void addVarietyToBreed(Long breedId, Variety variety);

    void deleteBreedById(Long id);

//    List<Variety> findByVarietiesOrderById(Long varietyId);
}
