package com.mkyong.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Payment {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;
    @Column(name = "amount", unique = true)
    private float amount;

    // avoid this "No default constructor for entity"
    public Payment() {
    }

    public Payment(Long id, String description, float amount) {
        this.id = id;
        this.amount = amount;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public Payment(String description, float amount) {
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
