package com.mx.serti.util.documentation;

public class ErrorMessageDocumentation {

    private ErrorMessageDocumentation() {
        throw new IllegalStateException("Utility class");
    }

    public static final String ERROR_MESSAGE = "ErrorMessage";
    public static final String ERROR_MESSAGE_DESCRIPTION = "Objeto para presentar mensaje de error";

    public static final String EXCEPTION = "exception";
    public static final String EXCEPTION_EXAMPLE_VALUE = "NotFoundException";
    public static final String EXCEPTION_DESCRIPTION = "Indica el tipo de excepción que ocurrió";

    public static final String MESSAGE = "message";
    public static final String MESSAGE_EXAMPLE_VALUE = "No se encontró Pokemón con el id: 1";
    public static final String MESSAGE_DESCRIPTION = "Describe la excepción que ocurrió";

    public static final String PATH = "path";
    public static final String PATH_EXAMPLE_VALUE = "/pokemons/1";
    public static final String PATH_DESCRIPTION = "Indica el path que se consumió y el que presento la excepción";


}
