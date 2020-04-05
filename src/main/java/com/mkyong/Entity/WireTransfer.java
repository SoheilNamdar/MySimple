package com.mkyong.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

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

    public String getbankID() {
        return bankID;
    }

    public void setbankID(String bankID) {
        this.bankID = bankID;
    }

    public String getbankName() {
        return bankName;
    }

    public void setbankName(String bankName) {
        this.bankName = bankName;
    }

}
