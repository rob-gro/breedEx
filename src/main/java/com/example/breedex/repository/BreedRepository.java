package com.example.breedex.repository;

import com.example.breedex.model.Breed;
import com.example.breedex.model.Variety;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BreedRepository extends JpaRepository<Breed, Long> {


}
