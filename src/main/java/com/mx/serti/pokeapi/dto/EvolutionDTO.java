package com.mx.serti.pokeapi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class EvolutionDTO {

    private int id;

    private EvolvesToDTO chain;

}
