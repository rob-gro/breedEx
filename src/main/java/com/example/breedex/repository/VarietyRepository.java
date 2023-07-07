package com.example.breedex.repository;

import com.example.breedex.model.Variety;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VarietyRepository extends JpaRepository<Variety, Long> {

    List<Variety> findAllByBreedId(Long breedId);
}
