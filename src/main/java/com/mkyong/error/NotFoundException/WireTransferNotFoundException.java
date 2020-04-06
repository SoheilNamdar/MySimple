package com.mkyong.error.NotFoundException;

public class WireTransferNotFoundException extends RuntimeException {

    public WireTransferNotFoundException(Long id) {
        super("WireTransfer id not found : " + id);
    }

}
