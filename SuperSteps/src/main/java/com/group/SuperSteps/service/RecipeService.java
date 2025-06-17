package com.group.SuperSteps.service;

import com.group.SuperSteps.exception.ApiException;
import com.group.SuperSteps.model.dao.Recipe;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;

@Service
public class RecipeService {

    private final WebClient webClient;

    public RecipeService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://localhost:8084/api/v1/recipes").build();
    }

    public Recipe findById(String stepId) {
        return webClient.get()
                .uri("/{id}", stepId)
                .retrieve()
                .bodyToMono(Recipe.class)
                .switchIfEmpty(Mono.error(new ApiException(
                        HttpStatus.NOT_FOUND,
                        "Recipe not found"
                )))
                .onErrorResume(WebClientResponseException.NotFound.class, ex ->
                        Mono.error(new ApiException(
                                HttpStatus.NOT_FOUND,
                                "Recipe not found"
                        ))
                ).block();
    }
}