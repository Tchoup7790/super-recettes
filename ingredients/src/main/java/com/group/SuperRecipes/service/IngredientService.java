package com.group.SuperRecipes.service;

import com.group.SuperRecipes.model.dao.Ingredient;
import com.group.SuperRecipes.model.dto.CreateIngredientInput;
import com.group.SuperRecipes.exception.ApiException;
import com.group.SuperRecipes.repository.IngredientRepository;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class IngredientService {
    private IngredientRepository ingredientRepository;


    //find all the recipes that share an ingridient

    public IngredientService(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    public List<Ingredient> getAllIngredient() {
        return ingredientRepository.findAll();
    }

    private final WebClient webClient = WebClient.create();

    public List<Recipe> getAllRecipesByIngredient (String Ingredient) {
        String Url = "http://localhost:8084/api/v1/recipes";

                List<Recipe> recipes = webClient.get()
                .uri(url)
                .retrieve()
                .bodyToFlux(Recipe.class)
                .collectList()
                .block();

        return recipes.stream()
                .filter(recipe -> recipe.getIngredients().stream()
                        .anyMatch(ingredient -> ingredient.getName().equalsIgnoreCase(Ingredient)))
                .toList();

    }
    public Ingredient getIngredientById(String id) {
        return ingredientRepository.findById(id).orElseThrow(() -> new ApiException(
                HttpStatus.NOT_FOUND,
                "Ingredient not found"));
    }

    public Ingredient createIngredient(CreateIngredientInput input) {
        Ingredient newIngredient = Ingredient.builder()
                .name(input.name())
                .build();

        return ingredientRepository.save(newIngredient);
    }

    public Ingredient updateIngredient(String id, CreateIngredientInput input) {
        Ingredient ingredient = ingredientRepository.findById(id).orElseThrow(() -> new ApiException(
                HttpStatus.NOT_FOUND,
                "Ingredient not found"));

        ingredient.setName(input.name());

        return ingredientRepository.save(ingredient);
    }

    public void deleteIngredient(String id) {
        Ingredient category = ingredientRepository.findById(id).orElseThrow(() -> new ApiException(
                HttpStatus.NOT_FOUND,
                "Category not found"));

        ingredientRepository.delete(category);
    }
}
