package com.mkyong.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class WireTransfer extends Payment {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;
    @Column(name = "bankID", unique = true)
    private String bankID;
    @Column(name = "bankName", unique = true)
    private String bankName;

    // avoid this "No default constructor for entity"
    public WireTransfer() {
    }

    public WireTransfer(Long id, String bankID, String bankName, Date expireDate) {
        this.id=id;
        this.bankID=bankID;
        this.bankName=bankName;
    }

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
