package com.mx.serti.pokemons.dto;

import com.mx.serti.pokemons.entity.Pokemon;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class PokemonDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long pokeId;

    private String pokeName;

    private String pokeColor;

    private String pokeImageUrl;

    public PokemonDTO(Pokemon pokemon) {
        this.setPokeId(pokemon.getPokeId());
        this.setPokeName(pokemon.getPokeName());
        this.setPokeColor(pokemon.getPokeColor());
        this.setPokeImageUrl(pokemon.getPokeImageUrl());
    }

    public PokemonDTO(com.mx.serti.pokeapi.dto.PokemonDTO pokemon) {
        this.setPokeId((long) pokemon.getId());
        this.setPokeName(pokemon.getName());
        this.setPokeColor(pokemon.getSpecie().getColor().getName());
        this.setPokeImageUrl(pokemon.getSprites().getFrontDefault());
    }
}
