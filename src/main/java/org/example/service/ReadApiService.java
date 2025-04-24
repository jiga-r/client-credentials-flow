package org.example.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.config.WebClientFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
@Slf4j
public class ReadApiService {

    private final WebClientFactory factory;

    @Value("${destination-apis.read-api.url}")
    private String readApiUrl;

    @Value("${destination-apis.read-api.client-id}")
    private String readApiClientId;

    public Mono<String> fetchData() {
        return factory.getWebClient(readApiClientId)
                .get()
                .uri(readApiUrl)
                .retrieve()
                .bodyToMono(String.class)
                .doOnNext(resp -> log.info("Read response: {}", resp));
    }
}