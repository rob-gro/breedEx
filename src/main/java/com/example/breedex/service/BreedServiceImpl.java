package com.example.breedex.service;

import com.example.breedex.model.Breed;
import com.example.breedex.repository.BreedRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BreedServiceImpl implements BreedService {

    private final BreedRepository breedRepository;

    public BreedServiceImpl(BreedRepository breedRepository) {
        this.breedRepository = breedRepository;
    }

    @Override
    public Breed createBreed(String breedName, List<String> varieties) {
        Breed breed = new Breed();
        breed.setBreedName(breedName);
        breed.setVarieties(Optional.ofNullable(varieties).orElse(Collections.emptyList()));
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