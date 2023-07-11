package com.example.breedex.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name = "BREED")
public class Breed {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "breed_name")
    private String breedName;

    @OneToMany(mappedBy = "breed")
    List<Variety> varieties;

    public Breed(Long id, String breedName, List<Variety> varieties) {
        this.id = id;
        this.breedName = breedName;
        this.varieties = varieties;
    }

    public Breed(Long id, String breedName) {
        this.id = id;
        this.breedName = breedName;
    }

    //    public Breed(Long id, String breedName, List<Variety> varieties) {
//        this.id = id;
//        this.breedName = breedName;
//        this.varieties = new ArrayList<>(varieties);
//
//        for (Variety variety : this.varieties) {
//            variety.setBreed(this);
//        }
//    }

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

    public List<Variety> getVarieties() {
        return varieties;
    }

    public void setVarieties(List<Variety> varieties) {
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
