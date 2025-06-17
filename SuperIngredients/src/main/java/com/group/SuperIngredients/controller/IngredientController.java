package com.group.SuperIngredients.controller;

import com.group.SuperIngredients.model.dao.Ingredient;
import com.group.SuperIngredients.model.dto.CreateIngredientInput;
import com.group.SuperIngredients.service.IngredientService;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/ingredients")
public class IngredientController {

    private final IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @GetMapping
    public List<Ingredient> getAllIngredients() {
        return ingredientService.getAllIngredient();
    }

    @GetMapping("/{id}")
    public Ingredient getIngredientById(@PathVariable String id) {
        return ingredientService.getIngredientById(id);
    }

    @PostMapping
    public Ingredient createIngredient(@RequestBody CreateIngredientInput input) {
        return ingredientService.createIngredient(input);
    }

    @PutMapping("/{id}")
    public Ingredient updateIngredient(@PathVariable String id, @RequestBody CreateIngredientInput input) {
        return ingredientService.updateIngredient(id, input);
    }

    @DeleteMapping("/{id}")
    // NOTE: If an Ingredient is link with a recipies this doesn't work
    public void deleteIngredient(@PathVariable String id) {
        ingredientService.deleteIngredient(id);
    }
}
