package com.mx.serti.exceptions;

public class BadRequestException extends RuntimeException {

    private static final String DESCRIPTION = "Error en la ejecución del método: ";

    public BadRequestException(String detail) {
        super(DESCRIPTION + detail);
    }

}
