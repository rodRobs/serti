package com.mx.serti.pokemons.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

import com.mx.serti.pokemons.dto.PokemonDTO;

@Entity
@Table(name = "tbl_pokemon")
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Pokemon implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "poke_id")
    private Long pokeId;

    @Column(name = "poke_name", length = 50, unique = true)
    private String pokeName;

    @Column(name = "poke_color", length = 30, unique = true)
    private String pokeColor;

    @Column(name = "poke_image_url", columnDefinition = "LONGTEXT", unique = true)
    private String pokeImageUrl;

    public Pokemon(PokemonDTO pokemon) {
        this.setPokeId(pokemon.getPokeId());
        this.setPokeName(pokemon.getPokeName());
        this.setPokeColor(pokemon.getPokeColor());
        this.setPokeImageUrl(pokemon.getPokeImageUrl());
    }

}
