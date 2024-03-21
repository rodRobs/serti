package com.mx.serti.exceptions;

public class NotFoundException extends RuntimeException {

    private static final String DESCRIPTION = "No se encontró: ";

    public NotFoundException(String detail) {
        super(DESCRIPTION + ". " + detail);
    }

}
