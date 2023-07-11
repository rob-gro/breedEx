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
public class BreedServiceImpl implements BreedService {

    private final BreedRepository breedRepository;
    private final VarietyRepository varietyRepository;

    public BreedServiceImpl(BreedRepository breedRepository, VarietyRepository varietyRepository) {
        this.breedRepository = breedRepository;
        this.varietyRepository = varietyRepository;
    }

    @Override
    public List<Breed> getAllBreeds() {
        return breedRepository.findAll();
    }

    @Override
    public Breed getBreedById(Long id) {
        System.out.println("******* odpaliłem getBreedById () ***************");

//        return breedRepository.findById(id).get();

          Optional<Breed> breedOptional = Optional.of(breedRepository.findById(id).get());
        System.out.println(" ***********  jest breed ************** ");
        return breedOptional.orElseThrow(() -> new NoSuchElementException(" ************ nie ma breed ************"));
//        return breedRepository.getReferenceById(id);
    }

//    @Override
//    public List<Variety> breedVarietiesList(Long varietyId) {
//        return breedRepository.finBy
//    }


    @Override
    public Breed saveBreed(Breed breed) {
        return breedRepository.save(breed);
    }

//    @Override
//    public Breed saveBreedAndVariety(Breed breed, Variety variety) {
//        varietyRepository.findByBreedId(breed.getId());
//        breed.setId(breed.getId());
//        varietyRepository.save(variety);
//        return breedRepository.save(breed);
//    }

//    @Override
//    public void addVarietyToBreed(Long id, Variety variety) {
//        Breed breed = breedRepository.findById(id).orElse(null);
//        if (breed != null) {
//            breed.getVarieties().add(variety);
//            breedRepository.save(breed);
//        }
//    }

    @Override
    public void deleteBreedById(Long id) {

        List<Variety> varieties = varietyRepository.findAllByBreedId(id);
        if (varieties != null) {
            for (Variety variety : varieties) {
                variety.setBreed(null);
                varietyRepository.save(variety);
            }
        }
        breedRepository.deleteById(id);
    }

//        Breed breed = getBreedById(id);
//        if (breed != null) {
//            List<Variety> varietiesList = breed.getVarieties();
//            if (varietiesList != null) {
//                for (Variety variety : varietiesList) {
//                    variety.setBreed(null);
//                }
//            }
//            breedRepository.delete(breed);
//        }

}

