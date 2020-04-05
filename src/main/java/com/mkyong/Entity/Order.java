package com.mkyong.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Order {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;
    @Column(name = "date")
    private Date date;
    @Column(name = "status")
    private OrderStatus status;

    // avoid this "No default constructor for entity"
    public Order() {
    }

    public Order(Long id, Date date, OrderStatus status ) {
        this.id = id;
        this.date = date;
        this.status = status;
    }

    public Order(Date date, OrderStatus status ) {
        this.date = date;
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}
