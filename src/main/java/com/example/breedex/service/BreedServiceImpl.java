package com.example.breedex.service;

import com.example.breedex.model.Breed;
import com.example.breedex.repository.BreedRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class BreedServiceImpl implements BreedService {

    private final BreedRepository breedRepository;

    public BreedServiceImpl(BreedRepository breedRepository) {
        this.breedRepository = breedRepository;
    }

    @Override
    public Breed createBreed(Long id, String breedName, List<String> varieties) {
        Breed breed;
        Optional<Breed> existingBreed = breedRepository.findById(id);
        if (existingBreed.isPresent()) {
            breed = existingBreed.get();
            breed.setBreedName(breedName);
        } else {
            if (varieties == null) {
                varieties = new ArrayList<>();
            }
            breed = new Breed(id, breedName, varieties);
        }
        return breedRepository.save(breed);
    }

    @Override
    public Breed addVariety(Long id, String varietyName) {
        Breed breed = breedRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(" ***** Breed not found: " + id));
        List<String> varieties = breed.getVarieties();
        if (varieties == null) {
            varieties = new ArrayList<>();
        }
        varieties.add(varietyName);
        breed.setVarieties(varieties);
        return breedRepository.save(breed);
    }

    @Override
    public List<Breed> findAllBreeds() {
        return breedRepository.findAll();
    }

    @Override
    public Breed findBreedById(Long id) {
        Optional<Breed> breedOptional = Optional.of(breedRepository.findById(id).get());
        return breedOptional.orElseThrow(() -> new NoSuchElementException("Oops, There is no breed :("));
    }

    @Override
    public void deleteBreedById(Long id) {
        breedRepository.deleteById(id);
    }

    @Override
    public void deleteVariety(Long breedId, int index) {
        Breed breed = breedRepository.findById(breedId)
                .orElseThrow(() -> new IllegalArgumentException("Breed not found: " + breedId));

        List<String> varieties = breed.getVarieties();

        if (index >= 0 && index < varieties.size()) {
            varieties.remove(index);
            breed.setVarieties(varieties);
            breedRepository.save(breed);
        } else {
            throw new IllegalArgumentException("Invalid index for variety: " + index);
        }
    }
}