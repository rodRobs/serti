package com.mx.serti.pokeapi.service;

import com.mx.serti.pokeapi.dto.*;

public interface PokeApiService {

    PokemonDTO findPokemonById(int id);

    SpecieDTO findSpecieByPokemonId(int id);

    EvolutionDTO findEvolutionChainByUrl(String url);

}
