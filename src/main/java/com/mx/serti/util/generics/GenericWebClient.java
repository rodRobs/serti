package com.mx.serti.util.generics;

import com.mx.serti.config.WebClientConnectionConfiguration;
import org.springframework.stereotype.Component;

import java.net.UnknownHostException;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;


@Component
public class GenericWebClient {

    private final WebClient.Builder webClientBuilder;

    public GenericWebClient(WebClient.Builder webClientBuilder) {
        this.webClientBuilder = webClientBuilder;
    }

    public <T> T getObjectById(ParameterizedTypeReference<T> typeReference, Long id, String path, String uri)
            throws UnknownHostException {
        try {
            WebClientConnectionConfiguration webClientConnectionConfiguration = new WebClientConnectionConfiguration(webClientBuilder);
            WebClient webClient = webClientConnectionConfiguration.getWebClientConnection(path);
            return webClient.method(HttpMethod.GET).uri(uri + "/{id}", id)
                    .retrieve().bodyToMono(typeReference).block();

        } catch (WebClientResponseException e) {
            if (e.getStatusCode() == HttpStatus.NOT_FOUND) {
                return null;
            } else {
                throw new UnknownHostException(path);
            }
        }
    }

}
