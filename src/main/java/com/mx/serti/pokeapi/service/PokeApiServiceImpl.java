package com.mx.serti.pokeapi.service;

import com.mx.serti.pokeapi.dto.EvolutionDTO;
import com.mx.serti.pokeapi.dto.PokemonDTO;
import com.mx.serti.pokeapi.dto.SpecieDTO;
import com.mx.serti.pokeapi.enums.UriEnum;
import com.mx.serti.util.generics.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import com.mx.serti.uris.dto.UriDTO;

@Service
@Slf4j
public class PokeApiServiceImpl implements PokeApiService {

    @Autowired
    GenericUriWebClient genericUriWebClient;

    @Autowired
    GenericPokeApiWebClient httpPokeApiWebClient;

    @Override
    public PokemonDTO findPokemonById(int id) {
        log.debug("PokeApiServiceImpl::findPokemonById {}", id);
        int uriId = UriEnum.FIND_BY_ID.getId();
        UriDTO uriDTO = getUriById(uriId);
        ParameterizedTypeReference<PokemonDTO> typeReference = new ParameterizedTypeReference<>() {
        };
        PokemonDTO pokemonDTO = getDataPokemonById(id, uriDTO.getUriUrl(), typeReference);
        SpecieDTO specieDTO = findSpecieByPokemonId(id);
        EvolutionDTO evolutionDTO = findEvolutionChainByUrl(specieDTO.getEvolutionChain().getUrl());
        specieDTO.setEvolution(evolutionDTO);
        pokemonDTO.setSpecie(specieDTO);
        return pokemonDTO;
    }

    public UriDTO getUriById(int id) {
        return genericUriWebClient.getUriById(id);
    }

    public <T> T getDataPokemonById(int id, String uri, ParameterizedTypeReference<T> typeReference) {
        return httpPokeApiWebClient.getDataPokemonById(id, uri, typeReference);
    }

    @Override
    public SpecieDTO findSpecieByPokemonId(int id) {
        log.debug("PokeApiServiceImpl::findSpecieByPokemonId {}", id);
        int uriId = UriEnum.FIND_SPECIE.getId();
        UriDTO uriDTO = getUriById(uriId);
        ParameterizedTypeReference<SpecieDTO> typeReference = new ParameterizedTypeReference<>() {
        };
        return getDataPokemonById(id, uriDTO.getUriUrl(), typeReference);
    }

    @Override
    public EvolutionDTO findEvolutionChainByUrl(String url) {
        log.debug("PokeApiServiceImpl::findEvolutionChainByUrl {}", url);
        ParameterizedTypeReference<EvolutionDTO> typeReference = new ParameterizedTypeReference<>() {
        };
        return getDataPokemonByUrl(url, typeReference);
    }

    public <T> T getDataPokemonByUrl(String path, ParameterizedTypeReference<T> typeReference) {
        return httpPokeApiWebClient.getObject(typeReference, path);
    }


}
