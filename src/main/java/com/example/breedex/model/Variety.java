package com.example.breedex.model;

import jakarta.persistence.*;

@Entity
public class Variety {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String varietyName;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "breed_id", referencedColumnName = "id")
    private Breed breed;

    public Variety(Long id, String varietyName) {
        this.id = id;
        this.varietyName = varietyName;
    }

    public Variety() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVarietyName() {
        return varietyName;
    }

    public void setVarietyName(String varietyName) {
        this.varietyName = varietyName;
    }

    public Breed getBreed() {
        return breed;
    }

    public void setBreed(Breed breed) {
        this.breed = breed;
    }

    @Override
    public String toString() {
        return "Variety{" +
                "id=" + id +
                ", varietyName='" + varietyName + '\'' +
                ", breed=" + breed +
                '}';
    }

}
