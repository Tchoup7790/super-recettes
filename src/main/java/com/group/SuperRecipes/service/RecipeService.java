package com.group.SuperRecipes.service;

import com.group.SuperRecipes.exception.ApiException;
import com.group.SuperRecipes.model.dao.Category;
import com.group.SuperRecipes.model.dao.Recipe;
import com.group.SuperRecipes.model.dto.CreateRecipeInput;
import com.group.SuperRecipes.repository.CategoryRepository;
import com.group.SuperRecipes.repository.RecipeRepository;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class RecipeService {
    private final RecipeRepository recipeRepo;
    private final CategoryRepository categoryRepo;

    public RecipeService(RecipeRepository recipeRepo, CategoryRepository categoryRepo) {
        this.recipeRepo = recipeRepo;
        this.categoryRepo = categoryRepo;
    }

    public List<Recipe> findAll() {
        return recipeRepo.findAll();
    }

    public Recipe save(CreateRecipeInput input) {
        Category category = categoryRepo.findById(input.categoryId())
                .orElseThrow(() -> new ApiException(
                        HttpStatus.NOT_FOUND,
                        "Category not found"));

        Recipe recipe = Recipe.builder()
                .title(input.title())
                .preparationTime(input.preparationTime())
                .category(category)
                .build();

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

        Recipe recipe = recipeRepo.findById(id).orElseThrow(() -> new ApiException(
                HttpStatus.NOT_FOUND,
                "Recipe not found"));

        if (input.categoryId() != null) {
            Category category = categoryRepo.findById(input.categoryId()).orElseThrow(() -> new ApiException(
                    HttpStatus.NOT_FOUND,
                    "Category not found"));

            recipe.setCategory(category);
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
