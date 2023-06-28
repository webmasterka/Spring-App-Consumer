package com.springappconsumer.services;


import com.springappconsumer.Config;
import com.springappconsumer.User;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class WebClientUserService implements UserService{

    private final WebClient webClient = WebClient
            .builder()
            .baseUrl(Config.BASE_URL)
            .build();

    @Override
    public User showUser(Long id) {
        return webClient
                .get()
                .uri("/" + id)
                .retrieve()
                .bodyToMono(User.class)
                .block();
    }

    @Override
    public void addUser(User user) {
        webClient
                .post()
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(Mono.just(user), User.class)
                .retrieve()
                .toBodilessEntity()
                .block();
    }

    @Override
    public void removeUser(Long id) {
        webClient
                .delete()
                .uri("/" + id)
                .retrieve()
                .toBodilessEntity()
                .block();
    }

    @Override
    public List<User> getUsers() {
        return webClient
                .get()
                .retrieve()
                .bodyToFlux(User.class)
                .collectList()
                .block();
    }
}

