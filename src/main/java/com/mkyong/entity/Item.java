package com.mkyong.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Item {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;
    @Column(name = "description")
    private String description;
    @Column(name = "weight")
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
