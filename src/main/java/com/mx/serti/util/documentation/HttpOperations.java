package com.mx.serti.util.documentation;

public class HttpOperations {

    private HttpOperations() {
        throw new IllegalStateException("Utility class");
    }

    public static final String HTTP_FIND_ALL_OPERATION = "Listar todos los registros";
    public static final String HTTP_FIND_BY_ID_OPERATION = "Buscar registro por id";
    public static final String HTTP_SAVE_OPERATION = "Guardar registro";
    public static final String HTTP_FIND_EVOLUTION_CHAIN_OF_POKEMON = "Buscar la cadena de evolución del pokemon";

    public static final String HTTP_CODE_OK = "200";
    public static final String HTTP_CODE_NOT_FOUND = "404";
    public static final String HTTP_CODE_ERROR_INTERNAL_SERVER = "500";

    public static final String HTTP_DESCRIPTION_OK = "Ok";
    public static final String HTTP_DESCRIPTION_NOT_FOUND = "Not Found";
    public static final String HTTP_DESCRIPTION_ERROR_INTERNAL_SERVER = "Error Internal Server";

}
