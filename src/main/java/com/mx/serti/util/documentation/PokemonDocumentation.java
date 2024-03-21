package com.mx.serti.util.documentation;

public class PokemonDocumentation {

    private PokemonDocumentation() {
        throw new IllegalStateException("Utility class");
    }

    public static final String POKEMON = "Pokemon";
    public static final String POKEMON_DTO = "Objeto de transferencia de datos de pokemones desde la API";

    public static final String ID = "id";
    public static final String ID_EXAMPLE_VALUE = "1";
    public static final String ID_DESCRIPTION = "Identificador del pokemon";

    public static final String NAME = "name";
    public static final String NAME_EXAMPLE_VALUE = "Bulbasaur";
    public static final String NAME_DESCRIPTION = "Nombre del pokemon";

    public static final String ABILITIES = "abilities";
    public static final String ABILITIES_DESCRIPTION = "Lista de habilidades del pokemon";

    public static final String HEIGTH = "height";
    public static final String HEIGTH_EXAMPLE_VALUE = "7";
    public static final String HEIGTH_DESCRIPTION = "Altura del pokemon";

    public static final String TYPES = "types";
    public static final String TYPES_DESCRIPTION = "Lista del tipo al que pertenece el pokemon";

    public static final String STATS = "stats";
    public static final String STATS_DESCRIPTION = "Lista de las estadisticas que tiene el pokemon";

    public static final String SPRITES = "sprites";
    public static final String SPRITES_EXAMPLE_VALUE = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1.png";
    public static final String SPRITES_DESCRIPTION = "Ruta de la imagen del pokemon";

}
