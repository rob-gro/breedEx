package com.example.breedex.model;

import jakarta.persistence.*;

@Entity
public class Varieties {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String varietiesName;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "breed_id", referencedColumnName = "id")
    private Breed breed;

    public Varieties(Long id, String varietiesName, Breed breed) {
        this.id = id;
        this.varietiesName = varietiesName;
        this.breed = breed;
    }

    public Varieties() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVarietiesName() {
        return varietiesName;
    }

    public void setVarietiesName(String varietiesName) {
        this.varietiesName = varietiesName;
    }

    public Breed getBreed() {
        return breed;
    }

    public void setBreed(Breed breed) {
        this.breed = breed;
    }

    @Override
    public String toString() {
        return "Varieties{" +
                "id=" + id +
                ", varietiesName='" + varietiesName + '\'' +
                ", breed=" + breed +
                '}';
    }
}
