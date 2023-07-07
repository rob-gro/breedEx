package com.example.breedex.service;

import com.example.breedex.model.Variety;

import java.util.List;

public interface VarietyService {

    /*
  raczej będzie nieużywana
    List<Variety> getAllVarieties();

   */

    Variety saveVariety(Variety variety);

    Variety getVarietyById(Long id);

    void deleteVarietyById(Long id);

    List<Variety> breedVarietiesList(Long varietyId);

    void removeVarietyFromBreed(Long id);
}
