package com.example.breedex.model;

import jakarta.persistence.*;

@Entity
@Table(name = "VARIETY")
public class Variety {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "variety_name")
    private String varietyName;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "breed_id", referencedColumnName = "id")
    private Breed breed;

    public Variety(Long id, String varietyName, Breed breed) {
        this.id = id;
        this.varietyName = varietyName;
        this.breed = breed;
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
