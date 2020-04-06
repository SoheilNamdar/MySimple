package com.mkyong.error.NotFoundException;

public class PaymentNotFoundException extends RuntimeException {

    public PaymentNotFoundException(Long id) {
        super("Payment id not found : " + id);
    }

}
