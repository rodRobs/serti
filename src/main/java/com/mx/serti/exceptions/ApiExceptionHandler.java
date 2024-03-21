package com.mx.serti.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ApiExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({com.mx.serti.exceptions.NotFoundException.class})
    @ResponseBody
    public com.mx.serti.exceptions.ErrorMessage notFoundRequest(HttpServletRequest request, Exception exception) {
        return new com.mx.serti.exceptions.ErrorMessage(exception, request.getRequestURI());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({BadRequestException.class})
    @ResponseBody
    public com.mx.serti.exceptions.ErrorMessage badRequest(HttpServletRequest request, Exception exception) {
        return new com.mx.serti.exceptions.ErrorMessage(exception, request.getRequestURI());
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({Exception.class})
    @ResponseBody
    public com.mx.serti.exceptions.ErrorMessage fatalErrorunexpectedException(HttpServletRequest request, Exception exception) {
        return new com.mx.serti.exceptions.ErrorMessage(exception, request.getRequestURI());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseBody
    public com.mx.serti.exceptions.ErrorMessage methodArgumentNotValidException(HttpServletRequest request, Exception exception) {
        return new com.mx.serti.exceptions.ErrorMessage(exception, request.getRequestURI());
    }

}
