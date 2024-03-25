package com.mx.serti.exceptions;

public class NotFoundException extends RuntimeException {
    
    public NotFoundException(String detail) {
        super( detail);
    }

}
