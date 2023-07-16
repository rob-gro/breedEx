package com.example.breedex.model;

public class Variety {

    private Long breedId;
    private String varietyName;

    public Variety(Long breedId, String varietyName) {
        this.breedId = breedId;
        this.varietyName = varietyName;
    }

    public Variety() {
    }

    public Long getBreedId() {
        return breedId;
    }

    public void setBreedId(Long breedId) {
        this.breedId = breedId;
    }

    public String getVarietyName() {
        return varietyName;
    }

    public void setVarietyName(String varietyName) {
        this.varietyName = varietyName;
    }
}