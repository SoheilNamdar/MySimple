package com.mkyong.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class OrderDetail {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private int name;
    @Column(name = "taxStatus", unique = true)
    private String taxStatus;

    // avoid this "No default constructor for entity"
    public OrderDetail() {
    }

    public OrderDetail(Long id, int name, String taxStatus) {
        this.id = id;
        this.name = name;
        this.taxStatus = taxStatus;
    }

    public OrderDetail(int name, String taxStatus) {
        this.name = name;
        this.taxStatus = taxStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public String gettaxStatus() {
        return taxStatus;
    }

    public void settaxStatus(String taxStatus) {
        this.taxStatus = taxStatus;
    }

}
