package com.mkyong.dto;

public class ItemDTO {

    private Long id;
    private String description;
    private float weight;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public float getWeight() { return weight; }

    public void setWeight(float weight) { this.weight = weight; }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
