package com.mkyong.DTO;

import com.mkyong.Entity.Enum.OrderStatus;
import java.time.ZonedDateTime;

public class OrderDTO {

    private Long id;
    private ZonedDateTime date;
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
