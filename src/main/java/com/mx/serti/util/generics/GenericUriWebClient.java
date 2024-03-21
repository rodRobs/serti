package com.mx.serti.util.generics;

import com.mx.serti.config.WebClientConnectionConfiguration;
import com.mx.serti.pokeapi.dto.PokemonDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import com.mx.serti.uris.dto.UriDTO;

@Component
@Slf4j
public class GenericUriWebClient {

    @Value("${microservice.uris.uri}")
    private String pathUri;

    private final WebClient.Builder webClientBuilder;

    public GenericUriWebClient(WebClient.Builder webClientBuilder) {
        this.webClientBuilder = webClientBuilder;
    }

    public UriDTO getUriById(int id) {
        log.debug("GenericUriWebClient::getUriById {}", id);
        WebClientConnectionConfiguration webClientConnectionConfiguration = new WebClientConnectionConfiguration(webClientBuilder);
        WebClient webClient = webClientConnectionConfiguration.getWebClientConnection(pathUri);
        return webClient.method(HttpMethod.GET).uri("/{id}", id)
                .retrieve().bodyToMono(UriDTO.class).block();
    }

}
