package com.mx.serti.config;

import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.Builder;
import reactor.netty.http.client.HttpClient;

import java.time.Duration;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

import static com.mx.serti.util.constants.HttpClient.*;

public class WebClientConnectionConfiguration {

    private Builder webClientBuilder;

    public WebClientConnectionConfiguration(Builder webClientBuilder) {
        this.webClientBuilder = webClientBuilder;
    }

    private HttpClient httpClient = HttpClient.create()
            .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, HTTP_CLIENT_CONNECTION_MILLIS)
            .responseTimeout(Duration.ofMillis(HTTP_CLIENT_CONNECTION_MILLIS))
            .doOnConnected(conn -> conn
                    .addHandlerLast(
                            new ReadTimeoutHandler(HTTP_CLIENT_CONNECTION_MILLIS, TimeUnit.MILLISECONDS))
                    .addHandlerLast(
                            new WriteTimeoutHandler(HTTP_CLIENT_CONNECTION_MILLIS, TimeUnit.MILLISECONDS)));

    public WebClient getWebClientConnection(String path) {
        return webClientBuilder.clientConnector(new ReactorClientHttpConnector(httpClient)).baseUrl(path)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .defaultUriVariables(Collections.singletonMap("url", path)).codecs(codecs -> codecs
                        .defaultCodecs()
                        .maxInMemorySize(1000000 * 1024)).build();
    }

}
