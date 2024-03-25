package com.mx.serti.exceptions;

public class UnauthorizedException extends RuntimeException {

    public UnauthorizedException(String detail) {
        super(detail);
    }

}
