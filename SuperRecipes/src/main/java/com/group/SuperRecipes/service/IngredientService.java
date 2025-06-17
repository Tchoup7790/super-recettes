package com.group.SuperRecipes.service;

import com.group.SuperRecipes.exception.ApiException;
import com.group.SuperRecipes.model.dao.Ingredient;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;

@Service
public class IngredientService {

    private final WebClient webClient;

    public IngredientService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://localhost:8083/api/v1/ingredients").build();
    }

    public Ingredient findById(String ingredientId) {
        return webClient.get()
                .uri("/{id}", ingredientId)
                .retrieve()
                .bodyToMono(Ingredient.class)
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
