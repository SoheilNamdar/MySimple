package com.mkyong.Entity;

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
    @Column(name = "weight", unique = true)
    private float weight;

    // avoid this "No default constructor for entity"
    public Item() {
    }

    public Item(Long id, String description, float weight) {
        this.id = id;
        this.description = description;
        this.weight = weight;
    }

    public Item(String description, float weight) {
        this.description = description;
        this.weight = weight;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public float getweight() {
        return weight;
    }

    public void setweight(float weight) {
        this.weight = weight;
    }


}
