package com.mkyong.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Credit extends Payment {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;
    @Column(name = "number", unique = true)
    private String number;
    @Column(name = "type", unique = true)
    private String type;
    @Column(name = "expireDate")
    private Date expireDate;

    // avoid this "No default constructor for entity"
    public Credit() {
    }

    public Credit(Long id, String number, String type, Date expireDate) {
        this.id=id;
        this.number=number;
        this.type=type;
        this.expireDate=expireDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }
}
