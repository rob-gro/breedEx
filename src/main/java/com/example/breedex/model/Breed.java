package com.example.breedex.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "BREED")
public class Breed {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "breed_name")
    private String breedName;

    List<String> varieties;

    public Breed(Long id, String breedName, List<String> varieties) {
        this.id = id;
        this.breedName = breedName;
        this.varieties = varieties;
    }

    public Breed(Long id, String breedName) {
        this(id, breedName, new ArrayList<>());
    }

    public Breed() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBreedName() {
        return breedName;
    }

    public void setBreedName(String breedName) {
        this.breedName = breedName;
    }

    public List<String> getVarieties() {
        return varieties;
    }

    public void setVarieties(List<String> varieties) {
        this.varieties = varieties;
    }

    @Override
    public String toString() {
        return "Breed{" +
                "id=" + id +
                ", breedName='" + breedName + '\'' +
                ", varieties=" + varieties +
                '}';
    }
}