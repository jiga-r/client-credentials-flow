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
public class WriteApiService {

    private final WebClientFactory factory;

    @Value("${destination-apis.write-api.url}")
    private String writeApiUrl;

    @Value("${destination-apis.write-api.client-id}")
    private String writeApiClientId;

    public Mono<String> fetchData() {
        return factory.getWebClient(writeApiClientId)
                .get()
                .uri(writeApiUrl)
                .retrieve()
                .bodyToMono(String.class)
                .doOnNext(resp -> log.info("Write response: {}", resp));
    }
}