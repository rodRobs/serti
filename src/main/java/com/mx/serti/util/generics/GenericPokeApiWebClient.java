package com.mx.serti.util.generics;

import com.mx.serti.pokeapi.dto.PokemonDTO;
import lombok.extern.slf4j.Slf4j;
import com.mx.serti.config.WebClientConnectionConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class GenericPokeApiWebClient {

    @Value("${microservice.uris.poke-api}")
    private String pathPokeApi;

    @Autowired
    GenericWebClient genericWebClient;

    private final WebClient.Builder webClientBuilder;

    public GenericPokeApiWebClient(WebClient.Builder webClientBuilder) {
        this.webClientBuilder = webClientBuilder;
    }

    public <T> T getDataPokemonById(int id, String uri, ParameterizedTypeReference<T> typeReference) {
        log.debug("HttpPokeApiWebClient::getDataPokemonById {}, {}, {}", id, uri, typeReference);
        WebClientConnectionConfiguration webClientConnectionConfiguration = new WebClientConnectionConfiguration(webClientBuilder);
        WebClient webClient = webClientConnectionConfiguration.getWebClientConnection(pathPokeApi);
        return webClient.method(HttpMethod.GET).uri(uri + "/{id}", id)
                .retrieve().bodyToMono(typeReference).block();
    }

    public <T> T getObject(ParameterizedTypeReference<T> typeReference, String path) {
        WebClientConnectionConfiguration webClientConnectionConfiguration = new WebClientConnectionConfiguration(webClientBuilder);
        WebClient webClient = webClientConnectionConfiguration.getWebClientConnection(path);
        return webClient.method(HttpMethod.GET).retrieve().bodyToMono(typeReference).block();
    }


}
