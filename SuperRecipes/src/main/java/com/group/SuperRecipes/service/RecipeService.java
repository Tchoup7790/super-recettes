package com.group.SuperRecipes.service;

import com.group.SuperRecipes.exception.ApiException;
import com.group.SuperRecipes.model.dao.Category;
import com.group.SuperRecipes.model.dao.Recipe;
import com.group.SuperRecipes.model.dao.Step;
import com.group.SuperRecipes.model.dao.Ingredient;
import com.group.SuperRecipes.model.dto.CreateRecipeInput;

import com.group.SuperRecipes.repository.RecipeRepository;

import com.group.SuperRecipes.service.IngredientService;
import com.group.SuperRecipes.service.CategoryService;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class RecipeService {
    private final RecipeRepository recipeRepo;
    private final CategoryService categoryService;
    private final IngredientService ingredientService;

    public RecipeService(RecipeRepository recipeRepo, CategoryService categoryService,
                         IngredientService ingredientService) {
        this.recipeRepo = recipeRepo;
        this.categoryService = categoryService;
        this.ingredientService = ingredientService;
    }

    public List<Recipe> findAll() {
        return recipeRepo.findAll();
    }

    public Recipe save(CreateRecipeInput input) {
        Category category = categoryService.findById(input.categoryId());

        Set<Ingredient> ingredients = input.ingredientIds().stream()
                .map(ingredientService::findById)
                .collect(Collectors.toSet());

        Recipe recipe = Recipe.builder()
                .title(input.title())
                .preparationTime(input.preparationTime())
                .category(category)
                .ingredients(ingredients)
                .build();

        List<Step> steps = Optional.ofNullable(input.steps())
                .orElse(List.of())
                .stream()
                .map(dto -> Step.builder()
                        .description(dto.description())
                        .stepOrder(dto.stepOrder())
                        .recipe(recipe)
                        .build())
                .toList();

        recipe.setSteps(steps);

        return recipeRepo.save(recipe);
    }

    public Recipe findById(String id) {
        return recipeRepo.findById(id).orElseThrow(() -> new ApiException(
                HttpStatus.NOT_FOUND,
                "Recipe not found"));
    }

    public Recipe update(String id, CreateRecipeInput input) {
        if (input == null || id == null)
            throw new ApiException(HttpStatus.BAD_REQUEST, "Invalid input");

        Recipe recipe = recipeRepo.findById(id)
                .orElseThrow(() -> new ApiException(HttpStatus.NOT_FOUND, "Recipe not found"));

        if (input.ingredientIds() != null) {
            Set<Ingredient> ingredients = input.ingredientIds().stream()
                    .map(ingredientService::findById)
                    .collect(Collectors.toSet());

            recipe.setIngredients(ingredients);
        }

        if (input.categoryId() != null) {
            Category category = categoryService.findById(input.categoryId());

            recipe.setCategory(category);
        }

        if (input.steps() != null) {
            recipe.getSteps().clear();

            List<Step> steps = input.steps().stream()
                    .map(dto -> Step.builder()
                            .description(dto.description())
                            .stepOrder(dto.stepOrder())
                            .recipe(recipe)
                            .build())
                    .toList();

            recipe.getSteps().addAll(steps);
        }

        if (input.title() != null)
            recipe.setTitle(input.title());
        if (input.preparationTime() != null)
            recipe.setPreparationTime(input.preparationTime());

        return recipeRepo.save(recipe);
    }

    public void delete(String id) {
        Recipe recipe = recipeRepo.findById(id).orElseThrow(() -> new ApiException(
                HttpStatus.NOT_FOUND,
                "Recipe not found"));

        recipeRepo.delete(recipe);
    }
}