package com.mkyong.error.Book;

import java.util.Set;

public class UnSupportedFieldPatchException extends RuntimeException {

    public UnSupportedFieldPatchException(Set<String> keys) {
        super("Field " + keys.toString() + " update is not allow.");
    }

}
