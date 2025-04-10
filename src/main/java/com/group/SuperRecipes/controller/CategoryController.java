package com.group.SuperRecipes.controller;

import com.group.SuperRecipes.model.dao.Ingredient;
import com.group.SuperRecipes.model.dto.IngredientCreateInput;
import com.group.SuperRecipes.service.IngredientService;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {

    private final IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }
    @GetMapping
    public List<Ingredient> getAllIngredients() {
        return categoryIngredient.getAllIngredients();
    }

    @GetMapping("/{id}")
    public Ingredient getIngredientById(@PathVariable String id) {
        return ingredientService.getIngredientById(id);
    }

    @PostMapping
    public Ingredient createIngredient(@RequestBody IngredientCreateInput input) {
        return ingredientService.createIngredient(input);
    }

    @PutMapping("/{id}")
    public Ingredient updateIngredient(@PathVariable String id, @RequestBody IngredientCreateInput input) {
        return ingredientService.updateIngredient(id, input);
    }

}