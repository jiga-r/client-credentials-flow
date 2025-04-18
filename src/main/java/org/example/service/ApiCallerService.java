package org.example.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class ApiCallerService {

    private final WebClient webClient;

    @Value("${spring.security.oauth2.client.registration.my-client.client-id}")
    private String clientId;

    public ApiCallerService(WebClient webClient) {
        this.webClient = webClient;
    }

    public Mono<String> callReadEndpoint() {
        return webClient.get()
                .uri("http://localhost:8080/api/read-only?clientId=0oa9wx7omgqTan7eh0x7")
                .retrieve()
                .bodyToMono(String.class)
                .doOnNext(response -> log.info("Read: {}", response));
    }

    public Mono<String> callReadWriteEndpoint() {
        return webClient.get()
                .uri("http://localhost:8080/api/read-write?clientId=0oa9wx7omgqTan7eh0x7")
                .retrieve()
                .bodyToMono(String.class)
                .doOnNext(response -> log.info("ReadWrite: {}", response));
    }
}
