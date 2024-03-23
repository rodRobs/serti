package com.mx.serti.util.documentation;

public class DataGenericDocumentation {

    private DataGenericDocumentation() {
        throw new IllegalStateException("Utility class");
    }

    public static final String DATA_GENERIC_DTO = "DataGeneric";
    public static final String DATA_GENERIC_DTO_DESCRIPTION = "Objeto de transferencia de datos para los tipos de datos genericos";

    public static final String DAGE_ID = "dageId";
    public static final String DAGE_ID_EXAMPLE_VALUE = "1";
    public static final String DAGE_ID_DESCRIPTION = "Identificador del registro del dato genérico";

    public static final String NAME = "name";
    public static final String NAME_EXAMPLE_VALUE = "stench";
    public static final String NAME_DESCRIPTION = "Nombre del registro del dato genérico";

    public static final String URL = "url";
    public static final String URL_EXAMPLE_VALUE = "https://pokeapi.co/api/v2/ability/1/";
    public static final String URL_DESCRIPTION = "Url del registro para obtener información mas detallada del dato genérico";
}
