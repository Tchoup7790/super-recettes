package com.group.SuperRecipes.controller;

import com.group.SuperRecipes.model.dao.Recipe;
import com.group.SuperRecipes.model.dto.CreateRecipeInput;
import com.group.SuperRecipes.service.RecipeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/recipes")
public class RecipeController {
    private final RecipeService service;

    public RecipeController(RecipeService service) {
        this.service = service;
    }

    @GetMapping
    public List<Recipe> all() {
        return service.findAll();
    }

    @PostMapping
    public Recipe save(@RequestBody CreateRecipeInput category) {
        return service.save(category);
    }

    @GetMapping("/{id}")
    public Recipe one(@PathVariable String id) {
        return service.findById(id);
    }

    @PutMapping("/{id}")
    public Recipe updateRecipe(@PathVariable String id, @RequestBody CreateRecipeInput input) {
        return service.update(id, input);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);
    }
}
