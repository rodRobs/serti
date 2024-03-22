package com.mx.serti.util.constants;

public class ErrorMessages {

    private ErrorMessages() {
        throw new IllegalStateException("Utility class");
    }

    public static final String NOT_FOUND = "No se encontró %s con el id: ";

    public static final String ID_NULL = "El identificador de la entidad a modificar esta vacío";
    public static final String ID_MISSMATCHS = "Los identificadores a modificar no coinciden, %s con %s";

    public static final String VALUES_NULL = "campos obligatorios nulos: \n";

    public static final String IS_REQUIRED = " es requerido";
    public static final String MINUS_OF = " debe ser menor a ";
    public static final String CHARACTERS = " caracteres";

}
