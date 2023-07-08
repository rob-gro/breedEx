package com.example.breedex.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Breed {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String breedName;

    @OneToMany(mappedBy = "breed")
    List<Variety> variety;

    public Breed(Long id, String breedName) {
        this.id = id;
        this.breedName = breedName;
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

    public List<Variety> getVariety() {
        return variety;
    }

    public void setVariety(List<Variety> variety) {
        this.variety = variety;
    }

    @Override
    public String toString() {
        return "Breed{" +
                "id=" + id +
                ", breedName='" + breedName + '\'' +
                '}';
    }

}
