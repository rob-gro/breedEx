package com.example.breedex.service;

import com.example.breedex.model.Variety;

import java.util.List;

public interface VarietyService {

    List<Variety> getAllVarieties();

    Variety getVarietyById(Long id);

    List<Variety> getVarietiesByBreedId(Long breedId);

    Variety saveVariety(Variety variety);

    void deleteVarietyById(Long id);
}
