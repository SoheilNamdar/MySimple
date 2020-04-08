package com.mkyong.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class WireTransfer {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;
    @Column(name = "bankID", unique = true)
    private String bankID;
    @Column(name = "bank_name", unique = true)
    private String bankName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBankID() {
        return bankID;
    }

    public void setBankID(String bankID) {
        this.bankID = bankID;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

}
