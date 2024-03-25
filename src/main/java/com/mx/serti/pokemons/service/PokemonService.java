package com.mx.serti.pokemons.service;

import java.util.List;
import com.mx.serti.pokemons.dto.PokemonDTO;

public interface PokemonService {

    List<PokemonDTO> findAll();

    PokemonDTO findById(Long id);

    PokemonDTO save(PokemonDTO pokemonDTO);

    List<PokemonDTO> saveList(List<PokemonDTO> pokemonDTOs);

    PokemonDTO update(Long id, PokemonDTO pokemonDTO);

    void deleteById(Long id);

}
