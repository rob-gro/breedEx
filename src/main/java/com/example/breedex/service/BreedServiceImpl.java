package com.example.breedex.service;

import com.example.breedex.model.Breed;
import com.example.breedex.model.Variety;
import com.example.breedex.repository.BreedRepository;
import com.example.breedex.repository.VarietyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
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

//    @Override
//    public List<Breed> findAll() {
//        return breedRepository.findAll();
//    }

    @Override
    public Breed getBreedById(Long id) {
        return breedRepository.findById(id).orElse(null);
    }

    @Override
    public Breed saveBreed(Breed breed) {
//        Variety <-> String
//        List<String> varietyNames = Arrays.asList(breed.getVarietyName().toString());
//        breed.setVarietyName(varietyNames);
        return breedRepository.save(breed);
    }

    @Override
    public void addVarietyToBreed(Long id, Variety variety) {
        Breed breed = breedRepository.findById(id).orElse(null);
        if (breed != null) {

            breedRepository.save(breed);
        }
    }

    @Override
    public void removeVarietyFromBreed(Long breedId, Long varietyId) {
//        Variety variety = varietyRepository.findAllByBreedId()

//        Optional<Breed> breed = breedRepository.findById(breedId);
//        if (breed != null) {
//            breed.set
//
//        }
//    }


//    public void removeVariety(Variety variety) {
//        varieties.remove(variety);
//        variety.setBreed(null);
//    }


        //    public void setVarietyName(List<Variety> varietyNames) {
//        Breed breed = breedRepository.findById(getBreedById(Long id)).orElse(null);
//        if (breed != null) {
//            breed.setVarietyName(varietyNames);
//            breedRepository.save(breed);
//        }
//    }

//    @Override
//    public Iterable<Breed> save(List<Breed> breeds) {
//        return breedRepository.saveAll(breeds);
//    }

//    @Override
//    public void deleteBreedById(Long id) {
//        Breed breed = getBreedById(id);
//        List<Variety> varieties = varietyRepository.findAllByBreedId(id);
//        if(varieties != null) {
////            for (Breed breed : varieties) {
//                breed.setId(null);
//            }
//        }
//        breedRepository.delete(breed);
//    }
    }

    @Override
    public void deleteBreedById(Long id) {

    }
}
