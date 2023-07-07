package com.example.breedex.service;

import com.example.breedex.model.Varieties;
import com.example.breedex.repository.VarietiesRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VarietiesServiceImpl implements VarietiesService{

    private final VarietiesRepository varietiesRepository;

    public VarietiesServiceImpl(VarietiesRepository varietiesRepository) {
        this.varietiesRepository = varietiesRepository;
    }

    @Override
    public Varieties saveVariety(Varieties variety) {
        return varietiesRepository.save(variety);
    }

    @Override
    public Optional<Varieties> getVarietyById(Long id) {
        return varietiesRepository.findById(id);
    }

    @Override
    public void deleteVarietyById(Long id) {
        varietiesRepository.deleteById(id);
    }

    @Override
//    public List<Varieties> clientHousesList(Long clientId) {
    public List<Varieties> breedVarietiesList(Long clientId) {
        return null;
    }

    @Override
    public void removeVarietyFromBreed(Long id) {

    }
}
