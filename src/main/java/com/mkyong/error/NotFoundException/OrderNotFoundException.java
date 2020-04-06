package com.mkyong.error.NotFoundException;

public class OrderNotFoundException extends RuntimeException {

    public OrderNotFoundException(Long id) {
        super("Order id not found : " + id);
    }

}
