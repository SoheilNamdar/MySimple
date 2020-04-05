package com.mkyong.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class Customer {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "deliveryAdress", unique = true)
    private String deliveryAdress;
    @Column(name = "contact", unique = true)
    private String contact;
    @Column(name = "active", unique = true)
    private boolean active;


    // avoid this "No default constructor for entity"
    public Customer() {
    }

    public Customer(Long id, String name, String deliveryAdress, String contact,boolean active) {
        this.id = id;
        this.name = name;
        this.deliveryAdress = deliveryAdress;
        this.contact=contact;
        this.active=active;
    }

    public Customer(String name, String deliveryAdress, String contact,boolean active) {
        this.name = name;
        this.deliveryAdress = deliveryAdress;
        this.contact=contact;
        this.active=active;
    }

    public Customer(String name) {
        this.name=name;
    }

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

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getdeliveryAdress() {
        return deliveryAdress;
    }

    public void setdeliveryAdress(String deliveryAdress) {
        this.deliveryAdress = deliveryAdress;
    }


}
