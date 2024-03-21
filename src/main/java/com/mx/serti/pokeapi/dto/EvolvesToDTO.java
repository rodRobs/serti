package com.mx.serti.pokeapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class EvolvesToDTO {

    @JsonProperty("evolves_to")
    private List<EvolvesToDTO> evolvesTo;

    @JsonProperty("evolution_details")
    private List<EvolutionDetailsDTO> evolutionDetails;

    @JsonProperty("is_baby")
    private boolean isBaby;

    @JsonProperty("species")
    private ValueDataDTO species;

}
