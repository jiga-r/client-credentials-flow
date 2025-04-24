package org.example.config;

import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.client.ReactiveOAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.web.reactive.function.client.ServerOAuth2AuthorizedClientExchangeFilterFunction;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.concurrent.ConcurrentHashMap;

@RequiredArgsConstructor
public class WebClientFactory {

    private final ReactiveOAuth2AuthorizedClientManager manager;
    private final ConcurrentHashMap<String, WebClient> cache = new ConcurrentHashMap<>();

    public WebClient getWebClient(String clientRegistrationId) {
        return cache.computeIfAbsent(clientRegistrationId, id -> {
            var oauth = new ServerOAuth2AuthorizedClientExchangeFilterFunction(manager);
            oauth.setDefaultClientRegistrationId(id);

            return WebClient.builder()
                    .filter(oauth)
                    .build();
        });
    }
}