package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.service.ReadApiService;
import org.example.service.WriteApiService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class ApiController {

    private final ReadApiService readApiService;
    private final WriteApiService writeApiService;

    @GetMapping("/proxy/read")
    public Mono<String> proxyRead() {
        return readApiService.fetchData();
    }

    @GetMapping("/proxy/read-write")
    public Mono<String> proxyReadWrite() {
        return writeApiService.fetchData();
    }
}