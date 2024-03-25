package com.mx.serti.chainevolutions.dto;

import com.mx.serti.chainevolutions.entity.ChainEvolution;
import com.mx.serti.pokemons.dto.PokemonDTO;
import com.mx.serti.pokemons.entity.Pokemon;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class ChainEvolutionDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long chevId;

    private List<PokemonDTO> pokemons;

    private int evoMinLevel;

    private int chevEnvolve;

    public ChainEvolutionDTO(ChainEvolution chainEvolution) {
        this.setChevId(chainEvolution.getChevId());
        this.setPokemons(chainEvolution.getPokemons().stream().map(PokemonDTO::new).toList());
        this.setEvoMinLevel(chainEvolution.getEvoMinLevel());
        this.setChevEnvolve(chainEvolution.getChevEnvolve());
    }

}
