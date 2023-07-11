package com.example.breedex.service;

import com.example.breedex.model.Breed;
import com.example.breedex.model.Variety;
import com.example.breedex.repository.BreedRepository;
import com.example.breedex.repository.VarietyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class VarietyServiceImpl implements VarietyService {

    private final VarietyRepository varietyRepository;
    private final BreedRepository breedRepository;


    public VarietyServiceImpl(VarietyRepository varietyRepository, BreedRepository breedRepository) {
        this.varietyRepository = varietyRepository;
        this.breedRepository = breedRepository;
    }

    @Override
    public List<Variety> getAllVarieties() {
        return varietyRepository.findAll();
    }

    @Override
    public List<Variety> getVarietiesByBreedId(Long breedId) {
        return varietyRepository.findAllByBreedId(breedId);
    }
    //        query did not return a unique result: 2

    @Override
    public Variety getVarietyById(Long id) {
        Optional<Variety> varietiesOptional = varietyRepository.findById(id);
        return varietiesOptional.orElseThrow(()-> new NoSuchElementException("Niestety nie mogę znaleźć Variety z ID: " + id));
    }

 // new NoSuchElementException("Variety not found with ID: " + id));
    @Override
    public Variety saveVariety(Variety variety) {
        return varietyRepository.save(variety);
    }


    @Override
    public void deleteVarietyById(Long id) {
        Variety variety = getVarietyById(id);
        if (variety != null) {
            Breed breed = variety.getBreed();
            if (breed != null) {
                breed.setVarieties(null);       // to zostawić?
//                breed.getVarieties().remove(variety);  // czy to zostawić?
            }
            varietyRepository.delete(variety);
        }
    }

//    public void addVariety(Variety variety) {
//        variety.setBreed(this);
//        this.varietyRepository.add(variety);
//    }
}
