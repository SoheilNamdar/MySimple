package com.mkyong.entity;

import com.mkyong.entity.eEnum.OrderStatus;
import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity
public class Order {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;
    @Column(name = "date")
    private ZonedDateTime date;
    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ZonedDateTime getDate() {
        return date;
    }

    public void setDate(ZonedDateTime date) {
        this.date = date;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}
