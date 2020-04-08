package com.mkyong.dto;

public class PaymentDTO {

    private Long id;
    private float amount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) { this.amount = amount; }
}
