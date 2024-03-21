package com.mx.serti.util.documentation;

public class RequestDocumentation {

    private RequestDocumentation() {
        throw new IllegalStateException("Utility class");
    }

    public static final String REQUEST = "Request";
    public static final String REQUEST_DTO = "Objeto de transferencia de datos de peticiones";

    public static final String REQ_ID = "req_id";
    public static final String REQ_ID_EXAMPLE_VALUE = "1";
    public static final String REQ_ID_DESCRIPTION = "Identificador del registro de petición";

    public static final String REQ_URL = "req_url";
    public static final String REQ_URL_EXAMPLE_VALUE = "https://pokeapi.co/api/v2/pokemon-species/";
    public static final String REQ_URL_DESCRIPTION = "URL de la petición hacia la api de pokeAPI";

    public static final String REQ_DESCRIPTION = "req_description";
    public static final String REQ_DESCRIPTION_EXAMPLE_VALUE = "Esta ruta realiza petición por id de pokemon para recuperar información del mismo";
    public static final String REQ_DESCRIPTION_DESCRIPTION = "Describe que recupera la petición";

}
