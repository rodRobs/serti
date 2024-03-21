package com.mx.serti.exceptions;

public class MethodArgumentNotValidException extends RuntimeException {

    private static final String DESCRIPTION = "Excepción de argumento del método no válido: ";

    public MethodArgumentNotValidException(String detail) {
        super(DESCRIPTION + detail);
    }

}