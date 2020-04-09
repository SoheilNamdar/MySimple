package com.mkyong.dto;

import javax.validation.constraints.NotNull;

public class CustomerDTO {

    private Long id;
    @NotNull
    private String name;
    private String deliveryAddress;
    private String contact;
    private boolean active;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDeliveryAddress() { return deliveryAddress; }

    public void setDeliveryAddress(String deliveryAddress) { this.deliveryAddress = deliveryAddress; }

    public String getContact() { return contact; }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
