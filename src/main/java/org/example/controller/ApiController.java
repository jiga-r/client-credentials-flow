package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.service.ApiCallerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class ApiController {

    private final ApiCallerService apiCallerService;

    @GetMapping("/proxy/read")
    public Mono<String> proxyRead() {
        return apiCallerService.callReadEndpoint();
    }

    @GetMapping("/proxy/read-write")
    public Mono<String> proxyReadWrite() {
        return apiCallerService.callReadWriteEndpoint();
    }
}