package com.mx.serti.util.documentation;

public class UriDocumentation {

    private UriDocumentation() {
        throw new IllegalStateException("Utility class");
    }

    public static final String URI = "Uri";
    public static final String URI_DTO = "Objeto de transferencia de datos de las uris para peticiones";

    public static final String URI_ID = "uri_id";
    public static final String URI_ID_EXAMPLE_VALUE = "1";
    public static final String URI_ID_DESCRIPTION = "Identificador del registro de petición";

    public static final String URI_URL = "uri_url";
    public static final String URI_URL_EXAMPLE_VALUE = "pokemon/";
    public static final String URI_URL_DESCRIPTION = "URI de la petición hacia la api de pokeAPI";

    public static final String URI_DESCRIPTION = "uri_description";
    public static final String URI_DESCRIPTION_EXAMPLE_VALUE = "Esta uri realiza petición por id de pokemon para recuperar información del mismo";
    public static final String URI_DESCRIPTION_DESCRIPTION = "Describe que recupera la petición";

}
