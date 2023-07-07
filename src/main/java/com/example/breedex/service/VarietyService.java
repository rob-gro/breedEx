package com.example.breedex.service;

import com.example.breedex.model.Varieties;

import java.util.List;
import java.util.Optional;

public interface VarietiesService {

    /*
  raczej będzie nieużywana
    List<Varieties> getAllVarieties();

   */

    Varieties saveVariety(Varieties variety);

    Optional<Varieties> getVarietyById(Long id);

    void deleteVarietyById(Long id);

    List<Varieties> clientHousesList(Long varietyId);

    void removeVarietyFromBreed(Long id);
}
