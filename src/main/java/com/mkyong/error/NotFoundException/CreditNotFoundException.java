package com.mkyong.error.NotFoundException;

public class CreditNotFoundException extends RuntimeException {

    public CreditNotFoundException(Long id) {
        super("Credit id not found : " + id);
    }

}
