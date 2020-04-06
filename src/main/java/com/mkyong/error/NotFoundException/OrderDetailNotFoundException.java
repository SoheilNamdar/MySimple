package com.mkyong.error.NotFoundException;

public class OrderDetailNotFoundException extends RuntimeException {

    public OrderDetailNotFoundException(Long id) {
        super("OrderDetail id not found : " + id);
    }

}
