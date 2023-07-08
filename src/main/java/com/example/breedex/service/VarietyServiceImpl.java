package com.example.breedex.service;

import com.example.breedex.model.Breed;
import com.example.breedex.model.Variety;
import com.example.breedex.repository.VarietyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class VarietyServiceImpl implements VarietyService {

    private final VarietyRepository varietyRepository;

    public VarietyServiceImpl(VarietyRepository varietyRepository) {
        this.varietyRepository = varietyRepository;
    }

    @Override
    public List<Variety> getAllVarieties() {
        return varietyRepository.findAll();
    }

    @Override
    public List<Variety> breedVarietiesList(Long breedId) {
        return varietyRepository.findAllByBreedId(breedId);
    }

    @Override
    public Variety getVarietyById(Long id) {
        Optional<Variety> varietiesOptional = varietyRepository.findById(id);
        return varietiesOptional.orElseThrow(()-> new NoSuchElementException("Variety not found with ID: " + id));
    }


    @Override
    public Variety saveVariety(Variety variety) {
        return varietyRepository.save(variety);
    }


    @Override
    public void deleteVarietyById(Long id) {

        Variety variety = getVarietyById(id);

        if (variety != null) {
            List<Breed> breedVariety = (List<Breed>) getVarietyById(id);
            if (breedVariety != null) {
                for (Breed breed : breedVariety) {
                    breed.setVariety(null);
                }
            }
            varietyRepository.delete(variety);
        }
    }



    @Override
    public void removeVarietyFromBreed(Long id) {
        Variety variety = getVarietyById(id);
        if (variety != null) {
            variety.setBreed(null);
            varietyRepository.save(variety);
        }

    }
}
