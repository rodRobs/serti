package com.mx.serti.pokeapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class SpecieDTO {

    private int id;

    private String name;

    @JsonProperty("pal_park_encounters")
    private List<PalParkDTO> palParkEncounters;

    private ValueDataDTO color;

    @JsonProperty("egg_groups")
    private List<ValueDataDTO> eggGroups;

    @JsonProperty("evolution_chain")
    private ValueDataDTO evolutionChain;

    private ValueDataDTO habitat;

    private ValueDataDTO shape;

    private EvolutionDTO evolution;

}
