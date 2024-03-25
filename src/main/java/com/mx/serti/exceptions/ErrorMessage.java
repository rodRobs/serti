package com.mx.serti.exceptions;

import io.swagger.v3.oas.annotations.media.Schema;

import static com.mx.serti.util.documentation.ErrorMessageDocumentation.*;

@Schema(name = ERROR_MESSAGE, description = ERROR_MESSAGE_DESCRIPTION)
public class ErrorMessage {

    @Schema(name = EXCEPTION, example = EXCEPTION_EXAMPLE_VALUE, description = EXCEPTION_DESCRIPTION)
    private String exception;

    @Schema(name = MESSAGE, example = MESSAGE_EXAMPLE_VALUE, description = MESSAGE_DESCRIPTION)
    private String message;

    @Schema(name = PATH, example = PATH_EXAMPLE_VALUE, description = PATH_DESCRIPTION)
    private String path;

    public ErrorMessage(Exception exception, String path) {
        this.exception = exception.getClass().getSimpleName();
        this.message = exception.getMessage();
        this.path = path;
    }

    public String getException() {
        return exception;
    }

    public String getMessage() {
        return message;
    }

    public String getPath() {
        return path;
    }

    @Override
    public String toString() {
        return "ErrorMessage{" +
                "exception='" + exception + '\'' +
                ", message='" + message + '\'' +
                ", path='" + path + '\'' +
                '}';
    }
}
