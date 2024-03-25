package com.mx.serti.pokeapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
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
