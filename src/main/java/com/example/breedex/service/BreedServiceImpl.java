package com.example.breedex.service;

import com.example.breedex.model.Breed;
import com.example.breedex.repository.BreedRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BreedServiceImpl implements BreedService{

    private final BreedRepository breedRepository;

    public BreedServiceImpl(BreedRepository breedRepository) {
        this.breedRepository = breedRepository;
    }

    @Override
    public Iterable<Breed> getAllBreeds() {
        return breedRepository.findAll();
    }

    @Override
    public List<Breed> findAll() {
        return breedRepository.findAll();
    }

    @Override
    public Optional<Breed> getBreedById(Long id) {
        return breedRepository.findById(id);
    }

    @Override
    public Breed saveBreed(Breed breed) {
        return breedRepository.save(breed);
    }

    @Override
    public Iterable<Breed> save(List<Breed> breeds) {
        return breedRepository.saveAll(breeds);
    }

    @Override
    public void deleteBreedById(Long id) {
        breedRepository.deleteById(id);
    }
}
