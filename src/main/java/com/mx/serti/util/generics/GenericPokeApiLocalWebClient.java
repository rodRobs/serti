package com.mx.serti.util.generics;

import com.mx.serti.config.WebClientConnectionConfiguration;
import com.mx.serti.pokemons.dto.PokemonDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;

@Component
@Slf4j
public class GenericPokeApiLocalWebClient {

    @Value("${microservice.uris.poke-api-local}")
    private String pathPokeApiLocal;

    @Autowired
    GenericWebClient genericWebClient;

    private final WebClient.Builder webClientBuilder;

    public GenericPokeApiLocalWebClient(WebClient.Builder webClientBuilder) {
        this.webClientBuilder = webClientBuilder;
    }

    public com.mx.serti.pokeapi.dto.PokemonDTO findPokemonById(Long id) {
        log.debug("GenericPokeApiLocalWebClient::findPokemonById {}", id);
        WebClientConnectionConfiguration webClientConnectionConfiguration = new WebClientConnectionConfiguration(webClientBuilder);
        WebClient webClient = webClientConnectionConfiguration.getWebClientConnection(pathPokeApiLocal);
        return webClient.method(HttpMethod.GET).uri( "/{id}", id)
                .retrieve().bodyToMono(com.mx.serti.pokeapi.dto.PokemonDTO.class).block();
    }

    public List<PokemonDTO> saveList(List<PokemonDTO> pokemonDTOList) {
        log.debug("GenericPokeApiLocalWebClient::saveList {}", pokemonDTOList);
        WebClientConnectionConfiguration webClientConnectionConfiguration = new WebClientConnectionConfiguration(webClientBuilder);
        WebClient webClient = webClientConnectionConfiguration.getWebClientConnection(pathPokeApiLocal);
        PokemonDTO[] pokemons = webClient.method(HttpMethod.POST).uri( "/list").body(pokemonDTOList, PokemonDTO[].class)
                .retrieve().bodyToMono(PokemonDTO[].class).block();
        return Arrays.stream(pokemons).toList();
    }

}
