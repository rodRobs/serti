package com.mx.serti.pokeapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import static com.mx.serti.util.documentation.PokemonDocumentation.*;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
@Schema(name = POKEMON, description = POKEMON_DTO)
public class PokemonDTO {

    @Schema(name = ID, example = ID_EXAMPLE_VALUE, description = ID_DESCRIPTION)
    private int id;

    @Schema(name = NAME, example = NAME_EXAMPLE_VALUE, description = NAME_DESCRIPTION)
    private String name;

    @Schema(name = ABILITIES, description = ABILITIES_DESCRIPTION)
    private List<AbilityDTO> abilities;

    @Schema(name = HEIGTH, example = HEIGTH_EXAMPLE_VALUE, description = HEIGTH_DESCRIPTION)
    private int height;

    @Schema(name = TYPES, description = TYPES_DESCRIPTION)
    private List<TypeDTO> types;

    @Schema(name = STATS, description = STATS_DESCRIPTION)
    private List<StatDTO> stats;

    @Schema(name = SPRITES, example = SPRITES_EXAMPLE_VALUE, description = SPRITES_DESCRIPTION)
    private SpriteDTO sprites;

    private SpecieDTO specieDTO;

}
